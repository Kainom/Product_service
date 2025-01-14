package kainom.product_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kainom.dtos.CategoryDTO;
import com.kainom.dtos.ProductDTO;

import jakarta.validation.Valid;
import kainom.product_api.services.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<ProductDTO> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductByCategoryList(@PathVariable("categoryId") Long categoryId) {
        return productService.geProductByCategory(categoryId);
    }

    @GetMapping("/{productIdentifier}")
    public ProductDTO getProductByProductIdentifier(@PathVariable("productIdentifier") String productIdentifier) {
        return productService.findByProductIdentifier(productIdentifier);
    }

    @PostMapping("/")
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }
    
    @PostMapping("/category")
    public CategoryDTO createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        return productService.save(categoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
    }

}
