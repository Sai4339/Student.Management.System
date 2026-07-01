# 🎓 Student Management System (Java + JDBC + MySQL)

A console-based Student Management System built using Java, JDBC, and MySQL that demonstrates full CRUD operations along with additional features like grade calculation and CSV export.

## 🚀 Features
- Add new student (stored in MySQL database)
- Display all students
- Search student by ID
- Update student details
- Delete student record
- Automatic calculation of Total Marks, Average Marks, and Grade
- Export student records to CSV file
- Count total number of students

## 🛠️ Technologies Used
- Java (OOP Concepts)
- JDBC (Java Database Connectivity)
- MySQL Database
- File Handling (CSV Export)
- Git & GitHub

## 🏗️ Project Architecture
Main → StudentService → StudentDAO → MySQL Database

## 🗄️ Database Schema
Table: students

Columns:
- id (INT, Primary Key)
- name (VARCHAR)
- age (INT)
- course (VARCHAR)
- java_marks (INT)
- dsa_marks (INT)
- dbms_marks (INT)
- os_marks (INT)
- cn_marks (INT)

## 📊 Business Logic
- Total Marks = Sum of all subject marks
- Average Marks = Total / 5
- Grade System:
  - 90+ → A+
  - 80–89 → A
  - 70–79 → B
  - 60–69 → C
  - 50–59 → D
  - Below 50 → F

## 📁 Export Feature
Exports all student records into a CSV file (students.csv) including:
- Student details
- Total marks
- Average marks
- Grade

## 🔑 Key Concepts Implemented
- Object-Oriented Programming (OOP)
- Encapsulation
- DAO Design Pattern
- JDBC CRUD Operations
- SQL Queries (SELECT, INSERT, UPDATE, DELETE, COUNT)
- Exception Handling
- File Handling (CSV Export)
- Layered Architecture

## 🧠 Learning Outcomes
- Built a complete CRUD application using Java + MySQL
- Understood JDBC connectivity and SQL execution flow
- Implemented DAO-based architecture
- Learned database design and normalization basics
- Gained experience in Git and GitHub
- Implemented file export functionality

## 📂 Project Flow
User Input → Service Layer → DAO Layer → MySQL Database

## 👨‍💻 Future Improvements
- Add Login/Authentication System
- Convert into Spring Boot REST API
- Add GUI using JavaFX or Web Application

## ⭐ Purpose of Project
This project demonstrates backend development skills, database integration using JDBC, CRUD operations, and clean layered architecture suitable for real-world applications.
