import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private String name;
    private String email;
    private List<Book> borrowedBooks;

    public Borrower(String name, String email) {
        this.name = name;
        this.email = email;
        borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Library library, String title) {
        List<Book> foundBooks = library.searchByTitle(title);
        if (!foundBooks.isEmpty()) {
            Book bookToBorrow = foundBooks.get(0);
            borrowedBooks.add(bookToBorrow);
            library.books.remove(bookToBorrow);
            System.out.println("'" + bookToBorrow.title + "' is borrowed by " + name + ".");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void returnBook(Library library, String title) {
        for (Book book : borrowedBooks) {
            if (book.title.equalsIgnoreCase(title)) {
                borrowedBooks.remove(book);
                library.addBook(book);
                System.out.println("'" + book.title + "' is returned to the library by " + name + ".");
                return;
            }
        }
        System.out.println("'" + title + "' was not borrowed by " + name + " or is not found.");
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has not borrowed any books.");
        } else {
            System.out.println(name + "'s Borrowed Books:");
            for (Book book : borrowedBooks) {
                book.displayDetails();
                System.out.println();
            }
        }
    }
}

