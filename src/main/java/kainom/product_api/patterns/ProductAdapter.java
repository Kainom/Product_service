package kainom.product_api.patterns;

import org.springframework.stereotype.Component;

import kainom.product_api.dto.ProductDTO;
import kainom.product_api.model.Product;

@Component
public class ProductAdapter implements IProductAdapter {
    private final CategoryAdapter categoryAdapter;
    
    public ProductAdapter(CategoryAdapter categoryAdapter) {
        this.categoryAdapter = categoryAdapter;
    }


    @Override
    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setNome(product.getNome());
        productDTO.setDescricao(product.getDescricao());
        productDTO.setPreco(product.getPreco());
        productDTO.setCategory(categoryAdapter.toDTO(product.getCategory()));

        return productDTO;
    }

    @Override
    public Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductIdentifier(productDTO.getProductIdentifier());
        product.setNome(productDTO.getNome());
        product.setDescricao(productDTO.getDescricao());
        product.setPreco(productDTO.getPreco());
        product.setCategory(categoryAdapter.toCategory(productDTO.getCategory()));

        return product;
        
    }
    
}
