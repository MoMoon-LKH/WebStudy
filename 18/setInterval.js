const interval = window.setInterval(()=>{
    console.log('현재 시각은 ',new Date());
}, 1000/60);

window.clearInterval(interval);