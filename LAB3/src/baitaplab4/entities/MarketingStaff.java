package baitaplab4.entities;

public class MarketingStaff extends  AdministrativeStaff{
    private double sales;
    private double commissionRate;

    public MarketingStaff(String fullName, double salary, double income, double incomeTax, double commissionRate, double sales) {
        super(fullName, salary, income, incomeTax);
        this.commissionRate = commissionRate;
        this.sales = sales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "ID: "+getId()+" Ho ten: "+getFullName()+" Luong: "+getSalary()+"Doanh so: "+getSales()+" hoa hong: "+getCommissionRate()+"Thu nhap: "+getIncome()+" Thue thu nhap: "+getIncomeTax();
    }
}
