package Library;

public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private String phoneNumber;


    public Person(){}

    public Person(String ID, String firstName, String lastName, String phoneNumber){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


    //Checking if provided phone number is valid or not.
    public boolean checkPhoneNumber(String phoneNumber){
        try {
            if (phoneNumber.matches("\\d{10}")) {
               return true;
            } else if (phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
                return true;
            } else {
                throw new IllegalArgumentException("Invalid phone number. Enter only 10 digits");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    //Getters
    public String getID(){
        return ID;
    }
    public String getFirstName(){
        return firstName;
    } public String getLastName(){
        return lastName;
    } public String getPhoneNumber(){
        return phoneNumber;
    }

    //Overriding the toString method
    @Override
    public String toString(){
        return "ID: " + getID() +  ", Name: " + getFirstName() + " " + getLastName() + ", Phone number: " + getPhoneNumber();
    }
}

