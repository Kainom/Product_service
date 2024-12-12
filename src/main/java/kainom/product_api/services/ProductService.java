package kainom.product_api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kainom.product_api.dto.ProductDTO;
import kainom.product_api.model.Category;
import kainom.product_api.model.Product;
import kainom.product_api.patterns.IProductAdapter;
import kainom.product_api.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IProductAdapter productAdapter;

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(e -> productAdapter.toDTO(e))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> geProductByCategory(Long id) {
        List<Product> products = productRepository.getProductByCategory(id);
        return products
                .parallelStream()
                .map(e -> productAdapter.toDTO(e))
                .collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        return productAdapter.toDTO(product);

    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product = productAdapter.toProduct(productDTO);
        return productAdapter.toDTO(productRepository.save(product));
    }

    public void deleteById(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (!product.isPresent()) {
            throw new RuntimeException("Product not found");
        }

        productRepository.delete(product.get());
    }

}
