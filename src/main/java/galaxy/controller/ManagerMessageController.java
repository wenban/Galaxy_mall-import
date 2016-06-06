package galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import galaxy.service.ManagerMessageService;

@Controller
public class ManagerMessageController {
	
	@Autowired
	private ManagerMessageService managerMessageService;

}
