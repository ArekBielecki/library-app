package pl.sda.libraryapp;

import java.io.IOException;
import java.util.*;

public class AppMenu {
    private static Displayer displayer;
    private static ActionHandler actionHandler;

    private static boolean shouldProgramRun = true;
    private static Scanner input;

    public static void main(String[] args){

        displayer = new Displayer();

        try {
            RepositoryInitializer.initialize();
        } catch (IOException e) {
            displayer.displayIOExceptionMessage();
            return;
        }

        actionHandler = new ActionHandler();

        input = new Scanner(System.in);
        while (shouldProgramRun) {
            displayer.displayMenu();
            int choice = Integer.parseInt(input.nextLine());
            menuTree(choice);
        }
    }

    private static void menuTree(int choiceNumber) {
        switch (choiceNumber) {
            case 1:
                try {
                    actionHandler.saveRepositoryFilesAndCloseApp();
                    shouldProgramRun = false;

                } catch (IOException e) {
                    displayer.displayIOExceptionMessage();
                    shouldProgramRun = false;
                }
                break;
            case 2:
                System.out.println("Contact email: email@email.com\n");
                break;
            case 3:
                actionHandler.showBookList();
                break;
            case 4:
                actionHandler.showAuthorList();
                break;
            case 5:
                actionHandler.showCategoryList();
                break;
            case 6:
                actionHandler.showBooksSortedAscendingByPublicationYear();
                break;
            case 7:
                actionHandler.showBooksSortedDescendingByPublicationYear();
                break;
            case 8:
                try {
                    actionHandler.showBooksPublishedAfterSpecifiedYear();
                } catch (NoInputValueException e) {
                }
                break;
            case 9:
                try {
                    actionHandler.showBooksWhichBelongToGivenCategory();
                } catch (NoInputValueException e) {
                }
                break;
            case 10:
                try {
                    actionHandler.createNewAuthor();

                } catch (NoInputValueException e) {
                } catch (IOException e) {
                    displayer.displayIOExceptionMessage();
                    shouldProgramRun = false;
                }
                break;
            case 11:
                actionHandler.showAuthorsAndNumberOfPublishedBooks();
                break;
            case 12:
                try {
                    actionHandler.chooseDisplayType();
                } catch (NoInputValueException e) {
                }
                break;
            case 13:
                try {
                    actionHandler.changeAuthorAge();
                } catch (NoInputValueException e) {
                }
                break;
            case 14:
                try {
                    actionHandler.showAuthorWithPublishedBooks();
                } catch (NoInputValueException e) {
                }
                break;
            case 15:
                try {
                    actionHandler.createNewCategory();
                } catch (NoInputValueException e) {
                } catch (IOException e) {
                    displayer.displayIOExceptionMessage();
                    shouldProgramRun = false;
                }
                break;
            case 16:
                try {
                    actionHandler.createNewBook();
                } catch (NoInputValueException e) {
                } catch (IOException e) {
                    displayer.displayIOExceptionMessage();
                    shouldProgramRun = false;
                }
                break;
            case 17:
                try {
                    actionHandler.addEmployee();
                } catch (NoInputValueException e) {
                } catch (IOException e) {
                    displayer.displayIOExceptionMessage();
                    shouldProgramRun = false;
                }
                break;
            case 18:
                actionHandler.showEmployeeList();
                break;
            case 19:
                try {
                    actionHandler.setStudentWorkingHours();
                } catch (NoInputValueException e) {
                }
                break;
            default:
                System.out.println("Wrong command\n");
                break;
        }
    }
}
