$(function() {
   $(".dataRow").click(function(){
    //alert("click");
		let no = $(this).find(".no").text();
		//어떤 모듈을 클릭했는지 알아내 보자
		if($(this).hasClass("board")){
			//alert("일반게시판 클릭")
			location = "/board/view.do?no=" + no + "&inc=1";
		}else if($(this).hasClass("image")){
			//alert("이미지게시판 클릭")
			location = "/image/view.do?no=" + no;
		}else if($(this).hasClass("notice")){
			//alert("이미지게시판 클릭")
			location = "/notice/view.do?no=" + no;
		}//end of else if
   });
  //end of click(function)
});
//end of $(function)
