package kainom.product_api.patterns;


import com.kainom.dtos.ProductDTO;

import kainom.product_api.model.Product;

public interface IProductAdapter {
    public ProductDTO toDTO(Product product);
    public Product toProduct(ProductDTO productDTO);
    
}
