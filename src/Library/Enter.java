package Library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Enter {
    private AllData data;

    public Enter(){}

    public Enter(AllData data){
        this.data = data;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n***Welcome to the library***");
            System.out.println("1. Login ");
            System.out.println("2. Sign up ");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > 3) {
                    System.out.println("Please choose between the give options");
                } else {
                    if (choice == 1) {
                        System.out.print("Enter your ID: ");
                        String loginID = scanner.nextLine();
                        new Login(data, loginID);
                        return;
                    } else if (choice == 2) {
                        new SignUp(data);
                        return;
                    } else {
                        System.out.println("\n***Visit again***");
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input integers");
                scanner.next(); //Clears the invalid input.
            }
        }
    }
}
