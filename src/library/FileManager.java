
package library;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private static final String DATA_FOLDER = "data";

    public static void createDataFolder() {

        File folder = new File(DATA_FOLDER);

        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public static void saveBooks(Library library) {

        createDataFolder();

        try (FileWriter writer = new FileWriter(
                DATA_FOLDER + "/books.txt")) {

            writer.write("Library Books\n");

            for (Book book : library.getBooks()) {
                writer.write(book.toString() + "\n");
            }

            System.out.println("Book data saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error while saving books: " + e.getMessage()
            );
        }
    }

    public static void saveStudents(Library library) {

        createDataFolder();

        try (FileWriter writer = new FileWriter(
                DATA_FOLDER + "/students.txt")) {

            writer.write("Library Students\n");

            for (Student student : library.getStudents()) {
                writer.write(student.toString() + "\n");
            }

            System.out.println("Student data saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error while saving students: " + e.getMessage()
            );
        }
    }

    public static void saveTransactions(Library library) {

        createDataFolder();

        try (FileWriter writer = new FileWriter(
                DATA_FOLDER + "/transactions.txt")) {

            writer.write("Library Transactions\n");

            for (IssueRecord record : library.getIssueRecords()) {
                writer.write(record.toString() + "\n");
            }

            System.out.println(
                    "Transaction data saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error while saving transactions: "
                    + e.getMessage()
            );
        }
    }
}
