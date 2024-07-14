package Library;


public class Book {
    private String ISBN;
    private String bookName;
    private int publishYear;
    private String author;
    private boolean isAvailable;

    public Book(){}

    public Book(String ISBN, String bookName, int publishYear, String author){
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.publishYear = publishYear;
        this.author = author;
        this.isAvailable = true;
    }

    //Checking if the provided ISBN is right or not.
    public boolean checkISBN(String ISBN){
        try {
            if (ISBN.matches("\\d{13}")) {
                return true;
            } else {
                throw new IllegalArgumentException("Invalid ISBN. Please input 13 digits ISBN.");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    //Getter
    public String  getISBN(){
        return ISBN;
    }

    public String getBookName(){
        return bookName;
    }

    public int getPublishYear(){
        return publishYear;
    }

    public String getAuthor(){
        return author;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    //Methods to rent and return the book
    public void rentBook(){
        isAvailable = false;
    }

    public void returnBook(){
        isAvailable = true;
    }

    //Overriding toString method
    @Override
    public String toString(){
        return "Book ISBN: " + ISBN + ", Name: " + bookName + ", publishYear: " + publishYear + ", author: " + author;
    }
}
