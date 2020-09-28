package models;

import dao.BookDAO;

public class ProfessorBookRequest {
    private int RequestId  , ISBNCode ;
    private String EmploymentId;

    public ProfessorBookRequest(int requestId, int ISBNCode, String employmentId) {
        RequestId = requestId;
        this.ISBNCode = ISBNCode;
        EmploymentId = employmentId;
    }

    public ProfessorBookRequest(int ISBNCode, String employmentId) {
        this.ISBNCode = ISBNCode;
        EmploymentId = employmentId;
    }

    public int getRequestId() {
        return RequestId;
    }

    public void setRequestId(int requestId) {
        RequestId = requestId;
    }

    public int getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(int ISBNCode) {
        this.ISBNCode = ISBNCode;
    }

    public String getEmploymentId() {
        return EmploymentId;
    }

    public void setEmploymentId(String employmentId) {
        EmploymentId = employmentId;
    }

    public  Book getBook() {
        return BookDAO.get(ISBNCode);
    }


}
