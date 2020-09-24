package models;

public class Billing {
    private int BorrowerId, Days;
    private double TotalAmount;
    public  static final double DailyAmount =  10.0;

    public Billing(int borrowerId,
                   int days,
                   double totalAmount
    ) {
        BorrowerId = borrowerId;
        Days = days;
        TotalAmount = totalAmount;
    }

    public int getBorrowerId() {
        return BorrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        BorrowerId = borrowerId;
    }

    public int getDays() {
        return Days;
    }

    public void setDays(int days) {
        Days = days;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        TotalAmount = totalAmount;
    }

    public void nextDay() {
        Days+=1;
        TotalAmount+= DailyAmount;
    }
}

