
package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class IssueRecord {

    private int bookId;
    private int studentId;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private double fine;
    private boolean returned;

    public IssueRecord(int bookId, int studentId, LocalDate issueDate) {

        this.bookId = bookId;
        this.studentId = studentId;
        this.issueDate = issueDate;
        this.returnDate = null;
        this.fine = 0.0;
        this.returned = false;
    }

    public int getBookId() {
        return bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public double getFine() {
        return fine;
    }

    public boolean isReturned() {
        return returned;
    }

    public void returnBook() {

        this.returnDate = LocalDate.now();
        this.returned = true;

        long daysBorrowed = ChronoUnit.DAYS.between(
                issueDate,
                returnDate
        );

        // Free borrowing period: 14 days
        if (daysBorrowed > 14) {
            this.fine = (daysBorrowed - 14) * 5.0;
        }
    }

    @Override
    public String toString() {

        return "Book ID: " + bookId
                + ", Student ID: " + studentId
                + ", Issue Date: " + issueDate
                + ", Return Date: "
                + (returnDate == null
                        ? "Not Returned"
                        : returnDate)
                + ", Fine: ₹" + fine
                + ", Status: "
                + (returned ? "Returned" : "Issued");
    }
}
