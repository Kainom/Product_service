package kainom.product_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kainom.product_api.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByNome(String nome);

}
