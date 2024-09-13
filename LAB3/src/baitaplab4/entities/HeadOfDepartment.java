package baitaplab4.entities;

public class HeadOfDepartment extends AdministrativeStaff{
    private double responsibilitySalary;


    public HeadOfDepartment(String fullName, double salary, double income, double incomeTax, double responsibilitySalary) {
        super(fullName, salary, income, incomeTax);
        this.responsibilitySalary = responsibilitySalary;
    }

    public HeadOfDepartment() {

    }

    public double getResponsibilitySalary() {
        return responsibilitySalary;
    }

    public void setResponsibilitySalary(double responsibilitySalary) {
        this.responsibilitySalary = responsibilitySalary;
    }

    @Override
    public String toString() {
        return " Ho ten: "+getFullName()+" Luong: "+getSalary()+"Luong trach nhiem: "+getResponsibilitySalary() +"Thu nhap: "+getIncome()+" Thue thu nhap: "+getIncomeTax();
    }
}
