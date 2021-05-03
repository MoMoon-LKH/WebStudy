
var start = 0;


function loadItems(){
    $.ajax({
        url:"http://localhost:8080/api/products" ,
        type: "GET" ,
        dataType: "json",
        success: function (data){
            console.log("data : " +data);
        },
        error: function (error){
            console.log(error);
        }
    });
}

function addItem(item){

}

function addList(tag){
    var list = document.getElementsByClassName('list_items');
    list.innerHTML += tag;
}


