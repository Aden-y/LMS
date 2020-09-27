package models;

import dao.CampusDAO;

public class Staff {
    private String  FirstName , LastName ,Phone ,Email , Password;
    private boolean IsAdmin ;
    private int CampusNo, UserId;

    public Staff(String firstName, String lastName, String phone, String email, String password, boolean isAdmin, int campusNo) {
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        Email = email;
        Password = password;
        IsAdmin = isAdmin;
        CampusNo = campusNo;
    }

    public Staff(int userId,
                 String firstName,
                 String lastName,
                 String phone,
                 String email,
                 String password,
                 boolean isAdmin,
                 int campusNo
    ) {
        UserId = userId;
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        Email = email;
        Password = password;
        IsAdmin = isAdmin;
        CampusNo = campusNo;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isAdmin() {
        return IsAdmin;
    }

    public void setAdmin(boolean admin) {
        IsAdmin = admin;
    }

    public int getCampusNo() {
        return CampusNo;
    }

    public void setCampusNo(int campusNo) {
        CampusNo = campusNo;
    }

    @Override
    public String toString() {
        return FirstName+" "+LastName;
    }

    public  Campus getCampus() {
        return CampusDAO.get(CampusNo);
    }
}
