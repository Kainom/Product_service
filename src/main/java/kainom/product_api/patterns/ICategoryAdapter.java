package kainom.product_api.patterns;



import com.kainom.dtos.CategoryDTO;

import kainom.product_api.model.Category;

public interface ICategoryAdapter {
    public CategoryDTO toDTO(Category category);
    public Category toCategory(CategoryDTO categoryDTO);
}
