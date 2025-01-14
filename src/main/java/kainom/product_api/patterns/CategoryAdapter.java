    package kainom.product_api.patterns;


    import org.springframework.stereotype.Component;

    import com.kainom.dtos.CategoryDTO;

    import kainom.product_api.model.Category;





    @Component
    public class CategoryAdapter implements ICategoryAdapter {
        


        @Override
        public CategoryDTO toDTO( Category category) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setNome(category.getNome());
            return categoryDTO;
        }

        @Override
        public Category toCategory(CategoryDTO categoryDTO) {
            Category category = new Category();
            category.setId(categoryDTO.getId());
            category.setNome(categoryDTO.getNome());
            return category;
        }

    
        
    }
