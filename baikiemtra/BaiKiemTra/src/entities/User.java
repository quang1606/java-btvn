package entities;

public class User {
    private String useName;
    private String passWord;
    private String email;

    public User(String useName, String passWord, String email) {
        this.useName = useName;
        this.passWord = passWord;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
