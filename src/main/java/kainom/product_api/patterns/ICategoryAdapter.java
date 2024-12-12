package kainom.product_api.patterns;


import org.springframework.stereotype.Service;

import kainom.product_api.dto.CategoryDTO;
import kainom.product_api.model.Category;

public interface ICategoryAdapter {
    public CategoryDTO toDTO(Category category);
    public Category toCategory(CategoryDTO categoryDTO);
}
