package models;

public class EBook {
    private int ISBNCode, CategoryId, PublicationYear;
    private String Title, Language, Author, FilePath;

    public EBook(int ISBNCode,
                 int categoryId,
                 int publicationYear,
                 String title,
                 String language,
                 String author,
                 String filePath
    ) {
        this.ISBNCode = ISBNCode;
        CategoryId = categoryId;
        PublicationYear = publicationYear;
        Title = title;
        Language = language;
        Author = author;
        FilePath = filePath;
    }

    public EBook(int categoryId,
                 int publicationYear,
                 String title,
                 String language,
                 String author,
                 String filePath
    ) {
        CategoryId = categoryId;
        PublicationYear = publicationYear;
        Title = title;
        Language = language;
        Author = author;
        FilePath = filePath;
    }

    public int getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(int ISBNCode) {
        this.ISBNCode = ISBNCode;
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

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }
}
