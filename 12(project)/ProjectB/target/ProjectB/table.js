function update(){
    var id = document.getElementById('id').value;
    var type = document.getElementById('type').value;
    if(type === "TODO"){
        type = "DOING"
    } else if (type === "DOING") {
        type = "DONE";
    }
    updateAjax(id, type);

}

function updateAjax(id, type){
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function () {
        getList();
    });
    oReq.open("GET", "/typeUpdate/getData?id=id&type=type");
    oReq.send();
}

function getList(){
    var table = document.getElementById('table');
    var todoCount = 0;
    var doingCount = 0;
    var doneCount = 0;
    var list = '${list}';
    var newCell = table.insertCell();

    for (var i = 0; i < list.length; i++) {
        var obj = list[i];
        var rows = table.rows.length;

        if ((rows > todoCount) | (rows > doingCount) | (rows > doneCount) ) {
            newCell = table.insertCell();
        }

        if(obj.type === "TODO"){
            var row = table.closest('tr')[todoCount].rowIndex;
            row[0].innerHTML = addCell(obj[i]);
            todoCount++;
        } else if (obj.type === "DOING") {
            var row = table.closest('tr')[doingCount].rowIndex;
            row[1].innerHTML = addCell(obj[i]);
            doingCount++;
        } else if (obj.type ==="DONE") {
            var row = table.closest('tr')[doneCount].rowIndex;
            row[2].innerHTML = addCell(obj[i]);
            doneCount++;
        }
    }

}

function addCell(obj){
    var tag = '<th className="cell">';
    tag += '<div id="id" style="display: none">' + obj.id + '</div>';
    tag += '< div id="obTitle">' + obj.title + '</div>';
    tag += '<div id="type" style="display: none">'+obj.type+'</div>';
    tag += '<div id="todoContent">';
    tag += '<span>등록날짜:</span><span id="date">' + obj.regDate + '</span><span> </span>';
    tag += '<span id="name">' + obj.name + '</span><span> </span><span>우선순위: </span><span id="sequence">' + obj.sequence + '</span><span>   </span>';
    tag += '<button id="toDoConBtn" onClick="update()" style="margin-left: 30px">-></button>';
    tag += '</div></th>';
}
