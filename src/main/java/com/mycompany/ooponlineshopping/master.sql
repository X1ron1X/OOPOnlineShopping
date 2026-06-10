
CREATE TABLE orders (
    id INT IDENTITY(1,1) PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL,
    status VARCHAR(50) NOT NULL
);
GO