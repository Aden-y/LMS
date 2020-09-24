package dao;

import data.DatabaseAccess;
import models.Billing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {
    public static Billing create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new Billing(resultSet.getInt("BorrowerId"), resultSet.getInt("Days"), resultSet.getDouble("TotalAmount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Billing> createList(ResultSet resultSet) {
        List<Billing> billings = new ArrayList<>();
        try {
            while (resultSet.next()) {
                billings.add(new Billing(resultSet.getInt("BorrowerId"), resultSet.getInt("Days"), resultSet.getDouble("TotalAmount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billings;
    }

    public static void create(Billing billing) {
        String sql = "insert into Billing(BorrowerId) values("+billing.getBorrowerId()+")";
        DatabaseAccess.executeUpdate(sql);
    }

    public static void updateDaily(Billing billing) {
        billing.nextDay();
        String sql = "update Billing set Days = "+billing.getDays()+", TotalAmount = "+billing.getTotalAmount()+" where BorrowerId = "+billing.getBorrowerId();
        DatabaseAccess.executeUpdate(sql);
    }

    public static void stop(Billing billing) {
        DatabaseAccess.executeUpdate("delete from Billing where BorrowerId = "+billing.getBorrowerId());
    }



}
