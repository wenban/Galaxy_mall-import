package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.Category;

@Repository
public interface CategoryDAO {
    public List<Category> selectFirstCategoryByParentId(Category category);
    
    public List<Category> selectChildCategoryByParentId(Category category);
	
	public void deleteCategoryListByEnable(Category category);
}
