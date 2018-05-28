package pl.sda.libraryapp;

public class Author {

    private int id;

    private String name;

    private int age;

    public Author(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author id: " + getId() + ", Author name: " + getName()
                + ", Age: " + getAge();
    }
}
