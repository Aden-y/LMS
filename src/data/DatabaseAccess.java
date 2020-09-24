package data;

import java.sql.*;

public class DatabaseAccess {
    private static final String
            password = "",
            url="jdbc:mysql://localhost/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
            user  = "root";
    private static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet executeQuery(String sql) {
        Connection connection = connect();
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  resultSet;
    }

    public static void executeUpdate(String sql) {
        Connection connection = connect();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getLastInsertedIndex(String sql) {
        Connection connection = connect();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return (int) resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
