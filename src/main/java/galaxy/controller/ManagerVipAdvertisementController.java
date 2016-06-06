package galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import galaxy.service.ManagerVipAdvertisementService;

@Controller
public class ManagerVipAdvertisementController {
	
	@Autowired
	private ManagerVipAdvertisementService managerVipAdvertisementService;

}
