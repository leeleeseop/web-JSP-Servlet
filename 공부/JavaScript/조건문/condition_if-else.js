// 변수를 선언합니다.
//현재 날짜와 시간을 나타, date라는 이름의 변수에 Date를 저장 
let date = new Date(); 
// Hours 뒤에 ()를 붙여 실행해야 현재 시각의 시(hour)의 값을 가져옴 
let hours = date.getHours; 

// 조건문
if (hours < 12 ) {
  // hours 값이 0 ~ 11 오전
  alert(' 오전입니다 ');
} else {
  // hours < 12 가 거짓일 때 실행
  // 12 ~ 23 오후
  alert(' 오후입니다 ');
}
