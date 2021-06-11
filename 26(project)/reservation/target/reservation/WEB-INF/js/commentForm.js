const image = document.querySelector("#imgInput");
image.addEventListener("change", (evt) => {
    const img = evt.target.files[0];
    const thumb = document.querySelector(".thumb_img");

    if (evt.target.files[0] != null) {
        thumb.style.display = "inline-block";
        thumb.src = window.URL.createObjectURL(img);
    } else {
        thumb.style.display = "none";
    }
});