CREATE DATABASE IF NOT EXISTS employees_db;
USE employees_db;

CREATE TABLE IF NOT EXISTS employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100)
);


