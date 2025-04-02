# Day 3 - Student Management API 📚👨‍💻

## Description ✍️

This is a simple Spring Boot REST API for managing students. The API allows users to retrieve student details, perform CRUD operations, and filter students based on their age.

---

## Project Structure 🗂️

```
controller/
    SendDataController.java: Handles basic data sending endpoints
    StudentController.java: Manages student-related operations
model/
    Student.java: Student data model class
```

---

## Endpoints 🌐

### **SendDataController Endpoints** 📨

#### **GET /app/age/{ag}** 🎂

- **Description**: Returns the age as a string.
- **Example**: `/app/age/25`
- **Response**:

![Screenshot 1](https://github.com/user-attachments/assets/2500398a-ed9f-4e9d-b055-bd8be2289e80)

---

### **StudentController Endpoints** 👩‍🎓

#### **GET /app/student** 📝

- **Description**: Returns details of the first student.
- **URL**: `http://localhost:8080/app/student`
- **Response**:

![Screenshot 2](https://github.com/user-attachments/assets/c30f5401-034c-43db-8525-203d77454267)

---

#### **GET /app/students** 📊

- **Description**: Returns a list of all predefined students.
- **URL**: `http://localhost:8080/app/students`
- **Response**:

![Screenshot 3](https://github.com/user-attachments/assets/f9f79f38-09fe-4269-8b7d-f3fd259b2ed3)

---

#### **GET /app/student/{id}** 🔍

- **Description**: Retrieves a student by registration number.
- **Example**: `/app/student/2020ICT01`
- **Response**:

![Screenshot 4](https://github.com/user-attachments/assets/618ef750-3bfe-4b5a-91c1-c18c3edf94d5)

---

#### **GET /app/students/age-between** 👥

- **Description**: Returns a list of students whose age is between 20 and 30.
- **URL**: `http://localhost:8080/app/students/age-between`
- **Response**:

![Screenshot 5](https://github.com/user-attachments/assets/26048cd2-17d7-4e85-a1ab-fbf6fc5a7df2)

---

#### **GET /app/students/sort-by-gpa** 📈

- **Description**: Returns the list of students sorted by their GPA in ascending order.
- **URL**: `http://localhost:8080/app/students/sort-by-gpa`
- **Response**:

![Screenshot 6](https://github.com/user-attachments/assets/e65ea5b7-faef-40de-9f92-a454a4f8f727)

---

### **CRUD Operations for Students 🔧**

#### **CREATE - POST /app/students** ➕ 

- **Description**: Adds a new student to the list.
- **Example**: `/app/students`
- **Parameters**:
  - `nm`: Name
  - `ag`: Age
  - `crs`: Course
  - `reg`: Registration Number
  - `gp`: GPA
- **Response**: The updated list of students after adding the new student.

![Screenshot 7](https://github.com/user-attachments/assets/ee79b546-e139-400a-a913-c1a4e74bea31)

---

#### **UPDATE - PUT /app/students/2020ICT06** ✏️

- **Description**: Updates an existing student identified by registration number.
- **Example**: `/app/students/2020ICT06`
- **Parameters**:
  - `reg`: Registration Number (used to identify the student)
  - `nm`: Name (optional, leave empty string to skip)
  - `ag`: Age (optional, use 0 to skip)
  - `crs`: Course (optional, leave empty string to skip)
  - `gp`: GPA (optional, use negative value to skip)
- **Response**:

![Screenshot 8](https://github.com/user-attachments/assets/744fda6e-bd3a-4b70-bb73-707a8dca8c29)

---

#### **DELETE - DELETE /app/students/{ID}** ❌

- **Description**: Removes a student from the list based on registration number.
- **Example**: `/app/students/2020ICT06`
- **Parameters**:
  - `reg`: Registration Number
- **Response**:

![Screenshot 9](https://github.com/user-attachments/assets/0a231ed9-0954-4aee-8ec2-de75e76d1e3c)

---

## Technologies Used 💻

- **Spring Boot** 🚀
- **Spring Web** 🌐
- **Java** ☕️

---

## Expected Outputs 🖥️

For each of the endpoints, the output will vary based on the data passed. The responses for the listed endpoints will provide details of students in JSON format and also handle basic text responses for other queries.
