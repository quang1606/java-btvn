package baitaplab5.entities;

public class Pet {
    private static int countId;
    private int id;
    private String name;
    private String species;
    private int age;
    private Sex sex;
    private String description;
    private Type type;
    private String images;

    public Pet( String images, Type type, String description, Sex sex, int age, String species, String name) {
        this.id = ++countId;
        this.images = images;
        this.type = type;
        this.description = description;
        this.sex = sex;
        this.age = age;
        this.species = species;
        this.name = name;
    }

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        Pet.countId = countId;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", images='" + images + '\'' +
                '}';
    }
}
