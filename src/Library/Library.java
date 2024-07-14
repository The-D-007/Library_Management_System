package Library;

import java.util.*;

public class Library {
    private AllData data;
    private String personID;

    public Library(AllData data, String personID){
        this.data = data;
        this.personID = personID;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        // Making  class objects
        Book objBook = new Book();
        Person objPerson = new Person();
        BookRent objBookRent = new BookRent();

        while (true) {
            System.out.println("\n***Welcome to the Library Menu***");
            System.out.println("1. Rent a book");
            System.out.println("2. Return a book");
            System.out.println("3. Go back to home");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > 4) {
                    System.out.println("Please choose between 1 to 3 numbers");
                } else {
                    if (choice == 1) {
                        System.out.println("\n***Available Books***");
                        if (data.availableBooks().isEmpty()){
                                System.out.println("Sorry, no books are available at this time.");
                        } else {
                            for (Book book : data.availableBooks()){
                                System.out.println(book);
                            }
                            System.out.print("Please enter the ISBN of the book you want: ");
                            String ISBNBookRent = scanner.nextLine();
                            if (objBook.checkISBN(ISBNBookRent)) {
                                Book selectedBook = data.checkBook(ISBNBookRent);
                                if (selectedBook != null){
                                        System.out.print("For how many days you want the book " + data.getFirstName(personID) + " : ");
                                    try {
                                            int days = scanner.nextInt();
                                            scanner.nextLine();
                                            if (objBookRent.checkDays(days)) {
                                                System.out.println(data.rentBook(data.getPerson(personID), selectedBook, days));
                                            } else {
                                                throw new IllegalArgumentException("Invalid days, enter numbers please.");
                                            }
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getMessage());
                                        }
                                } else{
                                    System.out.println("Please enter available book ISBN.");
                                }
                            }
                        }
                    } else if (choice == 2) {
                        System.out.print("Enter the ISBN of the book you want to return: ");
                        String ISBNBookReturn = scanner.nextLine();
                        if (objBook.checkISBN(ISBNBookReturn)) {
                            Book bookReturn = data.getBook(ISBNBookReturn) ;
                            if (bookReturn != null){
                                data.returnBook(bookReturn);
                            } else{
                                System.out.println("Enter right ISBN or the book was not rented.");
                            }
                        }
                    } else if (choice == 3){
                        System.out.println("\n***Back To home***");
                        UserDetails userDetails = new UserDetails(data, personID);
                        userDetails.userMenu();
                        break;
                    }else {
                        System.out.println("\nBye!!!");
                        break;
                    }
                }
                }catch(InputMismatchException e){
                    System.out.println("Please choose a number");
                    scanner.next(); //Clears the invalid input.
            }
        }
    }
}
