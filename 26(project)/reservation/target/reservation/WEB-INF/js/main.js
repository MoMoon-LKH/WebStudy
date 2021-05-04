
var start = 0;

function addItem(){

    var list = document.getElementById('list_items');
    var tag = '<c:forEach items="${list}" var="item">';
    tag += '<li className="item" style="width: 50%; float: left">';
    tag += '<a href="products" style="text-decoration: none;">';
    tag += '<div className="item_container">';
    tag +='<img alt=item.description src="../../img/${item.fileName}" style="width: 200px; margin: 0 auto; padding: 0; display: block">';
    tag +=' <div className="item_text" style="width: 190px; text-align: left; background: white; height: 150px; margin: 0 auto; padding: 0px;">';
    tag += ' <h4 className="item_text_des" style=" font-size: 15px; ">';
    tag += '<div style="font-weight: bold">${item.description}</div>';
    tag += '<small>${item.placeName}</small>';
    tag += '</h4>';
    tag += '<p style="background: white; font-size: 13px; ">${item.content}</p>';
    tag += '</div> </div> </a> </li> </c:forEach>';

    list.innerHTML += tag;
}

function loadItems(){
    $.ajax({
        url:"http://localhost:8080/veiws/products" ,
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


