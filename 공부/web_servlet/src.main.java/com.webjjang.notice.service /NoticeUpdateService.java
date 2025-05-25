package com.webjjang.notice.service;

import com.webjjang.main.dao.DAO;
import com.webjjang.main.service.Service;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.vo.NoticeVO;

public class NoticeUpdateService implements Service {
	private NoticeDAO dao;
	
	@Override
	public Integer service(Object obj) throws Exception {
		// DB notice에서 수정 쿼리 실행해서 데이터 처리
		// NoticeController - (Execute) - [NoticeUpdateService] - NoticeDAO.update()
		return dao.update((NoticeVO)obj);
	}

	@Override
	public void setDAO(DAO dao) {
		this.dao=(NoticeDAO) dao;
	}

}
