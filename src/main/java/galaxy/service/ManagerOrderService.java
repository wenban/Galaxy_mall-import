package galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.ManagerOrderDAO;

@Service
public class ManagerOrderService {

	@Autowired
	private ManagerOrderDAO managerOrderDAO;
}
