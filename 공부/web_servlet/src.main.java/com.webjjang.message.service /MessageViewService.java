package com.webjjang.message.service;

import com.webjjang.main.dao.DAO;
import com.webjjang.main.service.Service;
import com.webjjang.message.dao.MessageDAO;
import com.webjjang.message.vo.MessageVO;

public class MessageViewService implements Service {
	private MessageDAO dao;
	
	// dao setter
	public void setDAO(DAO dao) {
		this.dao = (MessageDAO) dao;
	}

	@Override
	public MessageVO service(Object obj) throws Exception {
		// 받은 메시지인 경우(vo.accepterId != null) 받은 날짜 처리, 새로운 메시지 
		MessageVO vo = (MessageVO) obj;
		Long no = vo.getNo();
		String id = vo.getAccepterId();
    
		// 읽음 표시 처리 readed가 1이면 null -> sysdate : reded가 0이면 accptDate 유지되면서 업데이트가 되지 않았다
		if(vo.getAccepterId() != null) {
			int readed = dao.setReaded(no);
			if(readed ==1) dao.decreaseNewMsgCnt(id);
		}
    
		// DB 처리는 DAO에서 처리 - MessageDAO.view()
		// MessageController - (Execute) - [MessageViewService] - MessageDAO.view()
		return dao.view(no);
	}
  
}
