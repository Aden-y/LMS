package models;

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
}
