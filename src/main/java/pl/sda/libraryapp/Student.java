package pl.sda.libraryapp;

public class Student extends Employee{

    private double wagePerHour;
    private double workingHours;


    public Student(int id, String name, String surname, double wagePerHour) {
        super(id, name, surname);
        this.wagePerHour = wagePerHour;
    }

    public Student(int id, String name, String surname, double wagePerHour, double workingHours) {
        this(id, name, surname, wagePerHour);
        this.workingHours = workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public double getWorkingHours() {
        return workingHours;
    }

    @Override
    public double getWagePerHour() {
        return wagePerHour;
    }

    @Override
    double calculateSalary() {
        return Math.round(workingHours*wagePerHour*100.0)/100.0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
