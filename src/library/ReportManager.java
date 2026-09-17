
package library;

public class ReportManager {

    public static void showLibrarySummary(Library library) {

        System.out.println("\n LIBRARY SUMMARY ");

        System.out.println("Total Books: " + library.getBooks().size());

        System.out.println("Total Students: " + library.getStudents().size());

        System.out.println(
                "Total Issue Records: "
                        + library.getIssueRecords().size()
        );

        int availableBooks = 0;
        int issuedBooks = 0;

        for (Book book : library.getBooks()) {

            if (book.isAvailable()) {
                availableBooks++;
            } else {
                issuedBooks++;
            }
        }

        System.out.println("Available Books: " + availableBooks);
        System.out.println("Issued Books: " + issuedBooks);

    }
}
