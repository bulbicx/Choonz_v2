(() => {
  let cardGroup;

  // Playlist
  const getAllPlaylists = async () => {
    await fetch(`http://localhost:8082/playlists/read`)
    .then(response => response.json())
    .then(data => displaySection(data, "Playlist"))
    .catch(error => console.error(error));
  }
  getAllPlaylists();

  const goToPlaylistSinglePage = (data, playlistId) => {
    window.location = `${data}?id=${playlistId}`;
  }

  const getPlaylistSinglePage = (playlistId) => {
    fetch(`http://localhost:8082/playlistsingle`)
      .then(response => response.text())
      .then(data => goToPlaylistSinglePage(data, playlistId));
  }

  // Albums
  const getAllAlbums = async () => {
    await fetch(`http://localhost:8082/albums/read`)
    .then(response => response.json())
    .then(data => displaySection(data, "Albums"))
    .catch(error => console.error(error));
  }
  getAllAlbums();

  const goToAlbumSinglePage = (data, albumId) => {
    window.location = `${data}?id=${albumId}`;
  }

  const getAlbumSinglePage = (albumId) => {
    fetch(`http://localhost:8082/albumsingle`)
      .then(response => response.text())
      .then(data => goToAlbumSinglePage(data, albumId));
  }

  // Tracks
  const getAllTracks = async () => {
    await fetch(`http://localhost:8082/tracks/read`)
    .then(response => response.json())
    .then(data => displaySection(data, "Tracks"))
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

  // Artists
  const getAllArtists = async () => {
    await fetch(`http://localhost:8082/artists/read`)
    .then(response => response.json())
    .then(data => displaySection(data, "Artists"))
    .catch(error => console.error(error));
  }
  getAllArtists();

  const goToArtistSinglePage = (data, artistId) => {
    window.location = `${data}?id=${artistId}`;
  }

  const getArtistSinglePage = (artistId) => {
    fetch(`http://localhost:8082/artistsingle`)
      .then(response => response.text())
      .then(data => goToArtistSinglePage(data, artistId));
  }

  // Genres
  const getAllGenres = async () => {
    await fetch(`http://localhost:8082/genres/read`)
    .then(response => response.json())
    .then(data => displaySection(data, "Genres"))
    .catch(error => console.error(error));
  }
  getAllGenres();

  const goToGenreSinglePage = (data, genreId) => {
    window.location = `${data}?id=${genreId}`;
  }

  const getGenreSinglePage = (genreId) => {
    fetch(`http://localhost:8082/genresingle`)
      .then(response => response.text())
      .then(data => goToGenreSinglePage(data, genreId));
  }

  const getActionType = (sectionName, data) => {
    if (sectionName === "Playlist") {
      getPlaylistSinglePage(data.id);
      return;
    } else if (sectionName === "Albums") {
      getAlbumSinglePage(data.id);
      return;
    } else if (sectionName === "Tracks") {
      getTrackSinglePage(data.id);
      return;
    } else if (sectionName === "Artists") {
      getArtistSinglePage(data.id);
      return;
    } else if (sectionName === "Genres") {
      getGenreSinglePage(data.id);
      return;
    }
  }

  const goToPlaylistsPage = () => {
    fetch(`http://localhost:8082/playlist`)
      .then(response => response.text())
      .then(window.location = `playlists.html`);
  }

  const goToGenresPage = () => {
    fetch(`http://localhost:8082/genres`)
      .then(response => response.text())
      .then(window.location = `genres.html`);
  }

  const goToAlbumsPage = () => {
    fetch(`http://localhost:8082/albums`)
      .then(response => response.text())
      .then(window.location = `albums.html`);
  }

  const goToArtistsPage = () => {
    fetch(`http://localhost:8082/artists`)
      .then(response => response.text())
      .then(window.location = `artists.html`);
  }

  const createCards = (data, sectionType, cardGroup) => {
    for (let i = 0; i < data.length; i++) {
      let cardBox = document.createElement("div");
      cardBox.setAttribute("class", `card-box card-${sectionType.toLowerCase()}-${data[i].id}`);
      cardGroup.appendChild(cardBox);
      let img = document.createElement("img");
      img.setAttribute("class", "card-img-top");

      if (sectionType.toLowerCase() === "playlist") {
        img.setAttribute("src", "data:image/" + data[i].artwork.type + ";base64," + data[i].artwork.picByte);
      } else if (sectionType.toLowerCase() === "artists") {
        img.setAttribute("src", "data:image/" + data[i].image.type + ";base64," + data[i].image.picByte);
      } else if (sectionType.toLowerCase() === "genres") {
        img.setAttribute("src", "data:image/" + data[i].image.type + ";base64," + data[i].image.picByte);
      } else if (sectionType.toLowerCase() === "albums") {
        img.setAttribute("src", "data:image/" + data[i].cover.type + ";base64," + data[i].cover.picByte);
      } else if (sectionType.toLowerCase() === "tracks") {
        img.setAttribute("src", "https://cdn.pixabay.com/photo/2015/08/10/21/26/vinyl-883199_960_720.png");
      }

      img.setAttribute("alt", "cover " + data[i].id);
      cardBox.appendChild(img);

      let imageOverlay = document.createElement("div");
      imageOverlay.setAttribute("class", "image_overlay");
      cardBox.appendChild(imageOverlay);

      let titleCard = document.createElement("p");
      titleCard.setAttribute("class", "title-card");
      titleCard.innerText = data[i].name;
      imageOverlay.appendChild(titleCard);

      cardBox.addEventListener("click", () => getActionType(sectionType, data[i]));
    }
  }

  const displaySection = (data, sectionType) => {
    let playlistEyeIcon = document.querySelector(".playlist-eye");
    let artistEyeIcon = document.querySelector(".artist-eye");
    let genreEyeIcon = document.querySelector(".genre-eye");
    let albumEyeIcon = document.querySelector(".album-eye");
    playlistEyeIcon.addEventListener("click", () => goToPlaylistsPage());
    artistEyeIcon.addEventListener("click", () => goToArtistsPage());
    genreEyeIcon.addEventListener("click", () => goToGenresPage());
    albumEyeIcon.addEventListener("click", () => goToAlbumsPage());
    
    if (data.length > 0) {
      if (sectionType.toLowerCase() === "playlist") {
        cardGroup = document.querySelector("#playlist-cards");
      } else if (sectionType.toLowerCase() === "artists") {
        cardGroup = document.querySelector("#artist-cards");
      } else if (sectionType.toLowerCase() === "genres") {
        cardGroup = document.querySelector("#genre-cards");
      } else if (sectionType.toLowerCase() === "albums") {
        cardGroup = document.querySelector("#album-cards");
      } else if (sectionType.toLowerCase() === "tracks") {
        cardGroup = document.querySelector("#track-cards");
      }
      createCards(data, sectionType, cardGroup)
    }
  }

})();