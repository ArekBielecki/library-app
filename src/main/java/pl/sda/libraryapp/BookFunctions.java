package pl.sda.libraryapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookFunctions {
    private BookRepository bookRepository;
    private RepositorySaver repositorySaver;
    private AuthorFunctions authorFunctions;
    private List<Book> bookList;

    public BookFunctions(BookRepository bookRepository, RepositorySaver repositorySaver, AuthorFunctions authorFunctions) {
        this.bookRepository = bookRepository;
        this.repositorySaver = repositorySaver;
        this.authorFunctions = authorFunctions;

        bookList = bookRepository.getBookList();
    }

    public void addBook(String title, String isbnNumber, int year, String coverType, List<Author> authors, Category category)
            throws IOException {
        bookRepository.addBook(title, isbnNumber, year, coverType, authors, category);
        repositorySaver.addBookToRepositoryFile(getBookList());
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Book> getAllBooksPublishedBySpecifiedAuthor(int authorId) {
        List<Book> listOfBooks = new ArrayList<>();
        if (authorFunctions.isAuthorInRepository(authorId)) {
            for (Book book : bookList) {
                for (Author author : book.getAuthors()) {
                    if (author.getId() == authorId) {
                        listOfBooks.add(book);
                    }
                }
            }
        }
        return listOfBooks;
    }

    public List<Book> getBooksPublishedAfterSpecifiedYear(int year) {
        return bookList
                .stream()
                .filter(x -> x.getYear() > year)
                .collect(Collectors.toList());
    }

    public List<Book> getBooksBelongingToSpecifiedCategory(int categoryId) {
        return bookList
                .stream()
                .filter(x -> x.getCategory().getId() == categoryId)
                .collect(Collectors.toList());
    }

    public String getCoverType(int choiceNumber) {
        switch(choiceNumber){
            case 1:
                return CoverType.SOFT.getBookCoverType();
            case 2:
                return CoverType.HARD.getBookCoverType();
            default:
                throw new NullPointerException();

        }
    }

    public List<Book> sortBooksAscendingByPublicationYear() {
        return bookList.stream().sorted(Comparator.comparing(Book::getYear)).collect(Collectors.toList());
    }

    public List<Book> sortBooksDescendingByPublicationYear() {
        return bookList.stream().sorted(Comparator.comparing(Book::getYear, Comparator.reverseOrder())).collect(Collectors.toList());
    }
}
