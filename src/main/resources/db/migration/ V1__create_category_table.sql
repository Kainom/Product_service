create schema if not exists products;

create table
    products.category (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(100) NOT NULL
    );