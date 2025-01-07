package kainom.product_api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kainom.dtos.ProductDTO;
import com.kainom.err.CategoryNotFoundException;
import com.kainom.err.ProductNotFoundException;

import kainom.product_api.model.Product;
import kainom.product_api.patterns.IProductAdapter;
import kainom.product_api.repository.CategoryRepository;
import kainom.product_api.repository.ProductRepository;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private IProductAdapter productAdapter;
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, IProductAdapter productAdapter,
            CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productAdapter = productAdapter;
        this.categoryRepository = categoryRepository;
    }

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
            throw new ProductNotFoundException();
        }
        return productAdapter.toDTO(product);

    }

    public ProductDTO save(ProductDTO productDTO) {
        Boolean existCategory = categoryRepository.existsById(productDTO.getCategory().getId());
        if (!existCategory) {
            throw new CategoryNotFoundException();

        }

        Product product = productAdapter.toProduct(productDTO);
        return productAdapter.toDTO(productRepository.save(product));
    }

    public void deleteById(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (!product.isPresent()) {
            throw new ProductNotFoundException();
        }

        productRepository.delete(product.get());
    }

}
