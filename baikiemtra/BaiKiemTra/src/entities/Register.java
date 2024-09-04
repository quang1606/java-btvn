package entities;

public class Register extends LogGin{
   private String email;

    public Register(String useName, String passWord) {
        super(useName, passWord);
    }

    public Register(String useName, String passWord, String email) {
        super(useName, passWord);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Register{" +
                "email='" + email + '\'' +
                '}';
    }
}
