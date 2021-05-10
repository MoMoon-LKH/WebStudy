var data = [{title: "hello", content: "간지철철", price: 12000},
           {title: "crong", content: "괜찮은 상품", price: 6000},
           {title: "codesquad", content: "쩌는 상품", price: 1200}];

for(var i = 0; i < data.length; i++){
  console.log(data[i].title, data[i].price);
}

data.forEach(function(v){
  console.log(v.title, v.price);
}); //전체 배열을 돈다. function임
/* forEach의 장점은 for문에서 사용하는 i나 length를 판단할 필요가 없음
   따라서 코드의 실수를 줄일 수 있다. */


var newData = data.map(function(v){
    return v.price * 1.1;
});
/* map는 새로운 배열을 만들어서 요소를 저장 
   return 값이 필요함 */  
console.log(newData);



var newData = data.map(function(v){
    var obj = {name : v.title, content: v.content, price: v.price *10};
    return obj;
});
  // 새로운 Object 반환
console.table(data);
console.table(newData);

var newData = data.filter(function(v){
    return v.price > 5000;
});
/* 필터에 해당되는 객체만 리턴 */
console.table(newData);


var newData = data.filter(function(v){
    return v.price > 5000;
}).map(function(v){

}); // 필터된 값으로 추가 함수 가능 

//--------------------------------------------------

var healthObj = {
    name : "달리기",
    lastTime : "PM10:12",
    showHealth : function() {
      console.log(this.name + "님, 오늘은 " + this.lastTime + "에 운동을 하셨네요");
    }
  }
  
  healthObj.showHealth();


  var healthObj = {
    name : "달리기",
    lastTime : "PM10:12",
    showHealth : function() {
      setTimeout(function() {
          console.log(this.name + "님, 오늘은 " + this.lastTime + "에 운동을 하셨네요");      
      }.bind(this), 1000);
    }
  }  
  healthObj.showHealth();
 /* 
 bind 없이 사용하면 this값이 undefined로 출력
 setTimeout 함수 내에 있기 때문에 this는 window를 가르킴
 따라서 bind() 함수로 this는 healthObj를 가르킬 수 있게 지정

 */

 var healthObj = {
    name : "달리기",
    lastTime : "PM10:12",
    showHealth : function() {
      setTimeout(() => { //어로우 함수 
          console.log(this.name + "님, 오늘은 " + this.lastTime + "에 운동을 하셨네요");      
      }, 1000);
    }
  }  
  healthObj.showHealth();

/*
어로우 함수는 this의 context가 유지되면서 동작
따라서 bind() 함수를 안써줘도 정상 동작을 함
*/