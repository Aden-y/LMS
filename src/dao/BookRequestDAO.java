package dao;

import data.DatabaseAccess;
import models.BookRequest;
import models.Borrower;
import services.DateService;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRequestDAO {

    public static BookRequest create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new BookRequest(
                        resultSet.getInt("RequestId"),
                        resultSet.getInt("BorrowerId"),
                        resultSet.getInt("ISBNCode")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<BookRequest> createList(ResultSet resultSet) {
        List<BookRequest> requests = new ArrayList<>();
        try {
            while (resultSet.next()) {
                requests.add(new BookRequest(
                        resultSet.getInt("RequestId"),
                        resultSet.getInt("BorrowerId"),
                        resultSet.getInt("ISBNCode")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  requests;
    }

    public static void create(BookRequest request) {
        String sql = "insert into BookRequest(BorrowerId, ISBNCode) values("+request.getBorrowerId()+", "+request.getISBNCode()+")";
        System.out.println(sql);
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<BookRequest> findByBorrowerId(int borrowerId) {
        return createList(DatabaseAccess.executeQuery("select * from BookRequest where BorrowerId = "+borrowerId));
    }

    public static List<BookRequest>  all() {
        return createList(DatabaseAccess.executeQuery("select * from BookRequest"));
    }

    public static List<BookRequest> findByCampus(int campusNo) {
        String sql = "select BookRequest.* from BookRequest " +
                "inner join Student on BookRequest.BorrowerId = Student.BorrowerId where Student.CampusNo = "+campusNo;
        return createList(DatabaseAccess.executeQuery(sql));
    }

    public static void  accept(BookRequest request, int issuerId) {
        Borrower borrower = new Borrower(
                request.getBorrowerId(),
                request.getISBNCode(),
                new Date(new java.util.Date().getTime()),
                DateService.returnDate(),
                issuerId
        );

        BorrowerDAO.record(borrower);
        delete(request.getRequestId());
    }

    public static void delete(int requestId) {
        DatabaseAccess.executeUpdate("delete from BookRequest where RequestId = "+requestId);
    }

    public static BookRequest get(int requestId) {
        return create(DatabaseAccess.executeQuery("select * from BookRequest where RequestId = "+requestId));
    }


    public static boolean isRequested(int ISBNCode, int borrowerId) {
        try {
            return  DatabaseAccess.executeQuery("select * from BookRequest where BorrowerId ="+borrowerId+" and ISBNCode = "+ISBNCode).next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
