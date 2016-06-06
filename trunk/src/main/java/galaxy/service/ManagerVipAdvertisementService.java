package galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.ManagerVipAdvertisementDAO;

@Service
public class ManagerVipAdvertisementService {
	
	@Autowired
	private ManagerVipAdvertisementDAO managerVipAdvertisementDAO;
}
