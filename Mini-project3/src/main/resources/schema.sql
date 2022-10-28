-- drop the book table if it already exists.
DROP TABLE IF EXISTS book;
CREATE TABLE book (
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    ISBN VARCHAR(255) NOT NULL,
    price int NOT NULL,
    recommendedFor VARCHAR(255) NOT NULL
);

-- drop the student table if it already exists.
DROP TABLE IF EXISTS student;
CREATE TABLE student (
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    education VARCHAR(255) NOT NULL,
    amount int NOT NULL
);