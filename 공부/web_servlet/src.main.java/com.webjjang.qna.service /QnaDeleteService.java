package com.webjjang.qna.service;

import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.vo.QnaVO;
import com.webjjang.main.dao.DAO;
import com.webjjang.main.service.Service;

public class QnaDeleteService implements Service {
	private QnaDAO dao;
	
	// dao setter
	public void setDAO(DAO dao) {
		this.dao = (QnaDAO) dao;
	}

	@Override
	public Integer service(Object obj) throws Exception {
		// DB qna에서 리스트 쿼리 실행해서 데이터 가져오기 - 리턴
		// DB 처리는 DAO에서 처리 - QnaDAO.delete()
		// QnaController - (Execute) - [QnaDeleteService] - QnaDAO.delete()
		return dao.delete((QnaVO)obj);
	}

}
