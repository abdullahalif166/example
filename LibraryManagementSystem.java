public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        Book book3 = new Book("1984", "George Orwell", "978-0451524935");

        // Create a library and add books to it
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Create a borrower
        Borrower borrower1 = new Borrower("Alice", "alice@example.com");

        // Borrow a book
        borrower1.borrowBook(library, "The Great Gatsby");

        // Display borrowed books by the borrower
        borrower1.displayBorrowedBooks();

        // Return a book
        borrower1.returnBook(library, "The Great Gatsby");

        // Display all books in the library
        library.displayAllBooks();
    }
}

