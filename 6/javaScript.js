//논리 연산자
var name = "crong";
var result = name || "codesquad";
console.log(result);

//삼항 연산자
var data = 11;
var result = (data>10)? "ok" : "fail";
console.log(result);

//함수
function printName(name){     // 함수 선언문
    return "my name : " + name;
  }
  
console.log(printName()); //name = undefined
console.log(printName("Jisu"));
console.log(printName("Jisu", "Kiho")); // Jisu만 출력

//함수 표현식
function printName(name){
    var inner = function(){  // result 와 위치가 바뀌면 result는 inner()를 인식 X but 함수 선언문으로 바뀌면 가능, 함수 표현식
      return "inner value";
    }
   
    var result = inner();
    console.log("name is  " + result);
}

printName();

/*
호이스팅(hoisting)
function printName(){
    var result = inner();
    var inner = function(){}
}
위 코드에서 inner가 실행되는 순간 is not defined 오류가 아닌 function이 아니라고 나오는 이유는
function printName(){
    var inner; -> 호이스팅

    var result = inner(); // undefined
    inner = function(){} 
} 로 함수 안에 필요한 변수들을 모두 끌어올려서 선언하기 때문 따라서 inner를 값이 할당되기 전에 실행되었으므로 undefined이 할당됨
*/

//function의 반환값이 없다면 undefined를 반환 (void는 없음)


/*
arguments
자바 스크립트의 함수는 선언한 파라미터보다 더 많은 인자를 보낼 수 있다.
이때 넘어온 인자를 arguments로 배열의 형태로 하나씩 접근이 가능
but argumnets는 배열 타입이 X
*/
function a(){
    console.log(arguments);
  }
  a(1,2,3);
  
  //출력값 : [object Arguments] { 0: 1, 1: 2, 2: 3 }


  //arrow function (함수 표현식)
  function getName(name){
      reuturn "Kim " + name;  
  }

  var getName = (name) => "Kim " + name; //arrow function
