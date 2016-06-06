package galaxy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import galaxy.model.Category;
import galaxy.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService service;

	@RequestMapping("/category/select")
	public String categorySelect(HttpSession session, Category category) {
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
}
