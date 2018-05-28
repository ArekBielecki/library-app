package pl.sda.libraryapp;

public class Manager extends Employee{
    private String telephoneNumber;
    private double wagePerHour;
    private final double HOURS_PER_MONTH;

    public Manager(int id, String name, String surname, String telephoneNumber, double wagePerHour, double workingHours) {
        super(id, name, surname);
        this.telephoneNumber = telephoneNumber;
        this.wagePerHour = wagePerHour;
        HOURS_PER_MONTH = workingHours;
    }

    @Override
    public double getWorkingHours() {
        return HOURS_PER_MONTH;
    }

    @Override
    public double getWagePerHour() {
        return wagePerHour;
    }

    @Override
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    double calculateSalary() {
        return Math.round(wagePerHour*HOURS_PER_MONTH*100.0)/100.0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
