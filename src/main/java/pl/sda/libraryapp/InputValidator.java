package pl.sda.libraryapp;

public class InputValidator {

    public boolean isIsbnValid(String isbnNumber) {

        if (!isbnNumber.matches("^[0-9]+")) {
            System.out.println("ISBN can contain digits only");
            return false;
        }
        if (isbnNumber.length() != 10) {
            System.out.println("ISBN number has to contain 10 digits");
            return false;
        }
        return true;
    }

    public boolean isPublicationYearValid(int year){
        return year > 1900 && year <= 2018;
    }

    public boolean isAgeValid(int age){
        if(age < 0){
            System.out.println("Age cannot be negative value");
            return false;
        }
        if(age > 110){
            System.out.println("I wish people live that long");
            return false;
        }
        return true;
    }

    public boolean isTelephoneNumberValid(String telephoneNumber) {

        if (!telephoneNumber.matches("^[0-9]+")) {
            System.out.println("Telephone number can contain digits only");
            return false;
        }
        if (telephoneNumber.length() != 9) {
            System.out.println("Telephone number has to contain 9 digits");
            return false;
        }
        return true;
    }

    public boolean isCoverTypeValid(int coverType) {
        return coverType == 1 || coverType == 2;
    }

    public boolean areWorkingHoursValid(double workingHours){
        if(workingHours < 0){
            System.out.println("Working hours cannot be lower than 0");
            return false;
        }
        if(workingHours > 160){
            System.out.println("Working hours cannot be higher than 160");
            return false;
        }
        return true;
    }

    public boolean isWagePerHourValid(double wagePerHour) {
        if(wagePerHour < 0){
            System.out.println("Wage cannot be lower than 0");
            return false;
        }
        if(wagePerHour > 50.0){
            System.out.println("Wage cannot be higher than 50");
            return false;
        }
        return true;
    }

    public boolean isSalaryValid(double salary){
        if(salary < 0){
            System.out.println("Salary cannot be lower than 0");
            return false;
        }
        if(salary > 4300){
            System.out.println("Salary cannot be higher than 4300");
            return false;
        }
        return true;
    }

    public boolean isPriorityValid(int priorityNumber) {
        if(priorityNumber <= 0 || priorityNumber > 3){
            System.out.println("Priority has to be from 1 - 3 range");
            return false;
        }
        return true;
    }
}
