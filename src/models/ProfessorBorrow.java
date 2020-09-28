package models;

import services.DateService;

import java.sql.Date;

public class ProfessorBorrow {
    private int  BookId;
    private Date BorrowedFrom, BorrowedTo, ReturnDate;
    private int Issuer;
    private String EmploymentId;

    public ProfessorBorrow(int bookId, Date borrowedFrom, Date borrowedTo, Date returnDate, int issuer, String employmentId) {
        BookId = bookId;
        BorrowedFrom = borrowedFrom;
        BorrowedTo = borrowedTo;
        ReturnDate = returnDate;
        Issuer = issuer;
        EmploymentId = employmentId;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public Date getBorrowedFrom() {
        return BorrowedFrom;
    }

    public void setBorrowedFrom(Date borrowedFrom) {
        BorrowedFrom = borrowedFrom;
    }

    public Date getBorrowedTo() {
        return BorrowedTo;
    }

    public void setBorrowedTo(Date borrowedTo) {
        BorrowedTo = borrowedTo;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date returnDate) {
        ReturnDate = returnDate;
    }

    public int getIssuer() {
        return Issuer;
    }

    public void setIssuer(int issuer) {
        Issuer = issuer;
    }

    public String getEmploymentId() {
        return EmploymentId;
    }

    public void setEmploymentId(String employmentId) {
        EmploymentId = employmentId;
    }

    public String getBorrowedToString() {
        return DateService.toString(BorrowedTo);
    }

    public String getBorrowedFromString() {
        return DateService.toString(BorrowedFrom);
    }
}
