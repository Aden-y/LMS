package dao;

import data.DatabaseAccess;
import models.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static Student create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return  new Student(
                        resultSet.getString("StudentNumber"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email"),
                        resultSet.getString("Sex"),
                        resultSet.getString("Department"),
                        resultSet.getString("Password"),
                        resultSet.getDate("DateOfBirth"),
                        resultSet.getInt("BorrowerId"),
                        resultSet.getInt("CampusNo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static List<Student> createList(ResultSet resultSet) {
        List<Student> students = new ArrayList<>();
        try {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getString("StudentNumber"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email"),
                        resultSet.getString("Sex"),
                        resultSet.getString("Department"),
                        resultSet.getString("Password"),
                        resultSet.getDate("DateOfBirth"),
                        resultSet.getInt("BorrowerId"),
                        resultSet.getInt("CampusNo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static  void create(Student student) {
        String sql = "insert into Student (StudentNumber, FirstName, LastName, Phone, Email, Sex, Department,Password, DateOfBirth,  CampusNo) values(";
        sql+="'"+student.getStudentNumber()+"', ";
        sql+="'"+student.getFirstName()+"', ";
        sql+="'"+student.getLastName()+"', ";
        sql+="'"+student.getPhone()+"', ";
        sql+="'"+student.getEmail()+"', ";
        sql+="'"+student.getSex()+"', ";
        sql+="'"+student.getDepartment()+"', ";
        sql+="'"+student.getPassword()+"', ";
        sql+="'"+student.getDateOfBirthString()+"', ";
        sql+=student.getCampusNo()+")";
        System.out.println(sql);
        DatabaseAccess.executeUpdate(sql);
    }

    public static void update(Student student) {
        String sql = "update Student set " +
                "FirstName = '"+student.getFirstName()+"', " +
                "LastName = '"+student.getLastName()+"', " +
                "Phone = '"+student.getPhone()+"', " +
                "Email = '"+student.getEmail()+"', " +
                "Sex = '"+student.getSex()+"', " +
                "Department = '"+student.getDepartment()+"', " +
                "DateOfBirth = '"+student.getDateOfBirth()+"', " +
                "CampusNo = '"+student.getCampusNo()+" where StudentNumber = '"+student.getStudentNumber()+"'";
        DatabaseAccess.executeUpdate(sql);

    }
    public static Student login(String studentNumber, String password) {
        return create(DatabaseAccess.executeQuery("select * from Student where StudentNumber = '"+studentNumber+"' and Password = '"+password+"'"));

    }

    public static Student get(String studentNumber) {
        return create(DatabaseAccess.executeQuery("select * from Student where StudentNumber = '"+studentNumber+"'"));
    }

    public static List<Student> findByCampus(int campusNo) {
        return createList(DatabaseAccess.executeQuery("select * from Student where CampusNo = "+campusNo));
    }

    public static List<Student> all() {
        return createList(DatabaseAccess.executeQuery("select * from Student"));
    }

    public static Student findByBorrowerId(int borrowerId) {
        return create(DatabaseAccess.executeQuery("select * from  Student where BorrowerId = "+borrowerId));
    }

    public static void updateProfile(Student student) {
        String sql ="update Student set Email ='"+student.getEmail()+"', Phone = '"+student.getPhone()+"', Password = '"+student.getPassword()+"' where StudentNumber ='"+student.getStudentNumber()+"'";
        DatabaseAccess.executeUpdate(sql);
    }

    public static Student findByEmail(String email) {
        return create(DatabaseAccess.executeQuery("select * from Student where Email = '"+email+"'"));
    }
}
