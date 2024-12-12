CREATE TABLE
    products.product (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        product_identifier VARCHAR(255) NOT NULL,
        nome VARCHAR(100) NOT NULL,
        descricao TEXT NOT NULL,
        preco DOUBLE NOT NULL,
        category_id BIGINT,
        FOREIGN KEY (category_id) REFERENCES products.category (id)
    );