package models;

import services.DateService;

import java.sql.Date;

public class Borrower {
    private int BorrowerId, BookId;
    private Date BorrowedFrom, BorrowedTo, ReturnDate;
    private String Issuer;

    public Borrower(int borrowerId,
                    int bookId,
                    Date borrowedFrom,
                    Date borrowedTo,
                    Date returnDate,
                    String issuer
    ) {
        BorrowerId = borrowerId;
        BookId = bookId;
        BorrowedFrom = borrowedFrom;
        BorrowedTo = borrowedTo;
        ReturnDate = returnDate;
        Issuer = issuer;
    }

    public Borrower(int borrowerId,
                    int bookId,
                    Date borrowedFrom,
                    Date borrowedTo,
                    String issuer
    ) {
        BorrowerId = borrowerId;
        BookId = bookId;
        BorrowedFrom = borrowedFrom;
        BorrowedTo = borrowedTo;
        Issuer = issuer;
    }

    public int getBorrowerId() {
        return BorrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        BorrowerId = borrowerId;
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

    public String getIssuer() {
        return Issuer;
    }

    public void setIssuer(String issuer) {
        Issuer = issuer;
    }

    public String getBorrowedToString() {
        return DateService.toString(BorrowedFrom);
    }

    public String getBorrowedFromString() {
        return DateService.toString(BorrowedTo);
    }
}