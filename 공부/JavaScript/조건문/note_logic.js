    let date = new Date();
    // 월을 가져오지만 0부터 시작 월을 구할려면 +1을 해줘야함
    let month = date.getMonth() + 1;

    // month이 3이상 5이하일때 true
    if (3 <= month && month <= 5) {
        alert('봄입니다');
    } else if (6 <= month && month <= 8){
        alert('여름입니다');
    } else if(9 <= month && month <= 11){
        alert('가을입니다');
    } else {
        alert('겨울입니다');
    }
