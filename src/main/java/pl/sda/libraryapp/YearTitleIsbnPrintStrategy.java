package pl.sda.libraryapp;

import java.util.List;

public class YearTitleIsbnPrintStrategy implements BooksPrintStrategy{
    @Override
    public void print(List<Book> bookList) {
        bookList.stream().forEach(x -> System.out.println("Publication year: " + x.getYear() + ", Title" + x.getTitle() +
                ", ISBN number: " + x.getIsbnNumber()));
    }
}
