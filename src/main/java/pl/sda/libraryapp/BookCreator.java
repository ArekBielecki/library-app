package pl.sda.libraryapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookCreator {
    private UserInput userInput = new UserInput();
    private InputValidator inputValidator = new InputValidator();

    public String addBookTitle() throws NoInputValueException {
        System.out.println("Book title: ");
        if (!shouldSkipValueInput()) {
            System.out.println("Type book title: ");
            return userInput.getStringFromUser();
        } else {
            return userInput.getDefaultStringValue();
        }

    }

    public String addIsbnNumber() throws NoInputValueException {
        System.out.println("ISBN number: ");
        String isbnNumber = null;

        if (!shouldSkipValueInput()) {
            do {
                System.out.println("Type ISBN number: ");
                isbnNumber = userInput.getStringFromUser();
            }
            while (!inputValidator.isIsbnValid(isbnNumber));
        } else {
            return userInput.getDefaultStringValue();
        }
        return isbnNumber;
    }

    public int addPublicationYear() throws NoInputValueException {
        System.out.println("Publication year: ");
        int year;
        if (!shouldSkipValueInput()) {
            do {
                System.out.println("Type publication year: ");
                year = userInput.getIntegerNumberFromUser();
            }
            while (!inputValidator.isPublicationYearValid(year));
        } else {
            return userInput.getDefaultIntegerValue();
        }

        return year;
    }

    public String addCoverType(Displayer displayer, BookFunctions bookFunctions) throws NoInputValueException {
        System.out.println("Cover type: ");
        int coverTypeNumber;
        String coverType = null;
        if (!shouldSkipValueInput()) {
            do {
                System.out.println("Choose cover type: ");
                displayer.displayCoverTypes();
                coverTypeNumber = userInput.getIntegerNumberFromUser();

                if (!inputValidator.isCoverTypeValid(coverTypeNumber)) {
                    System.out.println("Wrong number chosen");
                }
            }
            while (!inputValidator.isCoverTypeValid(coverTypeNumber));

            if (coverTypeNumber == 1) {
                return bookFunctions.getCoverType(1);
            } else if (coverTypeNumber == 2) {
                return bookFunctions.getCoverType(2);
            } else{
                return userInput.getDefaultStringValue();
            }
        } else {
            return userInput.getDefaultStringValue();
        }
    }

    public List<Author> addBookAuthors(ActionHandler actionHandler, Displayer displayer, AuthorFunctions authorFunctions)
            throws IOException, NoInputValueException {
        List<Author> authors = new ArrayList<>();
        boolean shouldLoopRun = true;

        while (shouldLoopRun) {
            System.out.println("Add author: ");
            System.out.println("1. Choose from list ");
            System.out.println("2. Add new Author ");
            System.out.println("3. Done");
            int choiceNumber = userInput.getIntegerNumberFromUser();
            switch (choiceNumber) {
                case 1:
                    displayer.displayAuthorList(authorFunctions.getAuthorList());
                    System.out.println("Choose author id: ");
                    int authorId = userInput.getIntegerNumberFromUser();
                    if (!authorFunctions.isAuthorInRepository(authorId)) {
                        System.out.println("Wrong author id");
                    } else if (isAuthorAlreadyOnTheList(authors, authorId)) {
                        System.out.println("Author already on the list");

                    } else {
                        authors.add(authorFunctions.getAuthorById(authorId));
                    }
                    break;
                case 2:
                    actionHandler.createNewAuthor();
                    authors.add(authorFunctions.getAuthorList().get(authorFunctions.getAuthorList().size() - 1));
                    break;
                case 3:
                    shouldLoopRun = false;
                    break;
                default:
                    System.out.println("Wrong command!\n");
                    break;
            }
        }
        return authors;
    }

    public Category addCategory(CategoryFunctions categoryFunctions) throws NoInputValueException {
        System.out.println("Category: ");
        Category category = null;
        int categoryId;
        if (!shouldSkipValueInput()) {
            do {
                System.out.println("Choose category id: ");
                categoryId = userInput.getIntegerNumberFromUser();

                if (categoryFunctions.isCategoryInRepository(categoryId)) {
                    return categoryFunctions.getCategoryById(categoryId);
                } else {
                    System.out.println("Wrong category number.");
                }
            } while (!categoryFunctions.isCategoryInRepository(categoryId));
        }
        return category;
    }

    private boolean isAuthorAlreadyOnTheList(List<Author> authors, int authorId) {
        return authors.stream().anyMatch(x -> x.getId() == authorId);

    }

    private boolean shouldSkipValueInput() throws NoInputValueException {
        System.out.println("1. Enter value");
        System.out.println("2. Skip");
        int choiceNumber = userInput.getIntegerNumberFromUser();
        switch (choiceNumber) {
            case 1:
                return false;
            case 2:
                return true;
            default:
                return false;
        }
    }
}

