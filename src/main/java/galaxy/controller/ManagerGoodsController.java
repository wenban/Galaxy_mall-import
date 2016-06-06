package galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import galaxy.service.ManagerGoodsService;

@Controller
public class ManagerGoodsController {
	
	@Autowired
	private ManagerGoodsService managerGoodsService;

}
