package galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.ManagerMessageDAO;

@Service
public class ManagerMessageService {
	
	@Autowired
	private ManagerMessageDAO managerMessageDAO;

}
