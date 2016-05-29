package galaxy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import galaxy.model.Category;

import galaxy.service.categoryService;

@Controller
public class categoryController {
	
	@Autowired
	private categoryService service;

	@RequestMapping("/category/select")
	public String categorySelect(HttpSession session,Category category ){
		List<Category> firstcategory=service.getFirstCategory(category);
		for(Category thefirstcategory :firstcategory){
		List<Category> secondcategory=service.getChildCategory(thefirstcategory);
			for(Category thesecondcategory : secondcategory){
				thesecondcategory.setChildcategory(service.getChildCategory(thesecondcategory));
			}
			thefirstcategory.setChildcategory(secondcategory);
		}
		session.setAttribute("firstCategoryList", firstcategory);
		return "category";

	}
	
	@RequestMapping("/category/select/child")
	@ResponseBody
	public List<Category> selectChildCategory(Category category){
		return service.getChildCategory(category);
	}
	
		
	@RequestMapping("/category/delete")
	public String deleteCategory(Category category){
		service.deleteCategoryList(category);
		return "redirect:/category/select";
	}
}
	


