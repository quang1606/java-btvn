package btvn_b7.entities;

public class BizStudent extends TechMasterStudent {
    private double marketing, sales;

    public BizStudent(String fullName, String major, double marketing, double sales) {
        super(fullName, major);
        this.marketing = marketing;
        this.sales = sales;
    }

    public double getMarketing() {
        return marketing;
    }

    public void setMarketing(double marketing) {
        this.marketing = marketing;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    @Override
    public double getPoint() {
        return (2 * marketing + sales) / 3;
    }

    @Override
    public String toString() {
        return "name:"+getFullName()+" chuyen nganh:" + getMajor()+" getpoin:"+getPoint()+" hoc luc:"+academicAbility();
    }
}
