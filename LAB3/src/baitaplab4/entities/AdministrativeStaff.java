package baitaplab4.entities;

public class AdministrativeStaff {
    private static int countID;
    private int id;
    private String fullName;
    private double salary;
    private double income;
    private double incomeTax;


    public AdministrativeStaff(String fullName, double salary, double income, double incomeTax) {
        this.fullName = fullName;
        this.salary = salary;
        this.income = income;
        this.incomeTax = incomeTax;
        this.id = ++countID;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public static int getCountID() {
        return countID;
    }

    public static void setCountID(int countID) {
        AdministrativeStaff.countID = countID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: "+id+" Ho ten: "+getFullName()+" Luong: "+getSalary()+" Thu nhap: "+getIncome()+" Thue thu nhap: "+getIncomeTax();
    }
}
