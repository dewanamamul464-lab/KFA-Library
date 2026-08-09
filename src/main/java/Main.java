import kfa.exception.BookNotAvailableException;
import kfa.exception.ItemOverdueException;
import kfa.model.Book;
import kfa.model.DVD;
import kfa.model.LibraryItem;
import kfa.model.Magazine;
import kfa.service.LibrarySystem;

public class Main {

    public static void main(String[] args) {

        // ============================================================
        // SECTION A - JAVA & OOP FOUNDATIONS
        // ============================================================

        System.out.println("========================================");
        System.out.println("       KFA LIBRARY - SECTION A");
        System.out.println("========================================");

        Book book1 = new Book(
                "Clean Code",
                "Robert Martin",
                "B001",
                850
        );

        Book book2 = new Book(
                "Effective Java",
                "Joshua Bloch",
                "B002",
                1200
        );

        Book book3 = new Book(
                "Java Basics",
                "Herbert Schildt",
                "B003",
                950
        );

        Book book4 = new Book(
                "Head First Java",
                "Kathy Sierra",
                "B004",
                1100
        );

        Book[] books = {
                book1,
                book2,
                book3,
                book4
        };

        System.out.println();
        System.out.println("=== BOOK CATALOGUE ===");

        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println("Total books: " + Book.getTotalBooks());


        // ============================================================
        // SECTION B - INHERITANCE & INTERFACES
        // ============================================================

        System.out.println();
        System.out.println("========================================");
        System.out.println("       KFA LIBRARY - SECTION B");
        System.out.println("========================================");

        LibraryItem[] items = {

                new Book(
                        "Clean Code",
                        "Robert Martin",
                        "B001",
                        850
                ),

                new Magazine(
                        "Java Monthly",
                        "M001",
                        500,
                        25
                ),

                new DVD(
                        "Java Programming Tutorial",
                        "D001",
                        700,
                        120
                )
        };

        System.out.println();
        System.out.println("=== POLYMORPHIC LIBRARY ITEMS ===");

        for (LibraryItem item : items) {

            System.out.println(item);

            System.out.println(
                    "Lending period: "
                            + item.getLendingPeriodDays()
                            + " days"
            );

            System.out.println();
        }

        System.out.println(
                "Polymorphism works because LibraryItem is the "
                        + "common parent type and Java dynamically selects "
                        + "the overridden method of each actual object."
        );


        // ============================================================
        // SECTION C - EXCEPTION HANDLING & PACKAGES
        // ============================================================

        System.out.println();
        System.out.println("========================================");
        System.out.println("       KFA LIBRARY - SECTION C");
        System.out.println("========================================");

        LibrarySystem librarySystem = new LibrarySystem();

        LibraryItem cBook = new Book(
                "Clean Code",
                "Robert Martin",
                "B001",
                850
        );

        // Test 1: Successful borrow
        System.out.println();
        System.out.println("=== TEST 1: SUCCESSFUL BORROW ===");

        try {

            librarySystem.borrowItem(cBook);

        } catch (BookNotAvailableException e) {

            System.out.println(
                    "Borrow failed: " + e.getMessage()
            );

        } finally {

            System.out.println(
                    "Transaction processed for: "
                            + cBook.getTitle()
            );
        }

        // Test 2: Book not available
        System.out.println();
        System.out.println("=== TEST 2: BOOK NOT AVAILABLE ===");

        try {

            librarySystem.borrowItem(cBook);

        } catch (BookNotAvailableException e) {

            System.out.println(
                    "Borrow failed: " + e.getMessage()
            );

        } finally {

            System.out.println(
                    "Transaction processed for: "
                            + cBook.getTitle()
            );
        }

        // Test 3: Successful return
        System.out.println();
        System.out.println("=== TEST 3: SUCCESSFUL RETURN ===");

        try {

            librarySystem.returnItem(cBook, 0);

        } catch (ItemOverdueException e) {

            System.out.println(
                    "Return failed: " + e.getMessage()
            );

        } finally {

            System.out.println(
                    "Transaction processed for: "
                            + cBook.getTitle()
            );
        }

        // Test 4: Item overdue
        System.out.println();
        System.out.println("=== TEST 4: ITEM OVERDUE ===");

        try {

            librarySystem.returnItem(cBook, 5);

        } catch (ItemOverdueException e) {

            System.out.println(
                    "Return failed: " + e.getMessage()
            );

            System.out.println(
                    "Days overdue: "
                            + e.getDaysOverdue()
            );

        } finally {

            System.out.println(
                    "Transaction processed for: "
                            + cBook.getTitle()
            );
        }

        System.out.println();
        System.out.println("=== FINAL BOOK STATUS ===");

        System.out.println(cBook);

        System.out.println(
                "Available: " + cBook.isAvailable()
        );


        // ============================================================
        // SECTION D - STRINGS
        // ============================================================

        System.out.println();
        System.out.println("========================================");
        System.out.println("       KFA LIBRARY - SECTION D");
        System.out.println("========================================");


        // ============================================================
        // D1 - MEMBER ID GENERATOR
        // ============================================================

        System.out.println();
        System.out.println("=== D1: MEMBER ID GENERATOR ===");

        System.out.println(
                "Aarav Shrestha -> "
                        + generateMemberId("Aarav Shrestha")
        );

        System.out.println(
                "Amamul Khan -> "
                        + generateMemberId("Amamul Khan")
        );

        System.out.println(
                "Aarav -> "
                        + generateMemberId("Aarav")
        );


        // ============================================================
        // D2 - ISBN SANITY CHECK
        // ============================================================

        System.out.println();
        System.out.println("=== D2: ISBN SANITY CHECK ===");

        String[] isbnTests = {
                "9780306406157",
                "1234567890123",
                "978030640615",
                "0780306406157",
                "97803064061A7"
        };

        for (String isbn : isbnTests) {

            System.out.println(
                    isbn + " -> " + isValidIsbn(isbn)
            );
        }


        // ============================================================
        // D3 - CATALOGUE REPORT
        // ============================================================

        System.out.println();
        System.out.println("=== D3: CATALOGUE REPORT ===");

        LibraryItem[] catalogue = {

                new Book(
                        "Clean Code",
                        "Robert Martin",
                        "B001",
                        850
                ),

                new Book(
                        "Effective Java",
                        "Joshua Bloch",
                        "B002",
                        1200
                ),

                new Magazine(
                        "Java Monthly",
                        "M001",
                        500,
                        25
                ),

                new DVD(
                        "Java Programming Tutorial",
                        "D001",
                        700,
                        120
                )
        };

        System.out.println(
                buildCatalogueReport(catalogue)
        );

        System.out.println();
        System.out.println(
                buildCatalogueReport(
                        catalogue,
                        "java"
                )
        );

        System.out.println();
        System.out.println("========================================");
        System.out.println("       ALL SECTIONS COMPLETED");
        System.out.println("========================================");
    }


