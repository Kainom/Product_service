package kainom.product_api.patterns;

import org.springframework.stereotype.Component;

import kainom.product_api.dto.ProductDTO;
import kainom.product_api.model.Product;

public interface IProductAdapter {
    public ProductDTO toDTO(Product product);
    public Product toProduct(ProductDTO productDTO);
    
}
