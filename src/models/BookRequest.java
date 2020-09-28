package models;

import dao.BookDAO;

public class BookRequest {
    private int RequestId , BorrowerId , ISBNCode ;

    public BookRequest(int requestId, int borrowerId, int ISBNCode) {
        RequestId = requestId;
        BorrowerId = borrowerId;
        this.ISBNCode = ISBNCode;
    }

    public BookRequest(int borrowerId, int ISBNCode) {
        BorrowerId = borrowerId;
        this.ISBNCode = ISBNCode;
    }

    public int getRequestId() {
        return RequestId;
    }

    public void setRequestId(int requestId) {
        RequestId = requestId;
    }

    public int getBorrowerId() {
        return BorrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        BorrowerId = borrowerId;
    }

    public int getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(int ISBNCode) {
        this.ISBNCode = ISBNCode;
    }

    public Book getBook() {
        return BookDAO.get(ISBNCode);
    }
}
