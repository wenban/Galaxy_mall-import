package galaxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.model.User;
import galaxy.service.ManagerUserService;

@Controller
public class ManagerUserController {
	
	@Autowired
	private ManagerUserService service;
	
	@RequestMapping(value = "/backgroundUser/select", method = RequestMethod.GET)
	public String selectBackgroundStore (Model model,User user) {
		List<User> selectuser=service.selectUser(user);
		model.addAttribute("userlist",selectuser); 
		return "userbackground";
	}
	
	@RequestMapping(value = "/backgroundUser/remove", method = RequestMethod.GET)
	public String storeDelete(Integer id,String userIds){
		service.deleteUser(id, userIds);
		return "redirect:/backgroundUser/select";
	
	}


}
