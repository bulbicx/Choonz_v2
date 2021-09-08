(() => {
  const urlParams = new URLSearchParams(window.location.search);
  const myParam = urlParams.get('id');
  let playlistContainer = document.querySelector(".playlist-container");
  let addBtn = document.querySelector(".add");
  let deleteBtn = document.querySelector(".delete");
  let trackId;

  const removeTrackFromPlaylist = async (trackId) => {
    await fetch(`http://localhost:8082/playlists/${myParam}/removeTrack/${trackId}`, {
      method: "PUT",
      headers: {
        "Content-type": "application/json"
      }
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));
    
    alert("Track deleted!");
    location.reload();
  }

  const loadDeleteTrack = async () => {
    await fetch(`http://localhost:8082/playlists/read/${myParam}`)
      .then((response) => {
          if (response.status !== 200) {
              console.error(`status: ${reponse.status}`);
              return;
          }
          return response.json() 
      })
      .then(data => {
        let selectDelete = document.querySelector(".track-list-dropdown-delete");
        selectDelete.addEventListener("change", () => getPlaylistIdDropdown());
        
        for (let i = 0; i < data.tracks.length; i++) {
          let option = document.createElement("option");
          option.setAttribute("value", data.tracks[i].id);
          option.innerHTML = data.tracks[i].name;
          selectDelete.appendChild(option);
        }
        })
      .catch((err) => console.error(`${ err }`));
  }
  loadDeleteTrack();

  const getPlaylistIdDropdown = () => {
    trackId = document.querySelector(".track-list-dropdown-delete").value;
  }

  const buildHeaderPage = (name, description) => {
    let header = document.createElement("header");
    header.setAttribute("id", "header-page");
    let h2 = document.createElement("h2");
    h2.setAttribute("id", "title-page");
    h2.innerText = name;
    header.appendChild(h2);
    let p = document.createElement("p");
    p.setAttribute("id", "playlist-description");
    p.innerText = description;
    header.appendChild(p);
    playlistContainer.appendChild(header);
  }

  const buildTracksList = (tracks) => {
    let trackList = document.createElement("section");
    trackList.setAttribute("class", "track-list");
    playlistContainer.appendChild(trackList);
    
    let header = document.createElement("header");
    header.setAttribute("class", "header-tracks");
    trackList.appendChild(header);
    let tracksTitle = document.createElement("h3");
    tracksTitle.setAttribute("class", "tracks-title");
    tracksTitle.innerText = "List of tracks";
    header.appendChild(tracksTitle);
    let plusIcon = document.createElement("i");
    plusIcon.setAttribute("class", "bi bi-plus-circle-fill bi-track");
    plusIcon.setAttribute("type", "button");
    plusIcon.setAttribute("data-bs-toggle", "modal");
    plusIcon.setAttribute("data-bs-target", "#add-track");
    plusIcon.innerText = " Add track";
    header.appendChild(plusIcon);

    let removeIcon = document.createElement("i");
    removeIcon.setAttribute("class", "bi bi-trash-fill mx-3");
    removeIcon.setAttribute("type" ,"button");
    removeIcon.setAttribute("data-bs-toggle", "modal");
    removeIcon.setAttribute("data-bs-target", "#delete-track");
    removeIcon.innerText = " Delete track";
    header.appendChild(removeIcon);

    let section = document.createElement("section");
    section.setAttribute("class", "row");
    trackList.appendChild(section);

    for (let i = 0; i < tracks.length; i++) {
      let card = document.createElement("div");
      card.setAttribute("class", "card-box");
      card.addEventListener("click", () => getTrackSinglePage(tracks[i].id));
      section.appendChild(card);
  
      let img = document.createElement("img");
      img.setAttribute("src", "https://cdn.pixabay.com/photo/2015/08/10/21/26/vinyl-883199_960_720.png");
      img.setAttribute("class", "card-img-top card-background");
      img.setAttribute("alt", tracks[i].name);
      card.appendChild(img);

      let imageOverlay = document.createElement("div");
      imageOverlay.setAttribute("class", "image_overlay");
      card.appendChild(imageOverlay);

      let titleCard = document.createElement("p");
      titleCard.setAttribute("class", "title-card");
      titleCard.innerText = tracks[i].name;
      imageOverlay.appendChild(titleCard);
    }
  }

  const buildPage = (data) => {
    buildHeaderPage(data.name, data.description);
    buildTracksList(data.tracks);
  }

  const fetchPlaylistSingle = () => {
    fetch(`http://localhost:8082/playlists/read/${myParam}`)
      .then((response) => {
          if (response.status !== 200) {
              console.error(`status: ${reponse.status}`);
              return;
          }
          return response.json() 
      })
      .then(data => buildPage(data))
      .catch((err) => console.error(`${ err }`));
  }
  fetchPlaylistSingle();

  const addTracksOnDropdown = (existingTracks) => {
    fetch(`http://localhost:8082/playlists/read/${myParam}`)
      .then((response) => {
        if (response.status !== 200) {
            console.error(`status: ${reponse.status}`);
            return;
        }
        return response.json() 
      })
      .then(data => {
        let select = document.querySelector(".track-list-dropdown");
        for (let z = 0; z < existingTracks.length; z++) {
          let isOnPlaylist = false;
          for (let i = 0; i < data.tracks.length; i++) {
            if (existingTracks[z].name === data.tracks[i].name) {
              isOnPlaylist = true;
            }
  
          }
          if (!isOnPlaylist) {
            let option = document.createElement("option");
            option.setAttribute("value", existingTracks[z].id);
            option.innerHTML = existingTracks[z].name;
            select.appendChild(option);
            isOnPlaylist = false;
          }
        }
      })
      .catch((err) => console.error(`${ err }`));
  }

  const getAllTracks = async () => {
    await fetch(`http://localhost:8082/tracks/read`)
    .then(response => response.json())
    .then(tracks => addTracksOnDropdown(tracks))
    .catch(error => console.error(error));
  }
  getAllTracks();

  const goToTrackSinglePage = (data, trackId) => {
    window.location = `${data}?id=${trackId}`;
  }

  const getTrackSinglePage = (trackId) => {
    fetch(`http://localhost:8082/track`)
      .then(response => response.text())
      .then(data => goToTrackSinglePage(data, trackId));
  }

  const addTrackToPlaylist = async (playlistId, trackId) => {
    await fetch(`http://localhost:8082/playlists/${playlistId}/addTrack/${trackId}`, {
      method: "PUT",
      headers: {
        "Content-type": "application/json"
      }
    })
    .then(response => response.json())
    .then(data => alert("Track added!"))
    .catch(error => console.error(error));
    
    location.reload();
  }

  const displayErrorMessage = (msg) => {
    let alert = document.querySelector("#alert");
    alert.setAttribute("class", "mt-4 alert alert-danger");
    alert.innerText = msg;
  }

  const retrieveAddFormDetails = () => {
    let track = document.querySelector("#track-list").value;

    if (track !== "") {
      addTrackToPlaylist(myParam, track);
    } else {
      displayErrorMessage("A track must be selected!");
    }
  }

  addBtn.addEventListener("click", () => retrieveAddFormDetails());
  deleteBtn.addEventListener("click", () => removeTrackFromPlaylist(trackId));
})();