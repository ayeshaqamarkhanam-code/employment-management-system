CREATE DATABASE IF NOT EXISTS ems_db;
USE ems_db;
CREATE TABLE IF NOT EXISTS employee(
    employee_id BIGINT(15) AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15) UNIQUE,
    department VARCHAR(50),
    job_title VARCHAR(100),
    date_of_joining DATE,
    salary DECIMAL(10,2),
    status VARCHAR(15) DEFAULT 'Active'
);