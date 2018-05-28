package pl.sda.libraryapp;

import java.util.List;

public class TitleYearIsbnPrintStrategy implements BooksPrintStrategy {
    @Override
    public void print(List<Book> bookList) {
        bookList.stream().forEach(x -> System.out.println("Title: " + x.getTitle() + ", Publication year: " + x.getYear() +
                ", ISBN number: " + x.getIsbnNumber()));
    }
}
