var log = document.querySelector(".log");
var lists = document.querySelectorAll("ul > li");
var ul = document.querySelector("ul");
var img = document.querySelector("img");

img.addEventListener("click", function(){
    console.log("img clicked")
});


ul.addEventListener("click", function(evt){
    console.log(evt.target.tagName, evt.currentTarget.tagName);
    //target는 클릭한 정보를 알려줌 따라서 IMG를 가져옴

    var target = evt.target;
    if(target.tagName === "IMG"){
        log.innerHTML = "IMG URL = " + target.src;
    } else if (target.tagName === "LI"){
        log.innerHTML = "IMG URL = " + target.firstElementChild.src;
    }
});

var data = {title:"hello",
        content:"lorem",
        price:2000
    };
var html = "<li><h4>{title}</h4><p>{content}</p><div>{price}</div></li>"
html.replace("{title}".data.title)
    .replace("{content}",data.content)
    .replace("{price}",data.price);

/* 이벤트 버블링
    하위 엘리먼트에서 상위 엘리먼트까지 올라가면서 이벤트 리스너가 있는지 찾음
*/
/*
for(var i = 0, len=lists.length; i < len; i++){
    lists[i].addEventListener("click",function(evt){
        log.innerHTML = "IMG src = " +
            evt.currentTarget.firstElementChild.src;
    });
}
*/
