(() => {
    let searchInput = document.querySelector("#searchInput");
    searchInput.addEventListener("keyup", () => searchGenres());

    function searchGenres() {
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

    function getGenreSinglePage(genreId) {
        fetch(`http://localhost:8082/genresingle`)
                .then(response => response.text())
                .then(data => goToGenreSinglePage(data, genreId));
    }

    function goToGenreSinglePage(data, genreId) {
        window.location = `${data}?id=${genreId}`;
    }

    fetch(`http://localhost:8082/genres/read`)
        .then((response) => {
            if (response.status !== 200) {
                console.error(`status: ${reponse.status}`);
                return;
            }
            response.json() // 3
                .then(data => createGenres(data))
        }).catch((err) => console.error(`${err}`));

    function createGenres(genres) {
        for (genre in genres) {
            createGenreCard(genres[genre]);
        }
    }

    function createGenreCard(genre) {
        let cardGroup = document.querySelector("#card-group");

        let card = document.createElement("div");
        card.setAttribute("class", "card-box");
        card.onclick = () => {
            getGenreSinglePage(genre.id);
        }
        cardGroup.appendChild(card);

        let cardImage = document.createElement("img");
        cardImage.setAttribute("class", "card-img-top");
        cardImage.setAttribute("alt", genre.image.name);
        cardImage.setAttribute("src", "data:image/" + genre.image.type + ";base64," + genre.image.picByte);
        card.appendChild(cardImage);
        
        let imageOverlay = document.createElement("div");
        imageOverlay.setAttribute("class", "image_overlay");
        card.appendChild(imageOverlay);

        let titleCard = document.createElement("p");
        titleCard.setAttribute("class", "title-card");
        titleCard.innerText = genre.name;
        imageOverlay.appendChild(titleCard);
    }
}
)();