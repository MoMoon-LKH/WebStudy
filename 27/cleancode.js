/*
이름 (코딩컨벤션)
1. 목적에 맞게 이름이 지어졌는지
2. 함수 안에 내용은 이름에 맞는 하나의 로직을 가지고 있는지
3. 동사+명사이며 함수의 의도를 충분히 반영하는지
4.카멜표기법 또는 _를 중간에 사용했는지
5.변수는 명사이며 의미있는 이름인지

의도가 드러난 구현패턴
var a = value * 19.2; 중에
19.2가 무엇을 의미하는지 알 수가 없다.
따라서 19.2를 변수로 저장하고, 적절한 이름을 사용
*/

//최대한 지역변수로 사용하기
var a = 'hello';

function print() {
   return data;
}


function exec() {
   var data = "world";
   a = a + " ";
   print(a + data)
}

// 빠른 반환으로 if문 중첩 없애기
function foo(pobi,crong) {
    if(pobi) { 
      if(crong) {
        return true;
      }
    }
  }

  
function foo(pobi,crong) {
    if(!pobi) return;
    if(crong) {
      return true;
    }
  }
