package kainom.product_api.patterns;

import kainom.product_api.dto.ProductDTO;
import kainom.product_api.model.Product;

public class ProductAdapter implements IProductAdapter {

    @Override
    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setNome(product.getNome());
        productDTO.setDescricao(product.getDescricao());
        productDTO.setPreco(product.getPreco());
        productDTO.setCategory(new CategoryAdapter().toDTO(product.getCategory())); // Assuming Category has an adapter as well

        return productDTO;
    }

    @Override
    public Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductIdentifier(productDTO.getProductIdentifier());
        product.setNome(productDTO.getNome());
        product.setDescricao(productDTO.getDescricao());
        product.setPreco(productDTO.getPreco());
        product.setCategory(new CategoryAdapter().toCategory(productDTO.getCategory())); // Assuming Category has an adapter as well

        return product;
        
    }
    
}
