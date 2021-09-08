
(() => {
    let searchInput = document.querySelector("#searchInput");
    searchInput.addEventListener("keyup", () => searchAlbums());

    function searchAlbums() {
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

    function getAlbumSinglePage(albumId) {
        fetch(`http://localhost:8082/albumsingle`)
                .then(response => response.text())
                .then(data => goToAlbumSinglePage(data, albumId));
    }

    function goToAlbumSinglePage(data, albumId) {
        window.location = `${data}?id=${albumId}`;
    }

    fetch(`http://localhost:8082/albums/read`)
        .then((response) => {
            if (response.status !== 200) {
                console.error(`status: ${reponse.status}`);
                return;
            }
            response.json() // 3
                .then(data => createAlbums(data))
        }).catch((err) => console.error(`${err}`));

    function createAlbums(albums) {
        for (album in albums) {
            createAlbumCard(albums[album]);
        }
    }
    
    function createAlbumCard(album) {
        let cardGroup = document.querySelector("#card-group");
        let card = document.createElement("div");
        card.setAttribute("class", "card-box");
        card.onclick = () => {
            getAlbumSinglePage(album.id);
        }
        cardGroup.appendChild(card);

        let cardImage = document.createElement("img");
        cardImage.setAttribute("class", "card-img-top");
        cardImage.setAttribute("src", "data:image/" + album.cover.type + ";base64," + album.cover.picByte);
        cardImage.setAttribute("alt", album.cover.name);
        card.appendChild(cardImage);

        let imageOverlay = document.createElement("div");
        imageOverlay.setAttribute("class", "image_overlay");
        card.appendChild(imageOverlay);

        let titleCard = document.createElement("p");
        titleCard.setAttribute("class", "title-card");
        titleCard.innerText = album.name;
        imageOverlay.appendChild(titleCard);
    }
}
)();

