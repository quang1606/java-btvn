package baitaplab4.entities;

public class AdministrativeStaff {
  ;
    private String fullName;
    private double salary;
    private double income;
    private double incomeTax;


    public AdministrativeStaff(String fullName, double salary, double income, double incomeTax) {
        this.fullName = fullName;
        this.salary = salary;
        this.income = income;
        this.incomeTax = incomeTax;

    }

    public AdministrativeStaff() {

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
        return " Ho ten: "+getFullName()+" Luong: "+getSalary()+" Thu nhap: "+getIncome()+" Thue thu nhap: "+getIncomeTax();
    }
}
