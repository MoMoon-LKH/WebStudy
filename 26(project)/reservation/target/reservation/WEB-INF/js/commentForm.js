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

$('.star_score .stars').click(function () {
    var score = $(this).attr('value');
    $('.star_num').text(score)
    $(this).parent().children('.stars').removeClass('on');
    $(this).addClass('on').prevAll('.stars').addClass('on');
    return false;
});

$('#comment').keyup(function () {
    var content = $(this).val();
    $('#stringLength').html(content.length);

    if (content.length > 400) {
        alert("최대 400자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 400));
        $('#stringLength').html(400);

    }
});

