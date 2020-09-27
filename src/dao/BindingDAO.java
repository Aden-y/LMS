package dao;

import data.DatabaseAccess;
import models.Binding;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BindingDAO {
    public static Binding create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new Binding(resultSet.getInt("BindingId"), resultSet.getString("BindingName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Binding> createList(ResultSet resultSet) {
        List<Binding> bindings = new ArrayList<>();
        try {
            while (resultSet.next()) {
                bindings.add(new Binding(resultSet.getInt("BindingId"), resultSet.getString("BindingName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  bindings;
    }


    public static void create(Binding binding) {
        String sql = "insert into Binding (BindingName) values('"+binding.getBindingName()+"')";
        DatabaseAccess.executeUpdate(sql);
    }

    public static Binding get(int bindingId) {
        return create(DatabaseAccess.executeQuery("select * from Binding where BindingId = "+bindingId));
    }

    public static List<Binding> all() {
        return createList(DatabaseAccess.executeQuery("select * from Binding "));
    }
}
