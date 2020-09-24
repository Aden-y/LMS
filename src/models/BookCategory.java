package models;

public class BookCategory {
    private int CategoryId;
    private String CategoryName ;

    public BookCategory(String categoryName) {
        CategoryName = categoryName;
    }

    public BookCategory(int categoryId, String categoryName) {
        CategoryId = categoryId;
        CategoryName = categoryName;
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
