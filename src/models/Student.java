package models;

import java.sql.Date;

public class Student {
    private String StudentNumber, FirstName , LastName , Phone , Email , Sex , Department, Password;
    private Date DateOfBirth;
    private int BorrowerId , CampusNo;

    public Student(String studentNumber,
                   String firstName,
                   String lastName,
                   String phone,
                   String email,
                   String sex,
                   String department,
                   String password,
                   Date dateOfBirth,
                   int borrowerId,
                   int campusNo
    ) {
        StudentNumber = studentNumber;
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        Email = email;
        Sex = sex;
        Department = department;
        Password = password;
        DateOfBirth = dateOfBirth;
        BorrowerId = borrowerId;
        CampusNo = campusNo;
    }

    public Student(String studentNumber,
                   String firstName,
                   String lastName,
                   String phone,
                   String email,
                   String sex,
                   String department,
                   String password,
                   Date dateOfBirth,
                   int campusNo
    ) {
        StudentNumber = studentNumber;
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        Email = email;
        Sex = sex;
        Department = department;
        Password = password;
        DateOfBirth = dateOfBirth;
        CampusNo = campusNo;
    }

    public int getCampusNo() {
        return CampusNo;
    }

    public void setCampusNo(int campusNo) {
        CampusNo = campusNo;
    }

    public String getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        StudentNumber = studentNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public int getBorrowerId() {
        return BorrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        BorrowerId = borrowerId;
    }
}
