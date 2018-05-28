package pl.sda.libraryapp;

import java.io.IOException;

public class RepositoryInitializer {

    private static AuthorRepository authorRepository;
    private static BookRepository bookRepository;
    private static CategoryRepository categoryRepository;
    private static EmployeeRepository employeeRepository;


    public static void initialize() throws IOException {
        authorRepository = AuthorRepository.getInstance();
        bookRepository = BookRepository.getInstance();
        categoryRepository = CategoryRepository.getInstance();
        employeeRepository = EmployeeRepository.getInstance();

    }


    public static AuthorRepository getAuthorRepository(){
        return authorRepository;
    }

    public static BookRepository getBookRepository() {
        return bookRepository;
    }

    public static CategoryRepository getCategoryRepository(){
        return categoryRepository;
    }

    public static EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }
}
