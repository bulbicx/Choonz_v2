(() => {
    let searchInput = document.querySelector("#searchInput");
    searchInput.addEventListener("keyup", () => searchArtists());

    function searchArtists() {
        let txtValue;
        let filter = searchInput.value.toUpperCase();
        let card = document.getElementsByClassName("card-box");

        for (let i = 0; i < card.length; i++) {
            let p = card[i].getElementsByClassName("title-card")[0];
            txtValue = p.textContent || p.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                card[i].style.display = "";
            } else {
                card[i].style.display = "none";
            }
        }
    }

    function getArtistSinglePage(artistId) {
        fetch(`http://localhost:8082/artistsingle`)
                .then(response => response.text())
                .then(data => goToArtistSinglePage(data, artistId));
    }

    function goToArtistSinglePage(data, artistId) {
        window.location = `${data}?id=${artistId}`;
    }

    fetch(`http://localhost:8082/artists/read`)
        .then((response) => {
            if (response.status !== 200) {
                console.error(`status: ${reponse.status}`);
                return;
            }
            return response.json();
                
        })
        .then(data => createArtists(data))
        .catch((err) => console.error(`${ err }`));

    function createArtists(artists) {
        for (artist in artists) {
            createArtistCard(artists[artist]);
        }
    }

    function createArtistCard(artist) {
        let cardGroup = document.querySelector("#card-group");
        let card = document.createElement("div");
        card.setAttribute("class", "card-box");
        card.onclick = () => {
            getArtistSinglePage(artist.id);
        }
        cardGroup.appendChild(card);

        let cardImage = document.createElement("img");
        cardImage.setAttribute("class", "card-img-top");
        cardImage.setAttribute("alt", artist.name);
        cardImage.setAttribute("src", "data:image/" + artist.image.type + ";base64," + artist.image.picByte);
        card.appendChild(cardImage);

        let imageOverlay = document.createElement("div");
        imageOverlay.setAttribute("class", "image_overlay");
        card.appendChild(imageOverlay);

        let titleCard = document.createElement("p");
        titleCard.setAttribute("class", "title-card");
        titleCard.innerText = artist.name;
        imageOverlay.appendChild(titleCard);
    }
}
)();