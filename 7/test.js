//이벤트 등록
// var el = document.querySelector(".outside");

// el.addEventListener("click", function(e){
//     console.log("clicked",e);
//     var target = e.target;
//     console.log(target.className,target.nodeName);
// });

//Ajax 실행 코드
function reqListener(){
    console.log(this.reponseText);
}

var oReq = new XMLHttpRequest();
oReq.addEventListener("load", reqListener);
oReq.open("GET", "./json.txt");
oReq.send();