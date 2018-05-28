package pl.sda.libraryapp;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorySaver {

    public void addAuthorToRepositoryFile(List<Author> authorList) throws IOException {
        Author authorToWrite = authorList.get(authorList.size() - 1);

        int age = authorToWrite.getAge();
        String name = authorToWrite.getName();
        int id = authorToWrite.getId();

        FileWriter writeToFile = new FileWriter(RepositoryConfig.AUTHORS_REPO_PATH_NAME, true);
        writeToFile.write(id + ";" + name + ";" + age + "\n");
        writeToFile.close();

    }

    public void saveAuthorsToRepositoryFile(List<Author> authorList) throws IOException {
        FileWriter writeToFile = new FileWriter(RepositoryConfig.AUTHORS_REPO_PATH_NAME, false);
        for (Author author : authorList) {

            int id = author.getId();
            String name = author.getName();
            int age = author.getAge();

            writeToFile.write(id + ";" + name + ";" + age + "\n");
        }
        writeToFile.close();
    }

    public void addBookToRepositoryFile(List<Book> bookList) throws IOException {
        Book bookToWrite = bookList.get(bookList.size() - 1);

        String title = bookToWrite.getTitle();
        String isbnNumber = bookToWrite.getIsbnNumber();
        int year = bookToWrite.getYear();
        String coverType = CoverType.getCoverTypeSymbolFromCoverType(bookToWrite.getCoverType());
        String authors = bookToWrite.getAuthors().stream().map(x -> x.getId() + "").collect(Collectors.joining(","));
        int category;
        if(bookToWrite.getCategory() == null){
            category = 0;
        }
        else{
            category = bookToWrite.getCategory().getId();
        }

        FileWriter writeToFile = new FileWriter(RepositoryConfig.BOOKS_REPO_PATH_NAME, true);
        writeToFile.write(title + ";" + isbnNumber + ";" + year + ";" + coverType + ";" + authors + ";" + category + "\n");
        writeToFile.close();

    }

    public void saveBooksToRepositoryFile(List<Book> bookList) throws IOException {
        FileWriter writeToFile = new FileWriter(RepositoryConfig.BOOKS_REPO_PATH_NAME, false);
        for (Book book : bookList) {

            String title = book.getTitle();
            String isbnNumber = book.getIsbnNumber();
            int year = book.getYear();
            String coverType = CoverType.getCoverTypeSymbolFromCoverType(book.getCoverType());
            String authors = book.getAuthors().stream().map(x -> x.getId() + "").collect(Collectors.joining(","));
            int category;
            if(book.getCategory() == null){
                category = 0;
            }
            else{
                category = book.getCategory().getId();
            }

            writeToFile.write(title + ";" + isbnNumber + ";" + year + ";" + coverType + ";" + authors + ";" + category + "\n");
        }
        writeToFile.close();
    }

    public void addCategoryToRepositoryFile(List<Category> categoryList) throws IOException {
        Category categoryToWrite = categoryList.get(categoryList.size() - 1);
        String name = categoryToWrite.getName();
        int id = categoryToWrite.getId();
        int priority = categoryToWrite.getDisplayPriority();

        FileWriter writeToFile = new FileWriter(RepositoryConfig.CATEGORIES_REPO_PATH_NAME, true);
        writeToFile.write(id + ";" + name + ";" + priority + "\n");
        writeToFile.close();

    }

    public void saveCategoriesToRepositoryFile(List<Category> categoryList) throws IOException {
        FileWriter writeToFile = new FileWriter(RepositoryConfig.CATEGORIES_REPO_PATH_NAME, false);
        for (Category category : categoryList) {
            int id = category.getId();
            String name = category.getName();
            int priority = category.getDisplayPriority();
            writeToFile.write(id + ";" + name + ";" + priority + "\n");
        }
        writeToFile.close();
    }

    public void addEmployeeToRepositoryFile(List<Employee> employeeList) throws IOException {
        Employee employeeToWrite = employeeList.get(employeeList.size() - 1);
        int id = employeeToWrite.getId();
        String name = employeeToWrite.getName();
        String surname = employeeToWrite.getSurname();
        String workPosition = employeeToWrite.getClass().getSimpleName();
        double wagePerHour = employeeToWrite.getWagePerHour();
        double monthSalary = employeeToWrite.calculateSalary();
        String telephoneNumber = employeeToWrite.getTelephoneNumber();
        double workingHoursPerMonth = employeeToWrite.getWorkingHours();

        FileWriter writeToFile = new FileWriter(RepositoryConfig.EMPLOYEES_REPO_PATH_NAME, true);
        writeToFile.write(id + ";" + name + ";" + surname + ";" + workPosition + ";" + wagePerHour + ";" + monthSalary + ";"
                + telephoneNumber + ";" + workingHoursPerMonth + "\n");
        writeToFile.close();

    }

    public void saveEmployeesToRepositoryFile(List<Employee> employeeList) throws IOException {
        FileWriter writeToFile = new FileWriter(RepositoryConfig.EMPLOYEES_REPO_PATH_NAME, false);
        for (Employee employee : employeeList) {
            int id = employee.getId();
            String name = employee.getName();
            String surname = employee.getSurname();
            String workPosition = employee.getClass().getSimpleName();
            double wagePerHour = employee.getWagePerHour();
            double monthSalary = employee.calculateSalary();
            String telephoneNumber = employee.getTelephoneNumber();
            double workingHoursPerMonth = employee.getWorkingHours();
            writeToFile.write(id + ";" + name + ";" + surname + ";" + workPosition + ";" + wagePerHour + ";" + monthSalary + ";"
                    + telephoneNumber + ";" + workingHoursPerMonth + "\n");
        }
        writeToFile.close();
    }




}
