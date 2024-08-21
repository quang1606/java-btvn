public class Employee extends Person {
    private double experience;

    public Employee(int age, int id, String name, double experience) {
        super(age, id, name);
        this.experience = experience;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Age: "+getAge()+"ID: "+getId()+"Name: "+getName()+"Experience: "+getExperience();
    }
}
