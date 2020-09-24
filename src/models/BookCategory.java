package models;

public class BookCategory {
    private int CategoryId;
    private String CategoryName ;

    private BookCategory(String categoryName) {
        this.CategoryName = categoryName;
    }

    public BookCategory(int categoryId, String categoryName) {
        this.CategoryId = categoryId;
        this.CategoryName = categoryName;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
