package dao;

import data.DatabaseAccess;
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
                        resultSet.getString("Issuer")
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
                        resultSet.getString("Issuer")
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





}
