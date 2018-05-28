package pl.sda.libraryapp;

import java.util.List;

public class IsbnTitleYearPrintStrategy implements BooksPrintStrategy{
    @Override
    public void print(List<Book> bookList) {
        bookList.stream().forEach(x -> System.out.println("ISBN number: " + x.getIsbnNumber() + ", Title" + x.getTitle() +
                ", Publication year: " + x.getYear()));
    }
}
