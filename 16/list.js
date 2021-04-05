//배열
var a =  [1,2,3,"hello", null, true,[[{1:0}]]];
console.log(a.length);

a[1000] = 10;
console.log(a.length);

a.push(5);

console.log([1,2,3].indexOf(3)); // 특정값이 어디에  들어 있는지 확인
console.log([1,2,3].join()); // 배열의 문자열로 합침
console.log([1,2,3,4].concat(2,3)); //배열을 합칠수 있음 

var origin = [1,2,3,4];
var  changeArray = [...origin,2,3,];

var fun = function(v,i,o){
  console.log(v);
  
}

changeArray.forEach(fun);

var mapped = changeArray.map(function(v){
    return v * 2; //array 원소를 돌면서 값을 변형, 새로운 배열로 만들어서 반환
  
});  //반환 값이 있음

console.log(mapped);


// 객체
var obj = 
    {
      key : "value" , 
      addition : 
      [{name: 'codesquad'},
       {age:2}]}


console.log(obj["key"]);
console.log(obj.addition[0].name);

for(key in obj){
  console.log(obj[key]);
}

Object.keys(obj).forEach(function(v){
    console.log(obj[v]); 
});


/*
    for in 문은 key 값을 반환함 따라서 value가 궁금하다면 data[key]를 통해 검색 
    forEach는 객체 그대로를 반환 value가 궁금하다면 v["key"], v.key를 통해 검색
*/