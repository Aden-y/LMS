package dao;

import data.DatabaseAccess;
import models.Shelf;
import services.DateService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShelfDAO {
    public static Shelf create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new Shelf(
                        resultSet.getInt("ShelfId"),
                        resultSet.getInt("ShelfNo"),
                        resultSet.getInt("FloorNo"),
                        resultSet.getInt("CampusNo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Shelf> createList(ResultSet resultSet) {
        List<Shelf> shelves = new ArrayList<>();
        try {
            while (resultSet.next()) {
                shelves.add(new Shelf(
                        resultSet.getInt("ShelfId"),
                        resultSet.getInt("ShelfNo"),
                        resultSet.getInt("FloorNo"),
                        resultSet.getInt("CampusNo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shelves;
    }

    public static void create(Shelf shelf) {
        String sql = "insert into Shelf(ShelfNo, FloorNo, CampusNo) values(" +
                ""+shelf.getShelfNo()+", "+shelf.getFloorNo()+", "+shelf.getCampusNo()+")";
        DatabaseAccess.executeUpdate(sql);
    }

    public static List<Shelf> all() {
        return createList(DatabaseAccess.executeQuery("select * from Shelf"));
    }


    public static List<Shelf> findByCampus(int campusNo) {
        return createList(DatabaseAccess.executeQuery("select * from Shelf where CampusNo = "+campusNo));
    }
}
