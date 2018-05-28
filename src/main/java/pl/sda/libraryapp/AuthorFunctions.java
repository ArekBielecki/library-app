package pl.sda.libraryapp;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AuthorFunctions {

    private AuthorRepository authorRepository;
    private RepositorySaver repositorySaver;
    private List<Author> authorList;
    private List<Book> bookList;

    public AuthorFunctions(AuthorRepository authorRepository, BookRepository bookRepository, RepositorySaver repositorySaver) {
        this.authorRepository = authorRepository;
        this.repositorySaver = repositorySaver;

        authorList = authorRepository.getAuthorList();
        bookList = bookRepository.getBookList();

    }

    public void addAuthor(String name, int age) throws IOException {
        authorRepository.addAuthor(name, age);
        repositorySaver.addAuthorToRepositoryFile(getAuthorList());
    }


    public List<Author> getAuthorList() {
        return authorList;
    }

    public boolean isAuthorInRepository(int authorId) {
        return authorList.stream()
                .anyMatch(x -> x.getId() == authorId);
    }

    public Map<String, Integer> getAuthorsAndNumberOfPublishedBooks() {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Author author : authorList) {
            map.put(author.getName(), 0);
        }
        for (Book book : bookList) {
            for (Author author : book.getAuthors())
                map.put(author.getName(), map.get(author.getName()) + 1);
        }
        return map;
    }

    public String getAuthorNameById(int authorId) {
        if (isAuthorInRepository(authorId)) {
            return authorList
                    .stream()
                    .filter(x -> x.getId() == authorId)
                    .map(x -> x.getName())
                    .findFirst().get();
        } else throw new NullPointerException();
    }

    public Author getAuthorById(int authorId){
        if (isAuthorInRepository(authorId)) {
            return authorList
                    .stream()
                    .filter(x -> x.getId() == authorId)
                    .findFirst().get();
        } else throw new NullPointerException();
    }

    public void setAuthorAge(int id, int age) {
        Author author = authorList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (author != null) {
            author.setAge(age);
        } else System.out.println("There is no author for given id!");
    }
}
