//window 객체
function run(){
    console.log("run start");
      setTimeout(function() {
        var msg = "hello codesquad";
        console.log(msg);
        console.log("run ing");
      }, 1000); // ms 단위

      console.log("run end");
  } /* start end ing 순으로 출력 
  ->비동기 콜백( 스택이 다 비워지고 비동기는 마지막에 진행) = 지연시켜서 함수를 실행시키는 함수
  */
run();