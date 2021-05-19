/*
    정규표현식(regular expression)
    문자열의 특정 패턴을 찾을 수 잇는 문법
    패턴을 찾아서 추출, 삭제, 치환등의 문자열 조작을 할 수 있음
    =========
    이메일, 주소, 전화번호 규칙 검증
    textarea에 입력된 것들 중에서 불필요한 입력값 추출
    트랜스파일링
    개발도구에서의 문자열 치환
*/

console.log("1".match(/1/));
console.log("a52b".match(/52/));

//문자열안에 있는 모든 두자리 숫자 찾기
console.log("g99b".match(/\d\d/));

var target = "abc32zzz";
var r = /\d\d/;
var result = target.match(r);
console.log(result);


/*
    {} 자릿수
    [] 포함하는 값     
*/ 

console.log("82404".match(/(\d{3}-\d{3}|[0-8]\d{4})/)[0]);

console.log("62404".match(/(\d{3}-\d{3}|[0-46-8]\d{4})/)[0]); // 5, 9 제외

console.log("010-9021-0111".match(/\d{3}-\d{4}-\d{4}/)[0]);
console.log("010-901-0111".match(/01[01789]-\d{3,4}-\d{4}/)[0]); // 중간 자리 3~4 자리

console.log("011-021-0011".replace(/(\d{2})\d/, "$10")); 
//3번째 자리의 숫자를 0으로 변환  $1는 (\d{2})의 값, 앞에 두자리를 가르킴

console.log("###iloveyou$$$".replace(/.*([a-zA-Z]{8}).*/,"$1"));
//문자열 앞뒤 짜르기

console.log("012-230-023-021".match(/\d.*-/));
console.log("012-230-023-021".match(/\d.*?-/));
// .*는 끝까지 특정 찾아가서 출력해줌 (012-230-023-)
// .*?는 찾은 순간 출력 (012-)