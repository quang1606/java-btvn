package baitaplab3.entities;

public class Worker {
    private static int idCount;
    private int id;
    private String name;
    private int age;
    private double salary;
    private String wordPlace;

    public Worker( String name, int age, double salary, String wordPlace) {
        this.id = ++idCount;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.wordPlace = wordPlace;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Worker.idCount = idCount;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWordPlace() {
        return wordPlace;
    }

    public void setWordPlace(String wordPlace) {
        this.wordPlace = wordPlace;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", wordPlace='" + wordPlace + '\'' +
                '}';
    }
}
