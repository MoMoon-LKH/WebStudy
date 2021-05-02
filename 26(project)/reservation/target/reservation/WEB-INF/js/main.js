var tab = 0;

/*window.load().ajax({
    url:"/api/products",
    type: "GET",
    data_type:'json',
    data:{
        "tabNum": tab
    },
    success: function (item){
        for (var i = 0; i < item.length; i++){
            addItem(item[i]);
        }
    },
    error: function (){
        alert("실패");
    }
});*/

function ajax(data){
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load",function(){

    });
    oReq.open("GET","http://localhost:8080/api/products/getData?tabNum=data");
    oReq.send();
}

function addItem(item){
    var teg =  '<li class="item">';
    tag += '<a href="" >';
    tag += '<div class="item_container">';
    tag += '<img alt="' + item.description + '" src=' + item.fileName + '"../../img">';
    tag += '</div> <div class="item_text">';
    tag += '<h4 class="item_text_des">' + item.description +
        '<small>'+ item.placeName + '</small></h4><p>' + item.content + '</p></div>';
    tag += '</a></li>';

}


