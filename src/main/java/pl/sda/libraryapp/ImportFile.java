package pl.sda.libraryapp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ImportFile {
    private BufferedReader reader;
    private InputStream inputStream;

    public ImportFile(String pathName) throws FileNotFoundException {
        inputStream = new FileInputStream(new File(pathName));
        //inputStream = ClassLoader.getSystemResourceAsStream(pathName);
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public List<Book> parseInputFileAsBookList() throws IOException {
        String line;
        List<Book> bookList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] array = line.split(";");
            String title = array[0];
            String isbnNumber = array[1];
            int publicationYear = Integer.parseInt(array[2]);
            String coverType = CoverType.getCoverTypeFromCoverTypeSymbol(array[3]);
            List<Author> authorList = generateListOfAuthors(AuthorRepository.getInstance(), array[4]);
            Category category = getCategoryByNumber(CategoryRepository.getInstance(), Integer.parseInt(array[5]));

            bookList.add(new Book(title, isbnNumber, publicationYear, coverType, authorList, category));
        }
        return bookList;
    }

    public List<Author> parseInputFileAsAuthorList() throws IOException {
        String line;
        List<Author> authorList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] array = line.split(";");
            int id = Integer.parseInt(array[0]);
            String name = array[1];
            int age = Integer.parseInt(array[2]);

            authorList.add(new Author(id, name, age));
        }
        return authorList;
    }

    public List<Category> parseInputFileAsCategoryList() throws IOException {
        String line;
        List<Category> categoryList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] array = line.split(";");
            int id = Integer.parseInt(array[0]);
            String name = array[1];
            int priority = Integer.parseInt(array[2]);

            categoryList.add(new Category(id, name, priority));
        }
        return categoryList;
    }

    public List<Employee> parseInputFileAsEmployeeList() throws IOException {
        String line;
        List<Employee> employeeList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] array = line.split(";");
            int id = Integer.parseInt(array[0]);
            String name = array[1];
            String surname = array[2];
            String workPosition = array[3];
            double wagePerHour = Double.parseDouble(array[4]);
            double monthSalary = Double.parseDouble(array[5]);
            String telephoneNumber = array[6];
            double workingHours = Double.parseDouble(array[7]);

            employeeList.add(createEmployeeBasedOnWorkPost(id, name, surname, workPosition, wagePerHour, monthSalary,
                    telephoneNumber, workingHours));
        }
        return employeeList;
    }

    private List<Integer> generateListOfAuthorsIds(String authorsIds) {
        if (authorsIds.isEmpty()) {
            return Collections.emptyList();
        }
        String[] arrayOfAuthorsIds = authorsIds.split(",");
        return Arrays.asList(arrayOfAuthorsIds).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
    }

    private List<Author> generateListOfAuthors(AuthorRepository authorRepository, String authorsIds) {
        List<Author> listOfBookAuthors = new ArrayList<>();
        List<Author> listOfAllAuthorsInRepository = authorRepository.getAuthorList();
        List<Integer> listOfAuthorsIds = generateListOfAuthorsIds(authorsIds);
        if (listOfAuthorsIds.isEmpty()) {
            return Collections.emptyList();
        }
        for (Author author : listOfAllAuthorsInRepository) {
            for (Integer authorId : listOfAuthorsIds) {
                if (author.getId() == authorId) {
                    listOfBookAuthors.add(author);
                }
            }
        }
        return listOfBookAuthors;
    }

    private Category getCategoryByNumber(CategoryRepository categoryRepository, int categoryNumber) {
        for (Category category : categoryRepository.getCategoryList()) {
            if (category.getId() == categoryNumber) {
                return category;
            }
        }
        return null;
    }

    private Employee createEmployeeBasedOnWorkPost(int id, String name, String surname, String workPosition, double wagePerHour,
                                                   double monthSalary, String telephoneNumber, double workingHours) {

        switch (workPosition) {
            case "Manager":
                return new Manager(id, name, surname, telephoneNumber, wagePerHour, workingHours);
            case "Salesman":
                return new Salesman(id, name, surname, monthSalary, workingHours);
            case "Student":
                return new Student(id, name, surname, wagePerHour, workingHours);
            default:
                return null;
        }
    }
}
