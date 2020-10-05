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
                        resultSet.getInt("UserId"),
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
                staff.add(new Staff(resultSet.getInt("UserId"),
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

    public static int create(Staff staff) {
        String sql = "insert into Staff (UserId, FirstName, LastName, Phone, Email, Password, CampusNo) values (" +
                "'"+staff.getUserId()+"', " +
                "'"+staff.getFirstName()+"', " +
                "'"+staff.getLastName()+"', " +
                "'"+staff.getPhone()+"', " +
                "'"+staff.getEmail()+"', " +
                "'"+staff.getPassword()+"', " +staff.getCampusNo()+")";
       return  DatabaseAccess.getLastInsertedIndex(sql);
    }

    public static Staff login(String userId, String password) {
        return create(DatabaseAccess.executeQuery("select * from Staff where UserId = '"+userId+"' and Password = '"+password+"'"));
    }

    public static List<Staff> findByCampus(int campusNo){
        return  createList(DatabaseAccess.executeQuery("select * from Staff where CampusNo = "+campusNo));
    }

    public static List<Staff> all() {
        return createList(DatabaseAccess.executeQuery("select * from Staff"));
    }

    public static Staff get(int userId) {
        return create(DatabaseAccess.executeQuery("select * from Staff where UserId = "+userId));
    }

    public static void updateProfile(Staff staff) {
        String sql ="update Staff set Email ='"+staff.getEmail()+"', Phone = '"+staff.getPhone()+"' ,Password = '"+staff.getPassword()+"' where UserId ="+staff.getUserId();
        DatabaseAccess.executeUpdate(sql);
    }

    public static void delete(int userId) {
        DatabaseAccess.executeUpdate("delete from Staff where UserId = "+userId);

    }

    public static void makeAdmin(int userId) {
        DatabaseAccess.executeUpdate("update Staff set IsAdmin = 1 where UserId = "+userId);
    }

    public static Staff findByEmail(String email) {
        return create(DatabaseAccess.executeQuery("select * from Staff where Email = '"+email+"'"));
    }

}
