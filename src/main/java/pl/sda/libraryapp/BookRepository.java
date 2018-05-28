package pl.sda.libraryapp;

import java.io.IOException;
import java.util.List;

public class BookRepository {
    private static BookRepository bookRepository = null;
    private static List<Book> bookList;

    private BookRepository(){};

    public static BookRepository getInstance() throws IOException {

        if(bookRepository == null){
            ImportFile importFile = new ImportFile(RepositoryConfig.BOOKS_REPO_PATH_NAME);
            bookList = importFile.parseInputFileAsBookList();
            return bookRepository = new BookRepository();
        }
        return bookRepository;
    }

    public List<Book> getBookList(){
        return bookList;
    }

    public void addBook(String title, String isbnNumber, int year, String coverType, List<Author> authors, Category category){
        bookList.add(Book.BookBuilder.builder()
                .title(title)
                .isbnNumber(isbnNumber)
                .year(year)
                .coverType(coverType)
                .authors(authors)
                .category(category)
                .build()
        );
    }

}
