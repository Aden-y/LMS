package dao;

import data.DatabaseAccess;
import models.Book;
import models.Borrower;
import services.MailerService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowerDAO {
    public static Borrower create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new Borrower(
                        resultSet.getInt("BorrowerId"),
                        resultSet.getInt("BookId"),
                        resultSet.getDate("BorrowedFrom"),
                        resultSet.getDate("BorrowedTo"),
                        resultSet.getDate("ReturnDate"),
                        resultSet.getInt("Issuer")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Borrower> createList(ResultSet resultSet) {
        List<Borrower> borrowers = new ArrayList<>();
        try {
            while (resultSet.next()) {
                borrowers.add(new Borrower(
                        resultSet.getInt("BorrowerId"),
                        resultSet.getInt("BookId"),
                        resultSet.getDate("BorrowedFrom"),
                        resultSet.getDate("BorrowedTo"),
                        resultSet.getDate("ReturnDate"),
                        resultSet.getInt("Issuer")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  borrowers;
    }

    public static void record(Borrower borrower) {
        String sql = "insert into Borrower(BorrowerId, BookId,BorrowedFrom, BorrowedTo, Issuer) values(" +
                ""+borrower.getBorrowerId()+", "+borrower.getBookId()+", " +
                "'"+borrower.getBorrowedFromString()+"', " +
                "'"+borrower.getBorrowedToString()+"', " +
                "'"+borrower.getIssuer()+"')";
        DatabaseAccess.executeUpdate(sql);
        Book book = BookDAO.get(borrower.getBookId());
        book.borrow();
        BookDAO.updateBorrowed(book);
    }

    public static List<Borrower> all() {
        return createList(DatabaseAccess.executeQuery("select * from Borrower"));
    }

    public static void clear(int borrowerId) {
        DatabaseAccess.executeUpdate("delete from Borrower where BorrowerId = "+borrowerId);
    }


    public static void remind(Borrower borrower) {
        String subject = "Return Date Reminder",
                message = "You should return the Book ISBN "+borrower.getBookId()+" by "+borrower.getBorrowedToString();

    }

    public static Borrower get(int borrowerId) {
        return create(DatabaseAccess.executeQuery("select * from Borrower where BorrowerId = "+borrowerId));
    }


}
