package models;

public class Shelf {
    private int ShelfId, ShelfNo, FloorNo, CampusNo;;

    public Shelf(int shelfId,
                 int shelfNo,
                 int floorNo,
                 int campusNo
    ) {
        ShelfId = shelfId;
        ShelfNo = shelfNo;
        FloorNo = floorNo;
        CampusNo = campusNo;
    }

    public Shelf(int shelfNo,
                 int floorNo,
                 int campusNo
    ) {
        ShelfNo = shelfNo;
        FloorNo = floorNo;
        CampusNo = campusNo;
    }

    public int getCampusNo() {
        return CampusNo;
    }

    public void setCampusNo(int campusNo) {
        CampusNo = campusNo;
    }

    public int getShelfId() {
        return ShelfId;
    }

    public void setShelfId(int shelfId) {
        ShelfId = shelfId;
    }

    public int getShelfNo() {
        return ShelfNo;
    }

    public void setShelfNo(int shelfNo) {
        ShelfNo = shelfNo;
    }

    public int getFloorNo() {
        return FloorNo;
    }

    public void setFloorNo(int floorNo) {
        FloorNo = floorNo;
    }
}
