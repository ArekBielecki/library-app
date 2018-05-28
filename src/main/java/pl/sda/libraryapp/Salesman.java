package pl.sda.libraryapp;

public class Salesman extends Employee{

    private double salaryPerMonth;
    private final double HOURS_PER_MONTH;

    public Salesman(int id, String name, String surname, double salaryPerMonth, double workingHours) {
        super(id, name, surname);
        this.salaryPerMonth = salaryPerMonth;
        HOURS_PER_MONTH = workingHours;
    }

    @Override
    public double getWorkingHours() {
        return HOURS_PER_MONTH;
    }

    @Override
    double calculateSalary() {
        return salaryPerMonth;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
