package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.model.Category;

import galaxy.dao.CategoryDAO;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO dao;

	public List<Category> getFirstCategory(Category category) {
		return dao.selectFirstCategoryByParentId(category);
		 
	}

	public List<Category> getChildCategory(Category category) {
		return dao.selectChildCategoryByParentId(category);
		 
	}

	public void deleteCategoryList(Category category) {
		List<Category> childCategory = dao.selectChildCategoryByParentId(category);
		if (!childCategory.isEmpty()) {
			for (Category ca : childCategory) {
				deleteCategoryList(ca);
				dao.deleteCategoryListByEnable(category);
			}
		} else {
			dao.deleteCategoryListByEnable(category);
		}

	}
}
