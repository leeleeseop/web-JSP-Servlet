package com.webjjang.notice.service;

import com.webjjang.main.dao.DAO;
import com.webjjang.main.service.Service;
import com.webjjang.notice.dao.NoticeDAO;

public class NoticeDeleteService implements Service {
	private NoticeDAO dao;
  
	@Override
	public Integer service(Object obj) throws Exception {
		// DB 처리는 DAO에서 처리 - NoticeDAO.delete()
		// NoticeController - (Execute) - [NoticeDeleteService] - NoticeDAO.delete()
		return dao.delete((Long)obj);
	}

	@Override
	public void setDAO(DAO dao) {
		this.dao=(NoticeDAO) dao;
		
	}

}
