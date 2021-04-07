//DOM API
var a = documnet.querySelector("id");
a.tagName;
a.innerHTML; 
a.firstChild; // 공백도 인정
a.firstElementChild; //공백 제외, 따라서 주로 쓰임
a.remove;

var div = document.createElement("div");
var str = document.createTextNode("오늘 하루는 정말 ... 좋아");
div.appendChild(str);
$0.appendChild(div);  // $0는 크롬 개발자 도구에서 지원해줌, 선택한 태그의 정보를 바로 가져옴

var base = documnet.querySelector(".table tr:nth-child(3)");
var parent = documnet.querySelector(".table tbody");
var div = document.createElement("div");
var str = document.createTextNode("여기에 추가됐어요");
div.appendChild(str);
parent.insertBefore(div, base); // div를 base 앞에 추가


var parent = documnet.querySelector(".table tbody");
parent.innerHTML; // getter
parent.innerHTML = "<p>child...<p>"; // setter

/*
var mango = document.createElement("li");
var mangoText = document.createTextNode("망고");
mango.appendChild(mangoText);

var parent = document.querySelector("ul");

var banana = document.querySelector("li:nth-child(3)");


parent.insertBefore(mango, banana)
*/

/*
var banana = document.querySelector("li:nth-child(3)");
var orange = document.querySelector("li:nth-child(2)");
orange.insertAdjacentHTML('afterend',"<li>망고</li>");
banana.insertAdjacentHTML('beforebegin',"<li>망고</li>");
*/

/*
var berry = document.querySelector("li:nth-child(5)");
var apple = document.querySelector("li:nth-child(1)");
var ul =  document.querySelector("ul");

ul.insertBefore(apple, berry); // node를 옮길 때 유용
*/

var reds = document.querySelectorAll("li.red");
var parent = document.querySelector("ul");
for(var i = 0; i<reds.length; i++){
  parent.removeChild(reds[i]);
}


var bluenode = document.querySelector("section .blue");

Array.from(bluenode).forEach((function(v){
  var section = v.closet("section");
  var h2 = section.querySelector("h2");
  section.removeChild(h2);
}));


/*
for(var i = 0; i < bluenode.length; i++){
  var section = bluenode[i].closest("section");
  var h2 = section.querySelector("h2");
  console.log(h2);
  section.removeChild(h2);
}
*/