package Library;

import java.util.Scanner;

public class SignUp {
    private AllData data;

    //Person object
    Person objPerson = new Person();

    public SignUp(AllData data){
        this.data = data;

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Sign Up ");
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        if (objPerson.checkPhoneNumber(phoneNumber)) {
            String id = data.getNewID();
            data.addPerson(new Person(id, firstName, lastName, phoneNumber));
            System.out.println("Your ID is: " +"'" + id + "'"+ ". Please login with it.");
            new Enter(data);

        } else {
             System.out.println("Provide the right phone number.");
             scanner.next();
        }
    }
}
