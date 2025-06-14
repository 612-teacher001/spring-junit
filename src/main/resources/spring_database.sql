\c postgres
DROP DATABASE IF EXISTS spring_junitdb;
DROP ROLE IF EXISTS student;
CREATE ROLE student WITH PASSWORD 'himitu' LOGIN;
CREATE DATABASE spring_junitdb OWNER student ENCODING 'UTF8';