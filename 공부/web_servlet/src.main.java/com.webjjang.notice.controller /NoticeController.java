//20240711
package com.webjjang.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.webjjang.main.controller.Init;
import com.webjjang.member.vo.LoginVO;
import com.webjjang.notice.vo.NoticeVO;
import com.webjjang.util.exe.Execute;
import com.webjjang.util.page.PageObject;

// Notice Module 에 맞는 메뉴 선택 , 데이터 수집(기능별), 예외 처리
public class NoticeController {
	public String execute(HttpServletRequest request) {
		//처리 결과를 
		HttpSession session = request.getSession();
		
		int gradeNo = 0;
			LoginVO login=(LoginVO) session.getAttribute("login");
			if(login != null) {
				gradeNo = login.getGradeNo();
			}
			
			String uri = request.getRequestURI();
			Object result = null;
			String jsp = null;
			
			// 입력 받는 데이터 선언
			Long no = 0L;
    
			try { // 정상 처리
				// 메뉴 처리 : CRUD DB 처리 - Controller - Service - DAO
				switch (uri) {

            
				case "/notice/list.do":
					// [NoticeController] - (Execute) - NoticeListService - NoticeDAO.list()
					System.out.println("1.공지사항 리스트");
					PageObject pageObject = PageObject.getInstance(request);
					String period = request.getParameter("period");
					System.out.println(period);
          if(gradeNo == 9) {
            if(period == null || period == ""){
              pageObject.setPeriod("all");
            }else{
              pageObject.setPeriod(period)
            }else{
              pageObject.setPeriod("pre");
            }
          }

					// DB에서 데이터 가져오기 - 가져온 데이터는 List<NoticeVO>
					// getInstance - 기본 값이 있고 넘어오는 페이지와 검색 정보를 세팅 처리
					result = Execute.execute(Init.get(uri), pageObject);
					
					// pageObject 데이터 확인
					System.out.println("NoticeController.execute().pageObject = " + pageObject);
					
					// pageObject 담기
					request.setAttribute("pageObject", pageObject);
					request.setAttribute("list", result);
					jsp = "notice/list";
					break;

            
				case "/notice/view.do":
					System.out.println("2.공지사항 글보기");
					// 1. 조회수 1증가(글보기), 2. 공지사항 글보기 데이터 가져오기 : 글보기, 글수정
					// 사용자가 보고 싶은 글번호를 입력한다.
					no = Long.parseLong(request.getParameter("no"));
					result = Execute.execute(Init.get(uri), no);
					request.setAttribute("vo", result);
					jsp = "notice/view";
					break;

        
				case "/notice/writeForm.do":
					System.out.println("3-1.공지사항 글등록 폼");
					jsp = "notice/writeForm";
					break;
				
				
				case "/notice/write.do":
					System.out.println("3-2.공지사항 글등록");
					// 데이터 수집 - 사용자 : 제목, 내용, 작성자, 비밀번호
					String title = request.getParameter("title");
					String content = request.getParameter("content");
					String startDate = request.getParameter("startDate");
					String endDate = request.getParameter("endDate");
        
					// 변수 - vo 저장하고 Service
					NoticeVO vo = new NoticeVO();
					vo.setTitle(title);
					vo.setContent(content);
					vo.setStartDate(startDate);
					vo.setEndDate(endDate);
					
					// [NoticeController] - NoticeWriteService - NoticeDAO.write(vo)
					//vo객체를 넣어서 서비를 실행
					result = Execute.execute(Init.get(uri), vo);
					session.setAttribute("msg", "공지가 등록되었습니다");
					jsp = "redirect:list.do";
					break;

        
				case "/notice/updateForm.do":
					System.out.println("4-1.공지사항 글수정 폼");
					no = Long.parseLong(request.getParameter("no"));
					result = Execute.execute(Init.get("/notice/view.do"),no);
					request.setAttribute("vo", result);
					session.setAttribute("msg", "공지가 수정되었습니다");
					jsp="/notice/updateForm";
					break;

        
				case "/notice/update.do":
					System.out.println("4-2.공지사항 글수정");
					// 수정할 글번호를 받는다. - 데이터 수집
					no = Long.parseLong(request.getParameter("no"));
          title = request.getParameter("title");
          content = request.getParameter("content");
          startDate = request.getParameter("startDate");
          endDate = request.getParameter("endDate");
        
					// 변수 - vo 저장하고 Service
					vo = new NoticeVO();
					vo.setNo(no);
					vo.setTitle(title);
					vo.setContent(content);
					vo.setStartDate(startDate);
					vo.setEndDate(endDate);
        
					// 수정할 데이터 가져오기 - 글보기 - NoticeViewService
					result = Execute.execute(Init.get(uri), vo);
					pageObject = PageObject.getInstance(request);
					session.setAttribute("msg", "공지가 삭제되었습니다");
					jsp = "redirect:view.do?no=" + no + "&"+ pageObject.getPageQuery();
					break;
				
				
				case "/notice/delete.do":
					System.out.println("5.공지사항 글삭제");
					// 데이터 수집 - DB에서 실행에 필요한 데이터 - 글번호
					no = Long.parseLong(request.getParameter("no"));
					// DB 처리
					result = Execute.execute(Init.get(uri), no);
					jsp = "redirect:list.do";
					break;

        
				default:
						jsp = "error/404";
					break;
				} // end of switch
			} catch (Exception e) {
				// e.printStackTrace();
				request.setAttribute("e", e);
				jsp = "error/500";
			} // end of try~catch
			return jsp;
	} // end of main()
} // end of class
