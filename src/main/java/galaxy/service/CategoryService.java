package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.model.Category;

import galaxy.dao.CategoryDAO;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	public List<Category> getFirstCategory(Category category) {
		return categoryDAO.selectFirstCategoryByParentId(category);
		 
	}

	public List<Category> getChildCategory(Category category) {
		return categoryDAO.selectChildCategoryByParentId(category);
		 
	}

	public void deleteCategoryList(Category category,String categoryIds) {
		String[] categoryIdsArray = categoryIds.split(",");
		for (String favoritestoreid : categoryIdsArray) {
		List<Category> childCategory = categoryDAO.selectChildCategoryByParentId(category);
		if (!childCategory.isEmpty()) {
			for (Category ca : childCategory) {
				deleteCategoryList(ca, favoritestoreid);
				categoryDAO.deleteCategoryListByEnable(category);
			}
		} else {
			categoryDAO.deleteCategoryListByEnable(category);
		}

	}
}
	
	
}
