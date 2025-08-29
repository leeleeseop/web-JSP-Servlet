// Date 객체를 선언, 현재 시간 측정
let date = new Date();
let hours = date.getHours();

// 조건문
if (hours < 5) {
    alert('잠을 자다');
} else if (hours < 7){
    alert('준비');
} else if (hours < 9){
    alert('출근');
} else if(hours < 12){
    alert('곧 점심시간');
} else if(hours < 13){
    alert('식사');
} else {
    alert('여러 업무');
}
