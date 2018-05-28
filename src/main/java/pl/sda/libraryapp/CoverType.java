package pl.sda.libraryapp;

public enum CoverType {
    SOFT("Soft Cover", "M"),
    HARD("Hard Cover", "T");

    private final String bookCoverType;
    private final String coverTypeSymbol;


    CoverType(String bookCoverType, String coverTypeSymbol) {
        this.bookCoverType = bookCoverType;
        this.coverTypeSymbol = coverTypeSymbol;
    }

    public String getBookCoverType() {
        return bookCoverType;
    }

    public static String getCoverTypeFromCoverTypeSymbol(String coverTypeSymbol) {
        for (CoverType cover : values()) {
            if (cover.coverTypeSymbol.equals(coverTypeSymbol)) {
                return cover.bookCoverType;
            }
        }
        return null;
    }

    public static String getCoverTypeSymbolFromCoverType(String coverType) {
        for (CoverType cover : values()) {
            if (cover.bookCoverType.equals(coverType)) {
                return cover.coverTypeSymbol;
            }
        }
        return null;
    }
}
