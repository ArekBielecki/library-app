package pl.sda.libraryapp;

public abstract class Employee {
    private int id;
    private String name;
    private String surname;

    public Employee(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getWagePerHour() {
        return 0;
    }

    public String getTelephoneNumber() {
        return null;
    }

    abstract double calculateSalary();

    abstract double getWorkingHours();

    @Override
    public String toString(){
        return "id: " + id + ", Name: " + name + ", Surname: " + surname + ", Salary: " + calculateSalary() + ", Position: " +
                this.getClass().getSimpleName();
    }

}
