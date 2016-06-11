package galaxy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import galaxy.model.Category;
import galaxy.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService service;

	@RequestMapping("/category/select/all")
	public String categorySelectAll(HttpSession session, Category category) {
		List<Category> firstCategory = service.getFirstCategory(category);
		for (Category theFirstCategory : firstCategory) {
			List<Category> secondCategory = service.getChildCategory(theFirstCategory);
			for (Category thSecondCategory : secondCategory) {
				thSecondCategory.setChildcategory(service.getChildCategory(thSecondCategory));
			}
			theFirstCategory.setChildcategory(secondCategory);
		}
		session.setAttribute("firstCategoryList", firstCategory);
		return "category";
	}

	@RequestMapping("/category/select/child")
	@ResponseBody
	public List<Category> selectChildCategory(Category category) {
		return service.getChildCategory(category);
	}

	@RequestMapping("/category/remove")
	public String deleteCategory(Category category, String categoryIds) {
		service.deleteCategoryList(category, categoryIds);
		return "redirect:/category/select";
	}
	
	@RequestMapping("/category/select")
	public String categorySelect(Model model, Category category) {
		if (category.getId()==null) {
			category.setId(-1);
		}
		List<Category> categoryList = service.getChildCategory(category);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("a", "Shenhaojie");
		return "manager_category";
	}
}
