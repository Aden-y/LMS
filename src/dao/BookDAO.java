package dao;

import data.DatabaseAccess;
import models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public static Book create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new Book(
                        resultSet.getInt("ISBNCode"),
                        resultSet.getInt("BindingId"),
                        resultSet.getInt("CopiesActual"),
                        resultSet.getInt("CopiesAvailable"),
                        resultSet.getInt("CategoryId"),
                        resultSet.getInt("PublicationYear"),
                        resultSet.getInt("ShelfId"),
                        resultSet.getString("Title"),
                        resultSet.getString("Author"),
                        resultSet.getString("Language")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Book> createList(ResultSet resultSet) {
        List<Book> books = new ArrayList<>();
        try {
            while (resultSet.next()) {
                books.add(new Book(
                        resultSet.getInt("ISBNCode"),
                        resultSet.getInt("BindingId"),
                        resultSet.getInt("CopiesActual"),
                        resultSet.getInt("CopiesAvailable"),
                        resultSet.getInt("CategoryId"),
                        resultSet.getInt("PublicationYear"),
                        resultSet.getInt("ShelfId"),
                        resultSet.getString("Title"),
                        resultSet.getString("Author"),
                        resultSet.getString("Language")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static void create(Book book) {
        String sql = "insert into Book(BindingId, CopiesActual, CopiesAvailable, CategoryId, PublicationYear, ShelfId, Title, Author, Language) values(" +
                ""+book.getBindingId()+", "+book.getCopiesActual()+", "+book.getCopiesAvailable()+", "+book.getCategoryId()+", "+book.getPublicationYear()+", "+book.getShelfId()+", " +
                "'"+book.getTitle()+"', " +
                "'"+book.getAuthor()+"', " +
                "'"+book.getLanguage()+"')";
        DatabaseAccess.executeUpdate(sql);
    }

    public static Book get(int ISBNCode) {
        return create(DatabaseAccess.executeQuery("select * from Book where ISBNCode = "+ISBNCode));
    }

    public static  List<Book> all() {
        return createList(DatabaseAccess.executeQuery("select * from Book"));
    }

    public static  List<Book> findByCategory(int categoryId) {
        return createList(DatabaseAccess.executeQuery("select * from Book where CategoryId = "+categoryId));
    }

    public static  List<Book> findByCampus(int campusNo) {
        String sql = "select * from Book inner join Shelf on " +
                "Shelf.ShelfId = Book.ShelfId inner join Campus on Campus.CampusNo = Shelf.CampusNo where Campus.CampusNo = "+campusNo;
        return createList(DatabaseAccess.executeQuery(sql));
    }

    public static void updateBorrowed(Book book ){
        String sql = "update Book set CopiesAvailable = "+book.getCopiesAvailable()+" where ISBNCode = "+book.getISBNCode();
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<Book> findByShelf(int shelfId) {
        return createList(DatabaseAccess.executeQuery("select * from Book where ShelfId = "+shelfId));
    }
}
