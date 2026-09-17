# CampusLibraryManagement
A Java project to manage books, students, book issue and return, and library records.

## 1. Project Overview

The Campus Library Management System is a command-line-based Java application designed to manage basic library activities. It allows users to add and view books, register students, search for books, issue and return books, and view library summary reports.

The project demonstrates the use of Java programming concepts such as classes, objects, inheritance, collections, exception handling, input validation, and file handling.

## 2. Features

- Add new books to the library.
- View all available books.
- Search books by title, author, or category.
- Register students with their details.
- View registered students.
- Issue books to registered students.
- Return issued books.
- Calculate fines for late book returns.
- View issue and return records.
- Display library summary.
- Save book, student, and transaction data in text files.
- Validate user input and handle errors.

## 3. Technologies Used

- Programming Language: Java
- User Interface: Command Line Interface (CLI)
- Data Storage: Text Files
- Collections: ArrayList
- Exception Handling: Custom LibraryException
- Input Handling: Scanner
- Development Tool: Java Development Kit (JDK)
- Version Control: Git and GitHub

## 4. Project Structure

- README.md
- statement.md
- src/library/
  - Main.java
  - Library.java
  - Book.java
  - User.java
  - Student.java
  - IssueRecord.java
  - LibraryException.java
  - InputValidator.java
  - FileManager.java
  - ReportManager.java
- data/ – Stores saved text files
- out/ – Stores compiled files

## 5. Requirements

- Java JDK 8 or above
- Command-line terminal
- Git (optional, for repository management)

## 6. How to Run the Project

1. Open the project folder in Command Prompt or PowerShell.

2. Compile the Java files:

   javac -d out src\library\*.java

3. Run the project:

   java -cp out library.Main

4. Select an option from the menu and follow the instructions.

## 7. Application Menu

The application provides the following options:

1. Add Book
2. View Books
3. Search Book
4. Add Student
5. View Students
6. Issue Book
7. Return Book
8. View Issue Records
9. Library Summary
10. Exit

## 8. Data Storage

The application stores information in text files inside the data folder:

- books.txt — Stores book details.
- students.txt — Stores student details.
- transactions.txt — Stores issue and return records.

The files are created when the corresponding save operation is performed.

## 9. Validation and Error Handling

The application uses InputValidator to validate user inputs such as IDs, names, email addresses, and text fields.

LibraryException is used to handle invalid library operations, including:

- Duplicate book IDs.
- Duplicate student IDs.
- Books that are not available.
- Books or students that cannot be found.
- Invalid library operations.

## 10. Testing

The following operations can be tested through the command-line interface:

- Adding a valid book.
- Adding a valid student.
- Searching for a book.
- Issuing an available book.
- Returning an issued book.
- Checking the library summary.
- Entering invalid details.
- Attempting to issue an unavailable book.

## 11. Future Enhancements

- Add data loading when the application starts.
- Add a graphical user interface.
- Add database integration.
- Add login and role-based access.
- Add advanced search and filtering options.

## 12. Author

Developed as part of the Programming in Java Evaluated Project.
