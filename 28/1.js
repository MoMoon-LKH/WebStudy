//객체
var healthObj = {
    name : "달리기",
    lastTime : "PM 11:12",
    showHealth : function(){
        console.log(this.name + "님, 오늘은 " + this.lastTime + "에 운동하셨네요.");
    }
}

healthObj.showHealth();

// 동적 객체 생성
function Health(name, lastTime){
    this.name = name;
    this.lastTime = lastTime;
    this.showHealth = function(){
        return this.name + "님, 오늘은 " + this.lastTime + "에 운동하셨네요.";
    }
}

const h = new Health("달리기", "10:12");
console.log(h.showHealth());


/*
  prototype
  같은 메모리 공간에 객체마다 똑같은 메소드를 배치 시킬 수 있음
  즉, 메소드 재사용이 가능
*/

console.log(healthObj.showHealth === h.showHealth); //false

function HealthP(name, lastTime){
    this.name = name;
    this.lastTime = lastTime;
   
}

HealthP.prototype.showHealth = function(){ //prototype 선언
  return this.name + "님, 오늘은 " + this.lastTime + "에 운동하셨네요.";
}

const h1 = new HealthP("crong", "AM 10:00");
const h2 = new HealthP("crong2", "PM 08:00");

console.log(h1.showHealth === h2.showHealth); // true