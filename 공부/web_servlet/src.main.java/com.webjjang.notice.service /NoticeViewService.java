package com.webjjang.notice.service;

import com.webjjang.main.dao.DAO;
import com.webjjang.main.service.Service;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.vo.NoticeVO;

public class NoticeViewService implements Service {
	NoticeDAO noticeDAO;
	
	@Override
	public NoticeVO service(Object obj) throws Exception {
		// DB 처리는 DAO에서 처리 - NoticeDAO.view() : obj == no
		// NoticeController - (Execute) - [NoticeViewService] - NoticeDAO.view()
		return new NoticeDAO().view((Long)obj);
	}

	@Override
	public void setDAO(DAO dao) {
		this.noticeDAO=(NoticeDAO)dao;
	}

}
