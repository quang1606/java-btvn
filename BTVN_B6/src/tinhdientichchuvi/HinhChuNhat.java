package tinhdientichchuvi;

public class HinhChuNhat extends  HinhHoc{
    private  double width, length;

    public HinhChuNhat(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public HinhChuNhat() {
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}
