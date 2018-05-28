package pl.sda.libraryapp;

import java.io.IOException;
import java.util.List;

public class EmployeeRepository {
    private static EmployeeRepository employeeRepository = null;
    private static List<Employee> employeeList;
    private EmployeeFactory employeeFactory = new EmployeeFactory();

    private EmployeeRepository() {};

    public static EmployeeRepository getInstance() throws IOException {
        if (employeeRepository == null) {
            ImportFile importFile = new ImportFile(RepositoryConfig.EMPLOYEES_REPO_PATH_NAME);
            employeeList = importFile.parseInputFileAsEmployeeList();
            return employeeRepository = new EmployeeRepository();
        }
        return employeeRepository;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee() throws NoInputValueException {
        int id = employeeList.get(employeeList.size() - 1).getId() + 1;
        employeeList.add(employeeFactory.addEmployee(id));
    }
}
