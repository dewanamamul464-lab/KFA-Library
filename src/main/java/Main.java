import kfa.model.Book;
import kfa.model.LibraryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        // ============================================================
        // KFA PUBLIC LIBRARY - LEVEL 2
        // SECTION A + B + C + D
        // ============================================================

        System.out.println("========================================");
        System.out.println("       KFA PUBLIC LIBRARY");
        System.out.println("       LEVEL 2 - SECTION A");
        System.out.println("========================================");


        // ============================================================
        // A1 - DATA CLEANING: sanitizeTitle()
        // ============================================================

        System.out.println();
        System.out.println("=== A1: DATA CLEANING ===");
        System.out.println();

        String[] messyTitles = {
                " the GREAT gatsby ",
                "  JAVA   programming   LANGUAGE  ",
                "hARry     pOTter and   the   sORcerer's   sTOne"
        };

        for (String title : messyTitles) {

            System.out.println("Original : \"" + title + "\"");
            System.out.println(
                    "Cleaned  : \"" + sanitizeTitle(title) + "\""
            );
            System.out.println();
        }


        // ============================================================
        // A2 - RECEIPT GENERATION
        // ============================================================

        System.out.println("=== A2: RECEIPT GENERATION ===");
        System.out.println();

        LibraryItem borrowedBook = new Book(
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                "9780743273565",
                850.00
        );

        String receipt = generateReceiptText(
                "Aarav Shrestha",
                borrowedBook
        );

        System.out.println(receipt);


        // ============================================================
        // A2 - == VS .equals()
        // ============================================================

        System.out.println("=== A2: == VS .equals() ===");
        System.out.println();

        String isbn1 = "9780743273565";
        String isbn2 = new String("9780743273565");

        System.out.println("ISBN 1: " + isbn1);
        System.out.println("ISBN 2: " + isbn2);
        System.out.println();

        System.out.println(
                "isbn1 == isbn2       : " + (isbn1 == isbn2)
        );

        System.out.println(
                "isbn1.equals(isbn2)  : " + isbn1.equals(isbn2)
        );

        System.out.println();

        System.out.println("Explanation:");

        System.out.println(
                "The == operator compares whether two String references "
                        + "refer to the same object."
        );

        System.out.println(
                "The .equals() method compares the actual characters "
                        + "contained in the Strings, so it is the correct "
                        + "choice when comparing ISBN values."
        );


        // ============================================================
        // SECTION B
        // ============================================================

        System.out.println();
        System.out.println("========================================");
        System.out.println("       KFA PUBLIC LIBRARY");
        System.out.println("       LEVEL 2 - SECTION B");
        System.out.println("========================================");


        // ============================================================
        // B1 - THE SHELF GRID
        // ============================================================

        System.out.println();
        System.out.println("=== B1: SHELF GRID ===");
        System.out.println();

        String[][] shelves = new String[5][10];

        for (int shelf = 0; shelf < shelves.length; shelf++) {

            for (int slot = 0;
                 slot < shelves[shelf].length;
                 slot++) {

                shelves[shelf][slot] = "";
            }
        }

        System.out.println("Placing books on shelves:");

        System.out.println(
                "9780743273565 -> "
                        + formatPosition(
                        placeOnShelf(
                                shelves,
                                "9780743273565"
                        )
                )
        );

        System.out.println(
                "9780132350884 -> "
                        + formatPosition(
                        placeOnShelf(
                                shelves,
                                "9780132350884"
                        )
                )
        );

        System.out.println(
                "9781617294945 -> "
                        + formatPosition(
                        placeOnShelf(
                                shelves,
                                "9781617294945"
                        )
                )
        );

        System.out.println(
                "9781491950357 -> "
                        + formatPosition(
                        placeOnShelf(
                                shelves,
                                "9781491950357"
                        )
                )
        );

        System.out.println();

        printShelves(shelves);


        // ============================================================
        // B2 - FIND MOST EXPENSIVE BOOK
        // ============================================================

        System.out.println();
        System.out.println("=== B2: MOST EXPENSIVE BOOK ===");
        System.out.println();

        Book book1 = new Book(
                "Clean Code",
                "Robert C. Martin",
                "B001",
                850.00
        );

        Book book2 = new Book(
                "Effective Java",
                "Joshua Bloch",
                "B002",
                1200.00
        );

        Book book3 = new Book(
                "Java: The Complete Reference",
                "Herbert Schildt",
                "B003",
                1500.00
        );

        Book book4 = new Book(
                "Head First Java",
                "Kathy Sierra",
                "B004",
                950.00
        );

        Book book5 = new Book(
                "Thinking in Java",
                "Bruce Eckel",
                "B005",
                1350.00
        );

        Book[] books = {
                book1,
                book2,
                book3,
                book4,
                book5
        };

        System.out.println(
                "Books before finding the most expensive:"
        );

        printBooks(books);

        System.out.println();

        Book mostExpensive =
                findMostExpensive(books);

        System.out.println("Most expensive book:");
        System.out.println(mostExpensive);


        // ============================================================
        // B2 - REVERSE IN PLACE
        // ============================================================

        System.out.println();
        System.out.println("=== B2: REVERSE ARRAY IN PLACE ===");
        System.out.println();

        System.out.println("Before reversal:");

        printBooks(books);

        reverseInPlace(books);

        System.out.println();
        System.out.println("After reversal:");

        printBooks(books);


        // ============================================================
        // SECTION C
        // ============================================================

        System.out.println();
        System.out.println("========================================");
        System.out.println("       KFA PUBLIC LIBRARY");
        System.out.println("       LEVEL 2 - SECTION C");
        System.out.println("========================================");


        // ============================================================
        // C1 - ARRAYLIST CATALOGUE
        // ============================================================

        System.out.println();
        System.out.println("=== C1: ARRAYLIST CATALOGUE ===");
        System.out.println();

        ArrayList<LibraryItem> catalogue =
                new ArrayList<>();

        ArrayList<LibraryItem> removalHistory =
                new ArrayList<>();

        addItem(
                catalogue,
                new Book(
                        "Clean Code",
                        "Robert C. Martin",
                        "C001",
                        850.00
                )
        );

        addItem(
                catalogue,
                new Book(
                        "Effective Java",
                        "Joshua Bloch",
                        "C002",
                        1200.00
                )
        );

        addItem(
                catalogue,
                new Book(
                        "Java Programming",
                        "Herbert Schildt",
                        "C003",
                        950.00
                )
        );

        addItem(
                catalogue,
                new Book(
                        "Head First Java",
                        "Kathy Sierra",
                        "C004",
                        700.00
                )
        );

        addItem(
                catalogue,
                new Book(
                        "The Great Gatsby",
                        "F. Scott Fitzgerald",
                        "C005",
                        600.00
                )
        );

        System.out.println();
        System.out.println("Catalogue after adding items:");

        printCatalogue(catalogue);


        // ============================================================
        // C1 - SEARCH BY TITLE
        // ============================================================

        System.out.println();
        System.out.println("=== C1: SEARCH BY TITLE ===");
        System.out.println();

        ArrayList<LibraryItem> searchResults =
                searchByTitle(
                        catalogue,
                        "java"
                );

        System.out.println(
                "Search results for keyword: java"
        );

        printCatalogue(searchResults);


        // ============================================================
        // C1 - REMOVE ITEM
        // ============================================================

        System.out.println();
        System.out.println("=== C1: REMOVE ITEM ===");
        System.out.println();

        boolean removed =
                removeItem(
                        catalogue,
                        removalHistory,
                        "C003"
                );

        System.out.println(
                "Remove ISBN C003: " + removed
        );

        System.out.println();
        System.out.println("Catalogue after removal:");

        printCatalogue(catalogue);


        // ============================================================
        // C2 - SORT BY PRICE
        // ============================================================

        System.out.println();
        System.out.println("=== C2: SORT BY PRICE ===");
        System.out.println();

        Collections.sort(
                catalogue,
                Comparator.comparingDouble(
                        LibraryItem::getPrice
                )
        );

        printCatalogue(catalogue);


        // ============================================================
        // C2 - SORT BY TITLE
        // ============================================================

        System.out.println();
        System.out.println("=== C2: SORT BY TITLE ===");
        System.out.println();

        Collections.sort(
                catalogue,
                Comparator.comparing(
                        LibraryItem::getTitle,
                        String.CASE_INSENSITIVE_ORDER
                )
        );

        printCatalogue(catalogue);


        // ============================================================
        // C3 - UNDO LAST REMOVAL
        // ============================================================

        System.out.println();
        System.out.println("=== C3: UNDO LAST REMOVAL ===");
        System.out.println();

        undoRemove(
                catalogue,
                removalHistory
        );

        System.out.println();
        System.out.println("Catalogue after undo:");

        printCatalogue(catalogue);

        System.out.println();
        System.out.println("Trying undo again:");

        undoRemove(
                catalogue,
                removalHistory
        );


        // ============================================================
        // SECTION D
        // ============================================================

        System.out.println();
        System.out.println("========================================");
        System.out.println("       KFA PUBLIC LIBRARY");
        System.out.println("       LEVEL 2 - SECTION D");
        System.out.println("========================================");


        // ============================================================
        // D1 - HASHSET: STOP DOUBLE-BORROW
        // ============================================================

        System.out.println();
        System.out.println("=== D1: HASHSET BORROWING ===");
        System.out.println();

        HashSet<String> currentlyBorrowed =
                new HashSet<>();

        String borrowIsbn =
                "B001";

        System.out.println(
                "First borrow of "
                        + borrowIsbn
                        + ": "
                        + borrow(
                        currentlyBorrowed,
                        borrowIsbn
                )
        );

        System.out.println(
                "Second borrow of "
                        + borrowIsbn
                        + ": "
                        + borrow(
                        currentlyBorrowed,
                        borrowIsbn
                )
        );

        System.out.println(
                "Currently borrowed: "
                        + currentlyBorrowed
        );

        System.out.println(
                "Returning "
                        + borrowIsbn
                        + ": "
                        + returnBook(
                        currentlyBorrowed,
                        borrowIsbn
                )
        );

        System.out.println(
                "Currently borrowed after return: "
                        + currentlyBorrowed
        );


        // ============================================================
        // D2 - HASHMAP: ISBN LOOKUP
        // ============================================================

        System.out.println();
        System.out.println("=== D2: HASHMAP ISBN LOOKUP ===");
        System.out.println();

        HashMap<String, Book> isbnIndex =
                new HashMap<>();

        isbnIndex.put(
                book1.getIsbn(),
                book1
        );

        isbnIndex.put(
                book2.getIsbn(),
                book2
        );

        isbnIndex.put(
                book3.getIsbn(),
                book3
        );

        isbnIndex.put(
                book4.getIsbn(),
                book4
        );

        isbnIndex.put(
                book5.getIsbn(),
                book5
        );

        String lookupIsbn = "B003";

        Book foundBook =
                findByIsbn(
                        isbnIndex,
                        lookupIsbn
                );

        System.out.println(
                "Searching for ISBN: "
                        + lookupIsbn
        );

        if (foundBook != null) {

            System.out.println(
                    "Book found:"
            );

            System.out.println(
                    foundBook
            );

        } else {

            System.out.println(
                    "No book found."
            );
        }

        System.out.println();

        System.out.println(
                "HashMap is faster for direct ISBN lookup "
                        + "because it accesses the book using its key "
                        + "instead of scanning every item in the catalogue."
        );


        // ============================================================
        // D3 - HASHMAP: MOST-BORROWED REPORT
        // ============================================================

        System.out.println();
        System.out.println(
                "=== D3: MOST-BORROWED REPORT ==="
        );
        System.out.println();

        String[] borrowLog = {
                "Clean Code",
                "Effective Java",
                "Clean Code",
                "Head First Java",
                "Effective Java",
                "Clean Code",
                "Thinking in Java",
                "Head First Java",
                "Clean Code",
                "Effective Java"
        };

        HashMap<String, Integer> borrowFrequency =
                new HashMap<>();

        for (String title : borrowLog) {

            int currentCount =
                    borrowFrequency.getOrDefault(
                            title,
                            0
                    );

            borrowFrequency.put(
                    title,
                    currentCount + 1
            );
        }

        System.out.println("Borrow frequency:");

        for (String title : borrowFrequency.keySet()) {

            System.out.println(
                    title
                            + " -> "
                            + borrowFrequency.get(title)
            );
        }

        String mostBorrowedTitle = null;
        int highestCount = 0;

        for (String title : borrowFrequency.keySet()) {

            int count =
                    borrowFrequency.get(title);

            if (count > highestCount) {

                highestCount = count;
                mostBorrowedTitle = title;
            }
        }

        System.out.println();
        System.out.println(
                "Most-borrowed title: "
                        + mostBorrowedTitle
        );

        System.out.println(
                "Borrow count: "
                        + highestCount
        );


        // ============================================================
        // END
        // ============================================================

        System.out.println();
        System.out.println("========================================");
        System.out.println("       ALL SECTIONS COMPLETED");
        System.out.println("========================================");
    }


    // ================================================================
    // A1 - sanitizeTitle()
    // ================================================================

    public static String sanitizeTitle(
            String raw) {

        String trimmed =
                raw.trim();

        String[] words =
                trimmed.split(" ");

        StringBuilder result =
                new StringBuilder();

        for (String word : words) {

            if (word.length() == 0) {
                continue;
            }

            String lowerWord =
                    word.toLowerCase();

            String titleCaseWord =
                    lowerWord.substring(0, 1)
                            .toUpperCase()
                            + lowerWord.substring(1);

            if (result.length() > 0) {
                result.append(" ");
            }

            result.append(titleCaseWord);
        }

        return result.toString();
    }


    // ================================================================
    // A2 - generateReceiptText()
    // ================================================================

    public static String generateReceiptText(
            String memberName,
            LibraryItem item) {

        StringBuilder receipt =
                new StringBuilder();

        receipt.append(
                "========================================\n"
        );

        receipt.append(
                "           KFA LIBRARY RECEIPT\n"
        );

        receipt.append(
                "========================================\n"
        );

        receipt.append("Member Name: ");
        receipt.append(memberName);
        receipt.append("\n");

        receipt.append("Item Title: ");
        receipt.append(item.getTitle());
        receipt.append("\n");

        receipt.append("ISBN: ");
        receipt.append(item.getIsbn());
        receipt.append("\n");

        receipt.append("Due Date: ");
        receipt.append("DD/MM/YYYY");
        receipt.append("\n");

        receipt.append(
                "----------------------------------------\n"
        );

        return receipt.toString();
    }


    // ================================================================
    // B1 - placeOnShelf()
    // ================================================================

    public static int[] placeOnShelf(
            String[][] shelves,
            String isbn) {

        for (int shelf = 0;
             shelf < shelves.length;
             shelf++) {

            for (int slot = 0;
                 slot < shelves[shelf].length;
                 slot++) {

                if (shelves[shelf][slot].equals("")) {

                    shelves[shelf][slot] = isbn;

                    return new int[]{
                            shelf,
                            slot
                    };
                }
            }
        }

        return new int[]{
                -1,
                -1
        };
    }


    // ================================================================
    // B1 - printShelves()
    // ================================================================

    public static void printShelves(
            String[][] shelves) {

        System.out.println(
                "=== CURRENT SHELF LAYOUT ==="
        );

        for (int shelf = 0;
             shelf < shelves.length;
             shelf++) {

            System.out.print(
                    "Shelf " + shelf + ": "
            );

            for (int slot = 0;
                 slot < shelves[shelf].length;
                 slot++) {

                String value =
                        shelves[shelf][slot];

                if (value.equals("")) {
                    value = "EMPTY";
                }

                System.out.print(
                        "[" + slot
                                + ": "
                                + value
                                + "] "
                );
            }

            System.out.println();
        }
    }


    // ================================================================
    // B1 - formatPosition()
    // ================================================================

    public static String formatPosition(
            int[] position) {

        if (position[0] == -1
                && position[1] == -1) {

            return "Shelf/Slot: (-1, -1) - Shelf is full";
        }

        return "Shelf/Slot: ("
                + position[0]
                + ", "
                + position[1]
                + ")";
    }


    // ================================================================
    // B2 - findMostExpensive()
    // ================================================================

    public static Book findMostExpensive(
            Book[] books) {

        if (books == null
                || books.length == 0) {

            return null;
        }

        Book mostExpensive =
                books[0];

        for (int i = 1;
             i < books.length;
             i++) {

            if (books[i].getPrice()
                    > mostExpensive.getPrice()) {

                mostExpensive =
                        books[i];
            }
        }

        return mostExpensive;
    }


    // ================================================================
    // B2 - reverseInPlace()
    // ================================================================

    public static void reverseInPlace(
            Book[] books) {

        int left = 0;

        int right =
                books.length - 1;

        while (left < right) {

            Book temp =
                    books[left];

            books[left] =
                    books[right];

            books[right] =
                    temp;

            left++;
            right--;
        }
    }


    // ================================================================
    // B2 - printBooks()
    // ================================================================

    public static void printBooks(
            Book[] books) {

        for (int i = 0;
             i < books.length;
             i++) {

            System.out.println(
                    (i + 1)
                            + ". "
                            + books[i]
            );
        }
    }


    // ================================================================
    // C1 - addItem()
    // ================================================================

    public static void addItem(
            ArrayList<LibraryItem> catalogue,
            LibraryItem item) {

        catalogue.add(item);

        System.out.println(
                "Added: "
                        + item.getTitle()
                        + " ["
                        + item.getIsbn()
                        + "]"
        );
    }


    // ================================================================
    // C1 - removeItem()
    // ================================================================

    public static boolean removeItem(
            ArrayList<LibraryItem> catalogue,
            ArrayList<LibraryItem> removalHistory,
            String isbn) {

        for (int i = 0;
             i < catalogue.size();
             i++) {

            LibraryItem item =
                    catalogue.get(i);

            if (item.getIsbn().equals(isbn)) {

                catalogue.remove(i);

                removalHistory.add(item);

                return true;
            }
        }

        return false;
    }


    // ================================================================
    // C1 - searchByTitle()
    // ================================================================

    public static ArrayList<LibraryItem> searchByTitle(
            ArrayList<LibraryItem> catalogue,
            String keyword) {

        ArrayList<LibraryItem> results =
                new ArrayList<>();

        String searchKeyword =
                keyword.toLowerCase();

        for (LibraryItem item : catalogue) {

            if (item.getTitle()
                    .toLowerCase()
                    .contains(searchKeyword)) {

                results.add(item);
            }
        }

        return results;
    }


    // ================================================================
    // C3 - undoRemove()
    // ================================================================

    public static void undoRemove(
            ArrayList<LibraryItem> catalogue,
            ArrayList<LibraryItem> removalHistory) {

        if (removalHistory.isEmpty()) {

            System.out.println(
                    "Nothing to undo."
            );

            return;
        }

        int lastIndex =
                removalHistory.size() - 1;

        LibraryItem item =
                removalHistory.remove(lastIndex);

        catalogue.add(item);

        System.out.println(
                "Undo successful: "
                        + item.getTitle()
                        + " has been restored."
        );
    }


    // ================================================================
    // C - printCatalogue()
    // ================================================================

    public static void printCatalogue(
            ArrayList<LibraryItem> catalogue) {

        if (catalogue.isEmpty()) {

            System.out.println(
                    "Catalogue is empty."
            );

            return;
        }

        for (int i = 0;
             i < catalogue.size();
             i++) {

            System.out.println(
                    (i + 1)
                            + ". "
                            + catalogue.get(i)
            );
        }
    }


    // ================================================================
    // D1 - borrow()
    // ================================================================

    public static boolean borrow(
            HashSet<String> currentlyBorrowed,
            String isbn) {

        // HashSet.add() returns false if the ISBN
        // is already present.
        return currentlyBorrowed.add(isbn);
    }


    // ================================================================
    // D1 - returnBook()
    // ================================================================

    public static boolean returnBook(
            HashSet<String> currentlyBorrowed,
            String isbn) {

        return currentlyBorrowed.remove(isbn);
    }


    // ================================================================
    // D2 - findByIsbn()
    // ================================================================

    public static Book findByIsbn(
            HashMap<String, Book> isbnIndex,
            String isbn) {

        // Direct HashMap lookup.
        return isbnIndex.get(isbn);
    }
}