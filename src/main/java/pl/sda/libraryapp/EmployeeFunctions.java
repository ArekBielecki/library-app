package pl.sda.libraryapp;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFunctions {
    private EmployeeRepository employeeRepository;
    private RepositorySaver repositorySaver;
    private List<Employee> employeeList;

    public EmployeeFunctions(EmployeeRepository employeeRepository, RepositorySaver repositorySaver) {
        this.employeeRepository = employeeRepository;
        this.repositorySaver = repositorySaver;

        employeeList = employeeRepository.getEmployeeList();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addNewEmployee() throws NoInputValueException, IOException {
        employeeRepository.addEmployee();
        repositorySaver.addEmployeeToRepositoryFile(getEmployeeList());
    }

    public List<Employee> getStudentList() {
        return employeeList.stream()
                .filter(x -> x.getClass().getSimpleName().equals("Student"))
                .collect(Collectors.toList());
    }

    public void setStudentsWorkingHours(int studentId, double workingHours) {
        Student student = (Student)getStudentList().stream().filter(x -> x.getId() == studentId).findFirst().orElse(null);
        if (student != null) {
            student.setWorkingHours(workingHours);
        } else System.out.println("There is no student for given id!");
    }

    public boolean isStudentInRepository(int studentId) {
        return getStudentList().stream()
                .anyMatch(x -> x.getId() == studentId);
    }
}
