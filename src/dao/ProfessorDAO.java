package dao;

import data.DatabaseAccess;
import models.Professor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    public static Professor create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return  new Professor(
                        resultSet.getString("EmploymentId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email"),
                        resultSet.getString("Department"),
                        resultSet.getString("Password"),
                        resultSet.getInt("EmploymentYear")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Professor> createList(ResultSet resultSet) {
        List<Professor> professors = new ArrayList<>();
        try {
            while (resultSet.next()) {
                professors.add(new Professor(
                        resultSet.getString("EmploymentId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email"),
                        resultSet.getString("Department"),
                        resultSet.getString("Password"),
                        resultSet.getInt("EmploymentYear")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professors;
    }

    public static void create(Professor professor) {
        String sql = "insert into Professor(EmploymentId, FirstName, LastName, Phone, Email, Department, Password, EmploymentYear) values(" +
                "'"+professor.getEmploymentId()+"', " +
                "'"+professor.getFirstName()+"', " +
                "'"+professor.getLastName()+"', " +
                "'"+professor.getPhone()+"', " +
                "'"+professor.getEmail()+"', " +
                "'"+professor.getDepartment()+"', " +
                "'"+professor.getPassword()+"', "+professor.getEmploymentYear()+")";
        DatabaseAccess.executeUpdate(sql);
    }

    public static Professor get(String employmentId) {
        return create(DatabaseAccess.executeQuery("select * from Professor where EmploymentId ='"+employmentId+"'"));
    }

    public static Professor login(String employmentId, String password) {
        return create(DatabaseAccess.executeQuery("select * from Professor where EmploymentId = '"+employmentId+"' and Password = '"+password+"'"));
    }

    public static List<Professor> all() {
        return createList(DatabaseAccess.executeQuery("select * from Professor"));
    }

    public static void updateProfile(Professor professor) {
        String sql ="update Professor set Email ='"+professor.getEmail()+"', Phone = '"+professor.getPhone()+"', Password = '"+professor.getPassword()+"' where EmploymentId ="+professor.getEmploymentId();
        DatabaseAccess.executeUpdate(sql);
    }

    public static Professor findByEmail(String email) {
        return create(DatabaseAccess.executeQuery("select * from Professor where Email = '"+email+"'"));
    }
}
