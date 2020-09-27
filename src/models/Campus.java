package models;

import dao.ShelfDAO;
import dao.StaffDAO;
import dao.StudentDAO;

public class Campus {
    private int CampusNo;
    private String CampusName;

    public Campus(int campusNo,
                  String campusName
    ) {
        CampusNo = campusNo;
        CampusName = campusName;
    }
    public Campus(String  campusName
    ) {
        CampusName = campusName;
    }

    public int getCampusNo() {
        return CampusNo;
    }

    public void setCampusNo(int campusNo) {
        CampusNo = campusNo;
    }

    public String getCampusName() {
        return CampusName;
    }

    public void setCampusName(String campusName) {
        CampusName = campusName;
    }

    public int studentsCount() {
        return StudentDAO.findByCampus(CampusNo).size();
    }

    public int staffCount() {
        return  StaffDAO.findByCampus(CampusNo).size();
    }

    public int shelfCount() {
        return ShelfDAO.findByCampus(CampusNo).size();
    }

    @Override
    public String toString() {
        return CampusName;
    }
}
