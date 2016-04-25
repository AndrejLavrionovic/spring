package ie.gmit.sw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.gmit.sw.dao.AmsMessage;
import ie.gmit.sw.dao.AmsMsgDao;
import ie.gmit.sw.dao.AmsMsgDaoImpl;
import ie.gmit.sw.dao.UserDAO;

@Service("amsMsgService")
public class AmsMsgServiceImpl implements AmsMsgService {
	
	private AmsMsgDao amsMsgDao;
	
	@Autowired
	public void setAmsMsgDao(AmsMsgDaoImpl amsMsgDao) {
		this.amsMsgDao = amsMsgDao;
	}
}
