package dao;

import data.DatabaseAccess;
import models.ProfessorBookRequest;
import models.ProfessorBorrow;
import services.DateService;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ProfessorBookRequestDAO {
    public static ProfessorBookRequest create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new ProfessorBookRequest(
                        resultSet.getInt("RequestId"),
                        resultSet.getInt("ISBNCode"),
                        resultSet.getString("EmploymentId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<ProfessorBookRequest> createList(ResultSet resultSet) {
        List<ProfessorBookRequest> requests = new ArrayList<>();
        try {
            while (resultSet.next()) {
                requests.add(new ProfessorBookRequest(
                        resultSet.getInt("RequestId"),
                        resultSet.getInt("ISBNCode"),
                        resultSet.getString("EmploymentId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  requests;
    }

    public static void create(ProfessorBookRequest request) {
        String sql = "insert into ProfessorBookRequest(EmploymentId, ISBNCode) values('"+request.getEmploymentId()+"', "+request.getISBNCode()+")";
        System.out.println(sql);
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<ProfessorBookRequest> findByBorrowerId(String borrowerId) {
        return createList(DatabaseAccess.executeQuery("select * from ProfessorBookRequest where EmploymentId = '"+borrowerId+"'"));
    }

    public static List<ProfessorBookRequest>  all() {
        return createList(DatabaseAccess.executeQuery("select * from ProfessorBookRequest"));
    }



    public static void  accept(ProfessorBookRequest request, int issuerId) {
        ProfessorBorrow borrower = new ProfessorBorrow(
                request.getISBNCode(),
                new Date(new java.util.Date().getTime()),
                DateService.returnDate(),
                null,
                issuerId,
                request.getEmploymentId()
        );

        ProfessorBorrowDAO.record(borrower);
        delete(request.getRequestId());
    }

    public static void delete(int requestId) {
        DatabaseAccess.executeUpdate("delete from ProfessorBookRequest where RequestId = "+requestId);
    }

    public static ProfessorBookRequest get(int requestId) {
        return create(DatabaseAccess.executeQuery("select * from ProfessorBookRequest where RequestId = "+requestId));
    }


    public static boolean isRequested(int ISBNCode, String borrowerId) {
        try {
            return  DatabaseAccess.executeQuery("select * from ProfessorBookRequest where EmploymentId = '"+borrowerId+"' and ISBNCode = "+ISBNCode).next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
