package Library;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserDetails {
    private AllData data;
    private String personID;

    public UserDetails(){}

    public UserDetails(AllData data, String personID) {
        this.data = data;
        this.personID = personID;
    }
        public void userMenu(){
            Scanner scanner = new Scanner(System.in);


            while (true) {
                System.out.println("1. See rented books.");
                System.out.println("2. Go to the library menu.");
                System.out.println("3. Go to Login ");
                System.out.print("Choose an option: ");

                int choice = 0;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice < 1 || choice > 3) {
                        System.out.println("Please choose between 1 to 3 numbers");
                    } else {
                        if (choice == 1) {
                            List<BookRent> rentDetails = data.getBookRentList(personID);
                            if (rentDetails.isEmpty()) {
                                System.out.println("No book was rented.\n");
                            } else {
                                for (BookRent rentDetail : rentDetails) {
                                    System.out.println(rentDetail.toString());
                                }
                            }
                        } else if (choice == 2) {
                            Library library = new Library(data, personID);
                            library.menu();
                            return;
                        } else {
                            new Enter(data);
                            break;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please choose a number");
                    scanner.next(); //Clears the invalid input.
                }
            }
        }
    }
