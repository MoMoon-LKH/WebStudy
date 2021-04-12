let count = 0;
function animate(){
    setTimeout(()=>{
        if(count >= 20) return;
        console.log('현재 시각은 ',new Date());
        count++;
        animate();
    },500);
}
animate();