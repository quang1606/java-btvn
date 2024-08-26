package btvn_b7.entities;

public abstract class  TechMasterStudent {
    private String fullName, major;
    public abstract double getPoint();

    public TechMasterStudent(String fullName, String major) {
        this.fullName = fullName;
        this.major = major;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public String academicAbility(){
        if(getPoint() <5) {
            return "Yeu";
        }else if(5<= getPoint() && getPoint() <6.5){
            return "TB";
        } else if(6.5<= getPoint() && getPoint() < 8) {
            return "KHA";
        }else{
            return "Gioi";
        }
    }

}
