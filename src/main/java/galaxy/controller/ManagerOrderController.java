package galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import galaxy.service.ManagerOrderService;

@Controller
public class ManagerOrderController {

	@Autowired
	private ManagerOrderService managerOrderService;
}
