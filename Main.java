
package library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        FileManager.createDataFolder();

        boolean running = true;

        while (running) {

            System.out.println("\nCAMPUS LIBRARY MANAGEMENT");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Add Student");
            System.out.println("5. View Students");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. View Issue Records");
            System.out.println("9. Library Summary");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            try {

                switch (choice) {

                    case "1":
                        System.out.print("Enter Book ID: ");
                        int bookId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();

                        System.out.print("Enter Category: ");
                        String category = scanner.nextLine();

                        if (!InputValidator.isValidId(bookId)
                                || !InputValidator.isValidText(title)
                                || !InputValidator.isValidText(author)
                                || !InputValidator.isValidText(category)) {

                            throw new LibraryException("Invalid book details.");
                        }

                        library.addBook(
                                new Book(bookId, title, author, category)
                        );

                        FileManager.saveBooks(library);
                        break;

                    case "2":
                        library.displayBooks();
                        break;

                    case "3":
                        System.out.print("Enter book title to search: ");
                        String searchTitle = scanner.nextLine();

                        if (!InputValidator.isValidText(searchTitle)) {

                            throw new LibraryException(
                                    "Search text cannot be empty."
                            );
                        }

                        library.searchBook(searchTitle);
                        break;

                    case "4":
                        System.out.print("Enter Student ID: ");
                        int studentId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Student Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Enter Department: ");
                        String department = scanner.nextLine();

                        if (!InputValidator.isValidId(studentId)
                                || !InputValidator.isValidName(name)
                                || !InputValidator.isValidEmail(email)
                                || !InputValidator.isValidText(department)) {

                            throw new LibraryException(
                                    "Invalid student details."
                            );
                        }

                        new Student(
                            String.valueOf(studentId),
                         name,
                         email,
                         department
                        );
                        

                        FileManager.saveStudents(library);
                        break;

                    case "5":
                        library.displayStudents();
                        break;

                    case "6":
                        System.out.print("Enter Book ID: ");
                        int issueBookId =
                                Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Student ID: ");
                        int issueStudentId =
                                Integer.parseInt(scanner.nextLine());

                        library.issueBook(issueBookId, issueStudentId);

                        FileManager.saveBooks(library);
                        FileManager.saveTransactions(library);
                        break;

                    case "7":
                        System.out.print("Enter Book ID: ");
                        int returnBookId =
                                Integer.parseInt(scanner.nextLine());

                        library.returnBook(returnBookId);

                        FileManager.saveBooks(library);
                        FileManager.saveTransactions(library);
                        break;

                    case "8":
                        library.displayIssueRecords();
                        break;

                    case "9":
                        ReportManager.showLibrarySummary(library);
                        break;

                    case "10":
                        running = false;

                        System.out.println(
                                "Thank you for using Campus Library Management System!"
                        );
                        break;

                    default:
                        System.out.println(
                                "Invalid choice. Please try again."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

            } catch (LibraryException e) {

                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}