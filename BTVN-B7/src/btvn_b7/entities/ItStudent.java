package btvn_b7.entities;

public class ItStudent extends TechMasterStudent{
    private double java, html,css;


    public ItStudent(String fullName, String major, double java, double html, double css) {
        super(fullName, major);
        this.java = java;
        this.html = html;
        this.css = css;
    }

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

    public double getCss() {
        return css;
    }

    public void setCss(double css) {
        this.css = css;
    }

    public double getHtml() {
        return html;
    }

    public void setHtml(double html) {
        this.html = html;
    }

    @Override
    public double getPoint() {
        return (2*java+html+css)/4;
    }
    @Override
    public String toString() {
        return "name:"+getFullName()+" chuyen nganh:" + getMajor()+" getpoin:"+getPoint()+" hoc luc:"+academicAbility();
    }
}
