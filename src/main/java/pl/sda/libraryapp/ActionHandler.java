package pl.sda.libraryapp;


import java.io.IOException;
import java.util.List;

public class ActionHandler {

    private AuthorRepository authorRepository = RepositoryInitializer.getAuthorRepository();
    private BookRepository bookRepository = RepositoryInitializer.getBookRepository();
    private CategoryRepository categoryRepository = RepositoryInitializer.getCategoryRepository();
    private EmployeeRepository employeeRepository = RepositoryInitializer.getEmployeeRepository();

    private RepositorySaver repositorySaver = new RepositorySaver();

    private AuthorFunctions authorFunctions = new AuthorFunctions(authorRepository, bookRepository, repositorySaver);
    private BookFunctions bookFunctions = new BookFunctions(bookRepository, repositorySaver, authorFunctions);
    private CategoryFunctions categoryFunctions = new CategoryFunctions(categoryRepository, repositorySaver);
    private EmployeeFunctions employeeFunctions = new EmployeeFunctions(employeeRepository, repositorySaver);

    private Displayer displayer = new Displayer();

    private UserInput userInput = new UserInput();
    private InputValidator inputValidator = new InputValidator();

    private BookCreator bookCreator = new BookCreator();

    public void saveRepositoryFilesAndCloseApp() throws IOException {
        System.out.println("Saving repositories...");
        repositorySaver.saveAuthorsToRepositoryFile(authorFunctions.getAuthorList());
        repositorySaver.saveBooksToRepositoryFile(bookFunctions.getBookList());
        repositorySaver.saveCategoriesToRepositoryFile(categoryFunctions.getCategoryList());
        repositorySaver.saveEmployeesToRepositoryFile(employeeFunctions.getEmployeeList());
        System.out.println("Repositories saved");
        System.out.println("Closing app");

    }

    public void showBookList() {
        displayer.displayBookList(bookFunctions.getBookList());
    }

    public void showAuthorList() {
        displayer.displayAuthorList(authorFunctions.getAuthorList());
    }

    public void showCategoryList() {
        displayer.displayCategoryList(categoryFunctions.getCategoryList());
    }

    public void showBooksSortedAscendingByPublicationYear() {
        displayer.displayBookList(bookFunctions.sortBooksAscendingByPublicationYear());
    }

    public void showBooksSortedDescendingByPublicationYear() {
        displayer.displayBookList(bookFunctions.sortBooksDescendingByPublicationYear());
    }

    public void showBooksPublishedAfterSpecifiedYear() throws NoInputValueException {
        System.out.println("Enter publication year: ");
        int publicationYear = userInput.getIntegerNumberFromUser();

        displayer.displayBookList(bookFunctions.getBooksPublishedAfterSpecifiedYear(publicationYear));
    }

    public void showBooksWhichBelongToGivenCategory() throws NoInputValueException {
        displayer.displayCategoryList(categoryFunctions.getCategoryList());
        int categoryId;
        do {
            System.out.println("Choose id: ");
            categoryId = userInput.getIntegerNumberFromUser();
            if (!categoryFunctions.isCategoryInRepository(categoryId)) {
                System.out.println("Wrong category id chosen.");
            }
        } while (!categoryFunctions.isCategoryInRepository(categoryId));

        displayer.displayBookList(bookFunctions.getBooksBelongingToSpecifiedCategory(categoryId));
    }


    public void createNewAuthor() throws IOException, NoInputValueException {
        System.out.println("Type author's name: ");
        String authorName = userInput.getStringFromUser();
        int age;

        do {
            System.out.println("Type author's age: ");
            age = userInput.getIntegerNumberFromUser();
        } while (!inputValidator.isAgeValid(age));


        authorFunctions.addAuthor(authorName, age);
    }

    public void showAuthorsAndNumberOfPublishedBooks() {
        displayer.displayAuthorsAndNumberOfPublishedBooks(authorFunctions.getAuthorsAndNumberOfPublishedBooks());
    }

    public void chooseDisplayType() throws NoInputValueException {
        displayer.displayBooksPrintingOptions();
        System.out.println("Choose display type: ");
        int displayType = userInput.getIntegerNumberFromUser();
        if (displayType > 3 || displayType < 1) {
            System.out.println("Wrong number chosen");
            chooseDisplayType();
        } else {
            displayer.setBooksDisplayType(displayType);
        }
    }

    public void changeAuthorAge() throws NoInputValueException {
        showAuthorList();
        System.out.println("Choose author by id: ");
        int authorId = userInput.getIntegerNumberFromUser();
        int authorAge;

        if (!authorFunctions.isAuthorInRepository(authorId)) {
            System.out.println("Wrong id number chosen");
            changeAuthorAge();
        } else {
            System.out.println("Put Author Age");
            do {
                authorAge = userInput.getIntegerNumberFromUser();
            } while (!inputValidator.isAgeValid(authorAge));

            authorFunctions.setAuthorAge(authorId, authorAge);
        }
    }

    public void showAuthorWithPublishedBooks() throws NoInputValueException {
        showAuthorList();
        System.out.println("Choose author by id: ");
        int authorId = userInput.getIntegerNumberFromUser();

        if (!authorFunctions.isAuthorInRepository(authorId)) {
            System.out.println("Wrong id number chosen");
            showAuthorWithPublishedBooks();
        } else {
            displayer.displayAuthorName(authorFunctions.getAuthorNameById(authorId));
            displayer.displayBookList(bookFunctions.getAllBooksPublishedBySpecifiedAuthor(authorId));
        }
    }

    public void createNewCategory() throws IOException, NoInputValueException {
        System.out.println("Type category name: ");
        String categoryName = userInput.getStringFromUser();

        System.out.println("Set category priority(1 - 3): ");
        int priorityNumber;
        do {
            priorityNumber = userInput.getIntegerNumberFromUser();
        } while (!inputValidator.isPriorityValid(priorityNumber));

        categoryFunctions.addNewCategory(categoryName, priorityNumber);
    }


    public void createNewBook() throws IOException, NoInputValueException {
        String title = bookCreator.addBookTitle();
        String isbnNumber = bookCreator.addIsbnNumber();
        int publicationYear = bookCreator.addPublicationYear();
        String coverType = bookCreator.addCoverType(displayer, bookFunctions);
        List<Author> authorList = bookCreator.addBookAuthors(this, displayer, authorFunctions);
        Category category = bookCreator.addCategory(categoryFunctions);

        bookFunctions.addBook(title, isbnNumber, publicationYear, coverType, authorList, category);

    }

    public void addEmployee() throws IOException, NoInputValueException {
        employeeFunctions.addNewEmployee();
    }


    public void showEmployeeList() {
        displayer.displayEmployeeList(employeeFunctions.getEmployeeList());
    }

    public void setStudentWorkingHours() throws NoInputValueException {
        List<Employee> studentList = employeeFunctions.getStudentList();
        displayer.displayStudentsList(studentList);
        int studentId;
        double workingHours;
        do {
            System.out.println("Choose students id: ");
            studentId = userInput.getIntegerNumberFromUser();
            if (!employeeFunctions.isStudentInRepository(studentId)) {
                System.out.println("Wrong id number chosen");
            }
        } while (!employeeFunctions.isStudentInRepository(studentId));

        do {
            System.out.println("Set working hours: ");
            workingHours = userInput.getDoubleNumberFromUser();
        } while (!inputValidator.areWorkingHoursValid(workingHours));
        employeeFunctions.setStudentsWorkingHours(studentId, workingHours);
    }
}