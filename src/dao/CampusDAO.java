package dao;

import data.DatabaseAccess;
import models.Campus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampusDAO {
    public static Campus create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new Campus(
                        resultSet.getInt("CampusNo"),
                        resultSet.getString("CampusName")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Campus> createList(ResultSet resultSet) {
        List<Campus> campuses = new ArrayList<>();
        try {
            while (resultSet.next()) {
                campuses.add(new Campus(resultSet.getInt("CampusNo"), resultSet.getString("CampusName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return campuses;
    }

    public static void create(Campus campus) {
        String sql = "insert into Campus( CampusName) values('"+campus.getCampusName()+"')";
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<Campus> all() {
        return createList(DatabaseAccess.executeQuery("select * from Campus"));
    }

    public static Campus get(int campusNo) {
        return  create(DatabaseAccess.executeQuery("select * from Campus where CampusNo = "+campusNo));
    }


}
