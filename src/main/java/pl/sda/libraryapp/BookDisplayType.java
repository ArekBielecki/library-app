package pl.sda.libraryapp;

public class BookDisplayType {

    public static BooksPrintStrategy set(int number) {
        switch (number) {
            case 1:
                return new YearTitleIsbnPrintStrategy();
            case 2:
                return new TitleYearIsbnPrintStrategy();
            case 3:
                return new IsbnTitleYearPrintStrategy();
            default:
                return new TitleYearIsbnPrintStrategy();
        }
    }
}
