USE products;
CREATE TABLE
    product (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        product_identifier VARCHAR(255) NOT NULL,
        nome VARCHAR(100) NOT NULL,
        descricao VARCHAR(255) NOT NULL,
        preco DECIMAL(10, 2) NOT NULL,
        category_id BIGINT,FOREIGN KEY (category_id) REFERENCES category (id)
    );