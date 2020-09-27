package models;

public class Professor {
    private String EmploymentId ,FirstName , LastName , Phone , Email , Department , Password;
    private int EmploymentYear ;

    public Professor(String employmentId,
                     String firstName,
                     String lastName,
                     String phone,
                     String email,
                     String department,
                     String password,
                     int employmentYear
    ) {
        EmploymentId = employmentId;
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        Email = email;
        Department = department;
        Password = password;
        EmploymentYear = employmentYear;
    }

    public String getEmploymentId() {
        return EmploymentId;
    }

    public void setEmploymentId(String employmentId) {
        EmploymentId = employmentId;
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

    public int getEmploymentYear() {
        return EmploymentYear;
    }

    public void setEmploymentYear(int employmentYear) {
        EmploymentYear = employmentYear;
    }

    @Override
    public String toString() {
        return FirstName +" "+ LastName;
    }
}
