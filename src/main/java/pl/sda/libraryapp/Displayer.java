package pl.sda.libraryapp;

import java.util.List;
import java.util.Map;

public class Displayer {
    private BooksPrintStrategy bookPrinter  = new TitleYearIsbnPrintStrategy();

    public void displayBooksPrintingOptions(){
        System.out.println("1. Year, Title, ISBN number");
        System.out.println("2. Title, Year, ISBN number");
        System.out.println("3. ISBN number, Title, Year");
    }

    public void setBooksDisplayType(int choiceNumber){
        bookPrinter = BookDisplayType.set(choiceNumber);
    }

    public void displayMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Close app");
        System.out.println("2. Display email");
        System.out.println("3. Display list of books");
        System.out.println("4. Display list of authors");
        System.out.println("5. Display category list");
        System.out.println("6. Display book list sorted asc. by publication year");
        System.out.println("7. Display book list sorted desc. by publication year");
        System.out.println("8. Display books published after specified year");
        System.out.println("9. Display books belonging to specified category");
        System.out.println("10. Add author to repository");
        System.out.println("11. Display authors and number of published books");
        System.out.println("12. Set display type");
        System.out.println("13. Modify author's age");
        System.out.println("14. Print books by author");
        System.out.println("15. Add new category");
        System.out.println("16. Add book to repository");
        System.out.println("17. Add employee");
        System.out.println("18. Display list of employees");
        System.out.println("19. Set student's working hours");
    }

    public void displayBookList(List<Book> bookList) {
        System.out.println("List of books:");
        bookPrinter.print(bookList);
        System.out.println();
    }

    public void displayAuthorList(List<Author> authorList) {
        System.out.println("List of authors:");
        authorList.forEach(System.out::println);
        System.out.println("");
    }

    public void displayCategoryList(List<Category> categoryList) {
        System.out.println("Category list: ");
        categoryList.forEach(x -> System.out.println("Category id: " + x.getId() + ", Category name: " + x.getName()));
        System.out.println("");
    }

    public void displayAuthorsAndNumberOfPublishedBooks(Map<String, Integer> authorsAndNumberOfPublishedBooks){
        authorsAndNumberOfPublishedBooks
                .entrySet()
                .stream()
                .forEach(x -> System.out.println("Author: " + x.getKey() + ", no. of publications: " + x.getValue()));
        System.out.println("");
    }

    public void displayAuthorName(String author){
        System.out.println("Author name: ");
        System.out.println(author);
        System.out.println("");
    }

    public void displayCoverTypes(){
        System.out.println("Cover types: ");
        System.out.println("1. Soft cover ");
        System.out.println("2. Hard cover ");
    }

    public void displayIOExceptionMessage(){
        System.out.println("Error with reading/writing data");
        System.out.println("Closing app...");
    }

    public void displayWorkPosts() {
        System.out.println("Choose work position: ");
        System.out.println("1. Manager ");
        System.out.println("2. Salesman ");
        System.out.println("3. Student ");
    }

    public void displayEmployeeList(List<Employee> employeeList) {
        System.out.println("Employee list: ");
        employeeList.forEach(System.out::println);
        System.out.println("");
    }

    public void displayStudentsList(List<Employee> studentList) {
        System.out.println("Student list: ");
        studentList.forEach(System.out::println);
        System.out.println("");
    }
}

