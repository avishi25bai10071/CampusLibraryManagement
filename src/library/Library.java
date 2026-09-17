package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Student> students;
    private List<IssueRecord> issueRecords;

    public Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
        issueRecords = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<IssueRecord> getIssueRecords() {
        return issueRecords;
    }

    public void addBook(Book book) throws LibraryException {

        if (book == null) {
            throw new LibraryException("Book cannot be empty.");
        }

        if (findBook(book.getBookId()) != null) {
            throw new LibraryException("Book ID already exists.");
        }

        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBook(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    public void searchBook(String keyword) {

        boolean found = false;

        for (Book book : books) {

            if (book.getTitle().toLowerCase()
                    .contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase()
                    .contains(keyword.toLowerCase())
                    || book.getCategory().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    public void addStudent(Student student) throws LibraryException {

        if (student == null) {
            throw new LibraryException("Student cannot be empty.");
        }

        int studentId = Integer.parseInt(student.getUserId());

        if (findStudent(studentId) != null) {
            throw new LibraryException("Student ID already exists.");
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        for (Student student : students) {
            student.displayUser();
        }
    }

    public Student findStudent(int studentId) {

        for (Student student : students) {

            int currentId = Integer.parseInt(student.getUserId());

            if (currentId == studentId) {
                return student;
            }
        }

        return null;
    }

    public void issueBook(int bookId, int studentId)
            throws LibraryException {

        Book book = findBook(bookId);
        Student student = findStudent(studentId);

        if (book == null) {
            throw new LibraryException("Book not found.");
        }

        if (student == null) {
            throw new LibraryException("Student not found.");
        }

        if (!book.isAvailable()) {
            throw new LibraryException("Book is already issued.");
        }

        IssueRecord record = new IssueRecord(
                bookId,
                studentId,
                LocalDate.now()
        );

        issueRecords.add(record);
        book.setAvailable(false);

        System.out.println("Book issued successfully.");
    }

    public void returnBook(int bookId) throws LibraryException {

        Book book = findBook(bookId);

        if (book == null) {
            throw new LibraryException("Book not found.");
        }

        if (book.isAvailable()) {
            throw new LibraryException("Book is not currently issued.");
        }

        boolean found = false;

        for (IssueRecord record : issueRecords) {

            if (record.getBookId() == bookId
                    && !record.isReturned()) {

                record.returnBook();
                book.setAvailable(true);

                System.out.println("Book returned successfully.");
                System.out.println("Fine: ₹" + record.getFine());

                found = true;
                break;
            }
        }

        if (!found) {
            throw new LibraryException("Issue record not found.");
        }
    }

    public void displayIssueRecords() {

        if (issueRecords.isEmpty()) {
            System.out.println("No issue records available.");
            return;
        }

        for (IssueRecord record : issueRecords) {
            System.out.println(record);
        }
    }
    }
