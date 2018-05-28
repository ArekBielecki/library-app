package pl.sda.libraryapp;


public class EmployeeFactory {
    private UserInput userInput = new UserInput();
    private Displayer displayer = new Displayer();
    private InputValidator inputValidator = new InputValidator();

    public Employee addEmployee(int id) throws NoInputValueException {

        String name = setName();
        String surname = setSurname();

        displayer.displayWorkPosts();

        int choiceNumber = userInput.getIntegerNumberFromUser();
        switch (choiceNumber) {
            case 1:
                return addManager(id, name, surname);
            case 2:
                return addSalesman(id, name, surname);
            case 3:
                return addStudent(id, name, surname);
            default:
                return null;

        }
    }

    private String setName() throws NoInputValueException {
        System.out.println("Add name: ");
        return userInput.getStringFromUser();
    }

    private String setSurname() throws NoInputValueException {
        System.out.println("Add surname: ");
        return userInput.getStringFromUser();
    }

    private String setTelephoneNumber() throws NoInputValueException {
        String telephoneNumber;
        do{
            System.out.println("Add telephone number: ");
            telephoneNumber = userInput.getStringFromUser();
        }while(!inputValidator.isTelephoneNumberValid(telephoneNumber));
        return telephoneNumber;
    }

    private double setWagePerHour() throws NoInputValueException {
        double wagePerHour;
        do{
            System.out.println("Add wage per hour: ");
            wagePerHour = userInput.getDoubleNumberFromUser();
        }while(!inputValidator.isWagePerHourValid(wagePerHour));

        return wagePerHour;
    }

    private double setMonthSalary() throws NoInputValueException {
        double monthSalary;
        do{
            System.out.println("Add month salary: ");
            monthSalary = userInput.getIntegerNumberFromUser();
        }while(!inputValidator.isSalaryValid(monthSalary));
        System.out.println("Add month salary: ");
        return monthSalary;
    }

    private double setWorkingHours() throws NoInputValueException {
        double workingHours;
        do{
            System.out.println("Set Working hours: ");
            workingHours = userInput.getDoubleNumberFromUser();
        }while(!inputValidator.areWorkingHoursValid(workingHours));
        return workingHours;
    }

    private Manager addManager(int id, String name, String surname) throws NoInputValueException {
        String telephoneNumber = setTelephoneNumber();
        double wagePerHour = setWagePerHour();
        double workingHours = setWorkingHours();
        return new Manager(id, name, surname, telephoneNumber, wagePerHour, workingHours);
    }

    private Salesman addSalesman(int id, String name, String surname) throws NoInputValueException {
        double monthSalary = setMonthSalary();
        double workingHours = setWorkingHours();
        return new Salesman(id, name, surname, monthSalary, workingHours);
    }

    private Student addStudent(int id, String name, String surname) throws NoInputValueException {
        double wagePerHour = setWagePerHour();
        return new Student(id, name, surname, wagePerHour);
    }
}
