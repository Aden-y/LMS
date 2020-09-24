package dao;

import data.DatabaseAccess;
import models.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {
    public static Staff create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return  new Staff(
                        resultSet.getString("UserId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getBoolean("IsAdmin"),
                        resultSet.getInt("CampusNo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Staff> createList(ResultSet resultSet) {
        List<Staff> staff = new ArrayList<>();
        try {
            while (resultSet.next()) {
                staff.add(new Staff(resultSet.getString("UserId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getBoolean("IsAdmin"),
                        resultSet.getInt("CampusNo"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }

    public static void create(Staff staff) {
        String sql = "insert into Staff (UserId, FirstName, LastName, Phone, Email, Password, CampusNo) values (" +
                "'"+staff.getUserId()+"', " +
                "'"+staff.getFirstName()+"', " +
                "'"+staff.getLastName()+"', " +
                "'"+staff.getPhone()+"', " +
                "'"+staff.getEmail()+"', " +
                "'"+staff.getPassword()+"', " +staff.getCampusNo()+")";
        DatabaseAccess.executeUpdate(sql);
    }

    public static Staff login(String userId, String password) {
        return create(DatabaseAccess.executeQuery("select * from Staff where UserId = '"+userId+"' and Password = '"+password+"'"));
    }


}