    // ================================================================
    // D1 - MEMBER ID GENERATOR
    // ================================================================

    public static String generateMemberId(String fullName) {

        fullName = fullName.trim();

        String[] parts = fullName.split(" ");

        String firstName = parts[0];

        String lastName;

        if (parts.length > 1) {

            lastName = parts[parts.length - 1];

        } else {

            // Single-word name: use XX because there is no last name.
            lastName = "XX";
        }

        String firstPart;

        if (firstName.length() >= 3) {

            firstPart = firstName.substring(0, 3);

        } else {

            firstPart = firstName;
        }

        String lastPart;

        if (lastName.length() >= 2) {

            lastPart = lastName.substring(0, 2);

        } else {

            lastPart = lastName;
        }

        firstPart = firstPart.toUpperCase();
        lastPart = lastPart.toUpperCase();

        int randomNumber =
                100 + (int) (Math.random() * 900);

        return firstPart + lastPart + randomNumber;
    }


    // ================================================================
    // D2 - ISBN SANITY CHECK
    // ================================================================

    public static boolean isValidIsbn(String isbn) {

        isbn = isbn.trim();

        // ISBN must contain exactly 13 characters.
        if (isbn.length() != 13) {
            return false;
        }

        // ISBN must not start with zero.
        if (isbn.charAt(0) == '0') {
            return false;
        }

        // Every character must be a digit.
        for (int i = 0; i < isbn.length(); i++) {

            if (!Character.isDigit(isbn.charAt(i))) {
                return false;
            }
        }

        return true;
    }


    // ================================================================
    // D3 - CATALOGUE REPORT
    // ================================================================

    public static String buildCatalogueReport(
            LibraryItem[] items) {

        StringBuilder report = new StringBuilder();

        report.append("========================================\n");
        report.append("          KFA LIBRARY CATALOGUE\n");
        report.append("========================================\n");

        for (LibraryItem item : items) {

            report.append("Title: ");
            report.append(item.getTitle());
            report.append("\n");

            report.append("Availability: ");
            report.append(
                    item.isAvailable()
                            ? "Available"
                            : "Not Available"
            );
            report.append("\n");

            report.append("----------------------------------------\n");
        }

        report.append(
                "StringBuilder is preferred because String objects "
                        + "are immutable, so repeated += operations create "
                        + "new String objects. StringBuilder modifies the "
                        + "same mutable object while building the report."
        );

        return report.toString();
    }


    // ================================================================
    // D3 - CATALOGUE SEARCH
    // ================================================================

    public static String buildCatalogueReport(
            LibraryItem[] items,
            String keyword) {

        StringBuilder report = new StringBuilder();

        String searchKeyword =
                keyword.trim().toLowerCase();

        report.append("========================================\n");
        report.append("       SEARCH RESULTS FOR: ");
        report.append(keyword);
        report.append("\n");
        report.append("========================================\n");

        for (LibraryItem item : items) {

            String title =
                    item.getTitle();

            if (title.toLowerCase().contains(searchKeyword)) {

                report.append("Title: ");
                report.append(title);
                report.append("\n");

                report.append("Availability: ");
                report.append(
                        item.isAvailable()
                                ? "Available"
                                : "Not Available"
                );
                report.append("\n");

                report.append("----------------------------------------\n");
            }
        }

        return report.toString();
    }
}