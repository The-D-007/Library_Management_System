package Library;

import java.util.ArrayList;
import java.util.List;

public class AllData {

    //ArrayList of all data
    private List<Person> personList;
    private List<Book> bookList;
    private List<BookRent> bookRentList;

    public AllData(){
        personList = new ArrayList<>();
        bookList = new ArrayList<>();
        bookRentList = new ArrayList<>();
    }

    //Person getters
    public Person getPerson(String personID){
        for (Person person: personList){
            if (person.getID().equals(personID)){
                return person;
            }
        }
        return null;
    }

    public String getFirstName(String personID){
        for (Person person: personList){
            if (person.getID().equals(personID)){
                return person.getFirstName();
            }
        }
        return null;
    }

    public String getNewID(){
        return "ID " + (personList.size() + 1);
    }

    //Checking if the person is present in the list or not
    public boolean checkPerson(String personID){
        for (Person person: personList){
            if(person.getID().equals(personID)){
                return true;
            }
        }
        return false;
    }


    //Adding person objects
    public void addPerson(Person person){
        personList.add(person);
    }

    //Adding book objects
    public void addBook(Book book){
        bookList.add(book);
    }

    //Checking if book is in bookList or not
    public Book getBook(String ISBNBookReturn){
        for (Book book : bookList) {
            if (book.getISBN().equals(ISBNBookReturn) && !book.isAvailable()) {
                return book;
            }
        }
        return null;
    }


    //Function to rent a book
    public String rentBook(Person person, Book book, int days){
        if (book.isAvailable()){
            book.rentBook();
            bookRentList.add(new BookRent(person, book, days));
            return "Book " + book.getBookName() + ", ISBN: " + book.getISBN() + ", is rented to " + person.getFirstName() + " " + person.getLastName() + " for " + days + (days > 1?  " days." : " day.") ;

        }
        return "The book is not available";
    }

    //Function to return a book
    public void returnBook(Book book){
        BookRent bookToReturn = null;
        for (BookRent bookRent: bookRentList){
            if (bookRent.getBook() == book){
                bookToReturn = bookRent;
            }
        }
        if (bookToReturn != null){
            bookRentList.remove(bookToReturn);
            book.returnBook();
            System.out.println("Book " + book.getBookName() + ", ISBN: " + book.getISBN() + " is returned");
        } else{
            System.out.println("The book was not rented");
        }
    }

    //Function to check if a book is available or not
    public List<Book> availableBooks(){
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    //Function to check if a book is in the data or not
    public Book checkBook(String ISBNBookRent){
        Book selectedBook = null;
        for (Book book : bookList) {
            if (book.getISBN().equals(ISBNBookRent)) {
                selectedBook = book;
            }
        }
        return selectedBook;
    }

    //Seeing the books rented by a user
    public List<BookRent> getBookRentList(String personID){
        List<BookRent> rentDetails = new ArrayList<>();
        for (BookRent bookRent: bookRentList){
            if (bookRent.getPerson().getID().equals(personID)){
                rentDetails.add(bookRent);
            }
        }
        return rentDetails;
    }
}

