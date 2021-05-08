var start = 0;
var category = 0;
var imageIndex = 0;
var btn = document.querySelector("#btn");
var tab = document.querySelector("#tabList");
var ul = document.querySelector('.promotion_image');



$(document).ready(function () {
    var items = ajax("/products");
    var item = items.list;
    count = items.count;
    var promotion = items.promotion;
    promotionList(promotion);
    addList(item);
    countFun(count);
    slider();
});

btn.addEventListener("click", function () {
    var items = ajax("/products");
    var item = items.list;

    addList(item);
});

tab.addEventListener("click", function (evt){
    var tabItem = $(evt.target).data("category");
    if (tabItem >= 0) {
        category = tabItem;
        start = 0;
        $("#list_items").empty();
        $("#list_items2").empty();
        var items = ajax("/products");
        var item = items.list;
        count = items.count;
        addList(item);
        countFun(count);
        $(".more").show();
    }

});


function ajax(url){
    var items;
    $.ajax({
        type: 'GET',
        url: url,
        data: {"category": category, 'start': start},
        async: false,
        success: function (data){
            items = data;
        },
        error: function (er){
            console.log(er);
        }
    });
    return items;
}


function addItem(item, list){
    var tem = '<li className="item" style="width: 100%; display: inline-block; float: left; overflow: hidden">';
        tem += '<a href="" style="text-decoration: none; display: block">';
        tem += '<div className="item_container">';
        tem += '<img alt=item.description src="../../img/'+ item.fileName + '"  style="width: 200px; margin: 0 auto; padding: 0; opacity: 1">';
        tem += '<div className="item_text" style="width: 200px; text-align: left; background: white;  margin: -3px 3px; padding: 0;">';
        tem += '<h4 className="item_text_des" style=" margin: 0; padding: 0; color: black; ">';
        tem += '<div style="font-weight: bold; font-size: 14px; padding: 10px 0 3px 5px">'+ item.description + '</div>';
        tem += '<small style="font-weight: normal; word-break: break-all;  font-size: 12px; padding: 0 0 3px 5px">' + item.placeName + '</small>';
        tem += '</h4><hr width="80%" color="lightgray" size="1">';
        tem +=  '<p style=" margin: 5px; padding: 0; font-size: 12px; color: grey;  display: -webkit-box; word-wrap: break-word; -webkit-line-clamp: 2; -webkit-box-orient: vertical; overflow: hidden"> '+ item.content + '</p>';
        tem += '</div></div></a></li>';

    if(list === 1){
        $("#list_items").append(tem);
    } else if (list === 2) {
        $("#list_items2").append(tem);
    }
}

function addList(items){

    if(items.length > 0){
        for(var i = 0; i < items.length; i+=2){
            addItem(items[i],1);
        }
        for(var i = 1; i < items.length; i+=2){
            addItem(items[i],2);
        }
    }

    if(items.length < 4){
        $(".more").hide();
    }
    start += 4;
}

function countFun(count){
    $('.list_count').each(function () {
        $(this).empty();
        var text = $(this).text();
        $(this).text(text.replace("",count + " 개 "));
    });
}

function promotionList(fileNames){
    for (var i = 0; i < fileNames.length; i++) {
        promotionAdd(fileNames[i]);
    }
    promotionAdd(fileNames[0]);
}

function promotionAdd(fileName){
    var tag ='<li class="slide"><img src="../../img/' + fileName + '"></li>';
    $(".promotion_image").append(tag);
}

function slider(){
    var s = $(".slide");
    ul.style.transform = "translateX(-" + 413.99*(imageIndex) + "px)";
    ul.style.transition = 'transform 0.2s';

    imageIndex++;

    console.log(s.length);
    if (imageIndex >= s.length) {
        imageIndex = 0;
        setTimeout(function () {
            ul.style.transform = "translateX(0px)";
            ul.style.transition = 'transform 0s';
        },10);
    }

    setTimeout(slider, 2000);
}
