var id = document.getElementById("idValue").value;
var head = document.querySelector("#dis").innerText;
var comment = document.querySelector("#comment").innerText;
var bottom = document.querySelector("#bottom").innerText;
var bindHead = Handlebars.compile(head);
var bindComment = Handlebars.compile(comment);
var bindBottom = Handlebars.compile(bottom);


$(document).ready(function () {

    var items = initialAjax(id);
    var description = items.display[0].description;
    var images = items.images;
    var mapImage ="../../img_map/" + items.mapImage;
    console.log(items);
    console.log(mapImage);




    var displayHTML = bindHead(items);
    var commentHTML = bindComment(items);
    var bottomHTML = bindBottom(items);


    var head = document.querySelector(".head");
    head.innerHTML = displayHTML;
    var comm = document.querySelector(".rating");
    comm.innerHTML = commentHTML;
    var bot = document.querySelector(".bottoms");
    bot.innerHTML = bottomHTML;

    $(".comment_description").text(description);
    $("#comment_len").text(items.comments.length + "건");
    $("#imgLength").text(images.length);
    document.getElementById("direction_map").src = mapImage;


});


function initialAjax(id){
    var items;
    $.ajax({
        url: "/products/" + id,
        type: 'GET',
        async: false,
        success: function (data){
            items = data;
        },
        error: function (error){
        }
    });
    return items;
}





