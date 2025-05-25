package com.webjjang.qna.service;

import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.vo.QnaVO;
import com.webjjang.main.dao.DAO;
import com.webjjang.main.service.Service;

public class QnaUpdateService implements Service {
	private QnaDAO dao;
	
	// dao setter
	public void setDAO(DAO dao) {
		this.dao = (QnaDAO) dao;
	}

	@Override
	public Integer service(Object obj) throws Exception {
		// DB qna에서 수정 쿼리 실행해서 데이터 처리
		// QnaController - (Execute) - [QnaUpdateService] - QnaDAO.update()
		return dao.update((QnaVO)obj);
	}

}
