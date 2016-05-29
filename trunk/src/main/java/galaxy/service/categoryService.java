package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.model.Category;

import galaxy.dao.categoryDAO;

@Service
public class categoryService {

	@Autowired
	private categoryDAO dao;

	public List<Category> getFirstCategory(Category category) {
		List<Category> firstcategory = dao.selectFirstCategoryByParentId(category);
		return firstcategory;
	}

	public List<Category> getChildCategory(Category category) {
		List<Category> childcategory = dao.selectChildCategoryByParentId(category);
		return childcategory;
	}

	public void deleteCategoryList(Category category) {
		List<Category> childcategory = dao.selectChildCategoryByParentId(category);
		if (!childcategory.isEmpty()) {
			for (Category ca : childcategory) {
				deleteCategoryList(ca);
				dao.deleteCategoryListByEnable(category);
			}
		} else {
			dao.deleteCategoryListByEnable(category);
		}

	}
}
