package pl.sda.libraryapp;

import java.util.List;

public class Book {

    private String title;
    private String isbnNumber;
    private int year;
    private String coverType;
    private List<Author> authors;
    private Category category;

    public Book(String title, String isbnNumber, int year, String coverType, List<Author> authors, Category category) {
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.year = year;
        this.coverType = coverType;
        this.authors = authors;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getCoverType() {
        return coverType;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Category getCategory() {
        return category;
    }

    private String getAuthorsNames() {
        return authors.stream().map(x -> x.getName()).reduce((x, y) -> x + ", " + y).get();
    }

    private String getCategoryName() {
        return category.getName();
    }

    public static class BookBuilder {

        private String title;
        private String isbnNumber;
        private int year;
        private String coverType;
        private List<Author> authors;
        private Category category;

        public static BookBuilder builder() {
            return new BookBuilder();
        }

        public BookBuilder title(String title){
            this.title = title;
            return this;
        }

        public BookBuilder isbnNumber(String isbnNumber){
            this.isbnNumber = isbnNumber;
            return this;
        }

        public BookBuilder year(int year){
            this.year = year;
            return this;
        }

        public BookBuilder coverType(String coverType){
            this.coverType = coverType;
            return this;
        }

        public BookBuilder authors(List<Author> authors){
            this.authors = authors;
            return this;
        }

        public BookBuilder category(Category category){
            this.category = category;
            return this;
        }

        public Book build(){
            return new Book(title, isbnNumber, year, coverType, authors, category);
        }
    }


    @Override
    public String toString() {
        return "Book title: " + getTitle() + ", ISBN number: " + getIsbnNumber()
                + ", Publication year: " + getYear() + "\n" + "Book cover type: " + getCoverType() + ", Authors: " + getAuthorsNames() +
                ", Category: " + getCategoryName() + "\n";
    }

}