public class Account {
    private String usename, password;
    private int balance;

    // Constructor không đối số
    public Account() {
    }

    // Constructor với các đối số
    public Account(String usename, String password, int balance) {
        this.usename = usename;
        this.password = password;
        this.balance = balance;
    }

    // Getter và Setter cho username
    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    // Getter và Setter cho password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter và Setter cho balance
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account" +
                " usename= " + usename +
                " password= " + password +
                " balance= " + balance;
    }
}
