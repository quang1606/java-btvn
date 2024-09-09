package baitaplab4.entities;

public class Staff {
    private AdministrativeStaff administrativeStaff;
    private HeadOfDepartment headOfDepartment;
    private MarketingStaff marketingStaff;
    private Position position;

    public Staff(AdministrativeStaff administrativeStaff, MarketingStaff marketingStaff, HeadOfDepartment headOfDepartment, Position position) {
        this.administrativeStaff = administrativeStaff;
        this.marketingStaff = marketingStaff;
        this.headOfDepartment = headOfDepartment;
        this.position = position;
    }




    public AdministrativeStaff getAdministrativeStaff() {
        return administrativeStaff;
    }

    public void setAdministrativeStaff(AdministrativeStaff administrativeStaff) {
        this.administrativeStaff = administrativeStaff;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public MarketingStaff getMarketingStaff() {
        return marketingStaff;
    }

    public void setMarketingStaff(MarketingStaff marketingStaff) {
        this.marketingStaff = marketingStaff;
    }

    public HeadOfDepartment getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(HeadOfDepartment headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    @Override
    public String toString() {
        String result = "Chức vụ: " + getPosition();

        if (getAdministrativeStaff() != null) {
            result += " " + getAdministrativeStaff();
        }
        if (getMarketingStaff() != null) {
            result += " " + getMarketingStaff();
        }
        if (getHeadOfDepartment() != null) {
            result += " " + getHeadOfDepartment();
        }
        return result;
    }

}
