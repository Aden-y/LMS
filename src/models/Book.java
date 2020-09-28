package models;

import dao.BookRequestDAO;
import dao.BorrowerDAO;
import dao.ShelfDAO;

public class Book {
    private  int ISBNCode, BindingId, CopiesActual, CopiesAvailable, CategoryId, PublicationYear, ShelfId ;
    private String Title, Language , Author;

    public Book(int bindingId,
                int copiesActual,
                int copiesAvailable,
                int categoryId,
                int publicationYear,
                int shelfId,
                String title,
                String author,
                String language
    ) {
        BindingId = bindingId;
        CopiesActual = copiesActual;
        CopiesAvailable = copiesAvailable;
        CategoryId = categoryId;
        PublicationYear = publicationYear;
        ShelfId = shelfId;
        Title = title;
        Language = language;
        Author = author;
    }

    public Book(int ISBNCode,
                int bindingId,
                int copiesActual,
                int copiesAvailable,
                int categoryId,
                int publicationYear,
                int shelfId,
                String title,
                String author,
                String language
    ) {
        this.ISBNCode = ISBNCode;
        BindingId = bindingId;
        CopiesActual = copiesActual;
        CopiesAvailable = copiesAvailable;
        CategoryId = categoryId;
        PublicationYear = publicationYear;
        ShelfId = shelfId;
        Title = title;
        Language = language;
        Author = author;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(int ISBNCode) {
        this.ISBNCode = ISBNCode;
    }

    public int getBindingId() {
        return BindingId;
    }

    public void setBindingId(int bindingId) {
        BindingId = bindingId;
    }

    public int getCopiesActual() {
        return CopiesActual;
    }

    public void setCopiesActual(int copiesActual) {
        CopiesActual = copiesActual;
    }

    public int getCopiesAvailable() {
        return CopiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        CopiesAvailable = copiesAvailable;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public int getPublicationYear() {
        return PublicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        PublicationYear = publicationYear;
    }

    public int getShelfId() {
        return ShelfId;
    }

    public void setShelfId(int shelfId) {
        ShelfId = shelfId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public boolean borrow() {
        if (CopiesAvailable >0) {
            CopiesAvailable--;
            return true;
        }else {
            return false;
        }
    }

    public boolean return$() {
        if (CopiesAvailable < CopiesActual) {
            CopiesAvailable++;
            return true;
        }else {
            return false;
        }
    }

    public Shelf getShelf() {
        return ShelfDAO.get(ShelfId);
    }

    public boolean canRequest(int borrowerId) {
        return !BorrowerDAO.hasBorrowed(borrowerId, ISBNCode)
                && !BookRequestDAO.isRequested(ISBNCode, borrowerId)
                && CopiesAvailable > 0;
    }
}
