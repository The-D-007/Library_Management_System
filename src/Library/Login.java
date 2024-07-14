package Library;

public class Login {
    private AllData data;
    private String personID;

    public Login() {}

    public Login(AllData data, String personID) {
        this.data = data;
        this.personID = personID;
        if (data.checkPerson(personID)) {
            System.out.println("\nWelcome " + data.getFirstName(personID) + " in the library.");
            UserDetails userDetails = new UserDetails(data, personID);
            userDetails.userMenu();

        } else {
            System.out.println("Please provide right ID or sign up" );
            new Enter(data);
        }
    }
}
