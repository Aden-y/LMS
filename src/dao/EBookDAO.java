package dao;

import data.DatabaseAccess;
import models.EBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EBookDAO {
    public static EBook create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return  new EBook(
                        resultSet.getInt("ISBNCode"),
                        resultSet.getInt("CategoryId"),
                        resultSet.getInt("PublicationYear"),
                        resultSet.getString("Title"),
                        resultSet.getString("Language"),
                        resultSet.getString("Author"),
                        resultSet.getString("FilePath")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<EBook> createList(ResultSet resultSet) {
        List<EBook> eBooks = new ArrayList<>();
        try {
            while (resultSet.next()) {
                eBooks.add(new EBook(
                        resultSet.getInt("ISBNCode"),
                        resultSet.getInt("CategoryId"),
                        resultSet.getInt("PublicationYear"),
                        resultSet.getString("Title"),
                        resultSet.getString("Language"),
                        resultSet.getString("Author"),
                        resultSet.getString("FilePath")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eBooks;
    }

    public static void create(EBook eBook) {
        String sql = "insert into EBook(CategoryId, PublicationYear, Title, Language, Author, FilePath) values(" +
                ""+eBook.getCategoryId()+", "+eBook.getPublicationYear()+"', " +
                "'"+eBook.getTitle()+"', " +
                "'"+eBook.getLanguage()+", " +
                "'"+eBook.getAuthor()+"', " +
                "'"+eBook.getFilePath()+"')";
        DatabaseAccess.executeUpdate(sql);
    }


    public static EBook get(int ISBNCode) {
        return create(DatabaseAccess.executeQuery("select * from EBook where ISBNCode = "+ISBNCode));
    }

    public static  List<EBook> all() {
        return createList(DatabaseAccess.executeQuery("select * from EBook"));
    }

}
