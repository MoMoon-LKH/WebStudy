var id = document.getElementById("idValue").value;
var head = document.querySelector("#dis").innerText;
var comment = document.querySelector("#comment").innerText;
var bottom = document.querySelector("#bottom").innerText;
var bindHead = Handlebars.compile(head);
var bindComment = Handlebars.compile(comment);
var bindBottom = Handlebars.compile(bottom);
var tabInfo = document.getElementById("detail_info");
var tabNav = document.getElementById("detail_nav");

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
    $(".direction_title").text(description);
    $("#comment_len").text(items.comments.length + "건");
    $("#imgLength").text(images.length);
    document.getElementById("direction_map").src = mapImage;



    $(".btTab").click(function(evt){
        var tab = $(evt.target).data("index");
        console.log(tab);

        if(tab == 0){
            $(".directions").hide();
            $(".detailInfo").show();
        } else if (tab == 1) {
            $(".directions").show();
            $(".detailInfo").hide();
        }
    });

    $(".moreBtn").click(function(){
        $(".foldBtn").show();
        $(".moreBtn").hide();
        var content = document.querySelector(".explainContent");
        content.style.display = "block";
        content.style.paddingBottom = "20px";
    });


    $(".foldBtn").click(function(){
        $(".foldBtn").hide();
        $(".moreBtn").show();
        var content = document.querySelector(".explainContent");
        content.style.display = "-webkit-box";
        content.style.paddingBottom = "0px";
    });

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





