package dao;

import data.DatabaseAccess;
import models.BookCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCategoryDAO {
    public static BookCategory create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return  new BookCategory(resultSet.getInt("CategoryId"), resultSet.getString("CategoryName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static List<BookCategory> createList(ResultSet resultSet) {
        List<BookCategory> categories = new ArrayList<>();
        try {
            while (resultSet.next()) {
                categories.add(new BookCategory(resultSet.getInt("CategoryId"), resultSet.getString("CategoryName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  categories;
    }

    public static void create(BookCategory category) {
        String sql = "insert into BookCategory (CategoryName) values('"+category.getCategoryName()+"')";
        DatabaseAccess.executeUpdate(sql);
    }

    public static BookCategory get(int categoryNo) {
        return create(DatabaseAccess.executeQuery("select * from BookCategory where CategoryNo = "+categoryNo));
    }

    public static List<BookCategory> all() {
        return createList(DatabaseAccess.executeQuery("select * from BookCategory "));
    }


}
