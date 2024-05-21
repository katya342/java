CREATE TABLE Book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publication_year INT,
    quantity INT DEFAULT 0
);

-- Creating the "User" table
CREATE TABLE LibUser (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    date_of_birth DATE,
    address VARCHAR(255)
);

INSERT INTO Book (title, author, publication_year, quantity) 
VALUES 
('The Great Gatsby', 'F. Scott Fitzgerald', 1925, 10),
('To Kill a Mockingbird', 'Harper Lee', 1960, 8),
('1984', 'George Orwell', 1949, 5),
('Pride and Prejudice', 'Jane Austen', 1813, 12);

-- Inserting data into the "User" table
INSERT INTO LibUser (first_name, last_name, email, date_of_birth, address) 
VALUES 
('John', 'Doe', 'john.doe@example.com', '1990-05-15', '123 Main Street'),
('Alice', 'Smith', 'alice.smith@example.com', '1985-10-22', '456 Elm Street'),
('Bob', 'Johnson', 'bob.johnson@example.com', '1978-03-08', '789 Oak Avenue');