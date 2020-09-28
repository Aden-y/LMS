package dao;

import data.DatabaseAccess;
import models.Book;
import models.ProfessorBorrow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorBorrowDAO {
    public static ProfessorBorrow create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new ProfessorBorrow(

                        resultSet.getInt("BookId"),
                        resultSet.getDate("BorrowedFrom"),
                        resultSet.getDate("BorrowedTo"),
                        resultSet.getDate("ReturnDate"),
                        resultSet.getInt("Issuer"),
                        resultSet.getString("EmploymentId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<ProfessorBorrow> createList(ResultSet resultSet) {
        List<ProfessorBorrow> borrowers = new ArrayList<>();
        try {
            while (resultSet.next()) {
                borrowers.add(new ProfessorBorrow(
                        resultSet.getInt("BookId"),
                        resultSet.getDate("BorrowedFrom"),
                        resultSet.getDate("BorrowedTo"),
                        resultSet.getDate("ReturnDate"),
                        resultSet.getInt("Issuer"),
                        resultSet.getString("EmploymentId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  borrowers;
    }

    public static void record(ProfessorBorrow borrower) {
        String sql = "insert into ProfessorBorrow(EmploymentId, BookId,BorrowedFrom, BorrowedTo, Issuer) values(" +
                "'"+borrower.getEmploymentId()+"', "+borrower.getBookId()+", " +
                "'"+borrower.getBorrowedFromString()+"', " +
                "'"+borrower.getBorrowedToString()+"', " +
                "'"+borrower.getIssuer()+"')";
        DatabaseAccess.executeUpdate(sql);
        Book book = BookDAO.get(borrower.getBookId());
        book.borrow();
        BookDAO.updateBorrowed(book);
    }

    public static List<ProfessorBorrow> all() {
        return createList(DatabaseAccess.executeQuery("select * from ProfessorBorrow"));
    }

    public static void clear(String borrowerId, int ISBNCode) {
        Book book = BookDAO.get(ISBNCode);
        book.return$();
        BookDAO.updateBorrowed(book);
        DatabaseAccess.executeUpdate("delete from ProfessorBorrow where EmploymentId = '"+borrowerId+"' and BookId = "+ISBNCode);
    }


    public static void remind(ProfessorBorrow borrower) {
        String subject = "Return Date Reminder",
                message = "You should return the Book ISBN "+borrower.getBookId()+" by "+borrower.getBorrowedToString();

    }

    public static List<ProfessorBorrow> get(String borrowerId) {
        return createList(DatabaseAccess.executeQuery("select * from ProfessorBorrow where EmploymentId = '"+borrowerId+"'"));
    }

    public static boolean hasBorrowed(String borrowerId, int ISBNCode) {
        try {
            return DatabaseAccess.executeQuery("select * from ProfessorBorrow where EmploymentId = '"+borrowerId +"' and BookId = "+ISBNCode).next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
