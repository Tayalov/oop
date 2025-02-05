CREATE DATABASE university;

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    major VARCHAR(255) NOT NULL
);

