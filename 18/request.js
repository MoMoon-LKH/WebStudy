var count = 0;
var el = document.querySelector(".outside");
el.style.left = "0px";

function run(){
    if(count > 35) return;
    count = count + 1;
    el.style.left = parseInt(el.style.left) + count + "px";
    // 숫자와 문자열을 더하면 문자열
    requestAnimationFrame(run);
}
requestAnimationFrame(run);