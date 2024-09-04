package entities;

public class LogGin {
    private String useName;
    private String passWord;

    public LogGin(String useName, String passWord) {
        this.useName = useName;
        this.passWord = passWord;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
