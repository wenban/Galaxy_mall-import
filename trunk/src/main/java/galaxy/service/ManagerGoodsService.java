package galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.ManagerGoodsDAO;

@Service
public class ManagerGoodsService {
	
	@Autowired
	private ManagerGoodsDAO managerGoodsDAO;

}
