package Library;

public class BookRent {
    private Person person;
    private Book book;
    private int days;

    public BookRent(){}

    public BookRent(Person person, Book book, int days){
        this.person = person;
        this.book = book;
        this.days = days;
    }


    //Checking if days are positive or not
    public boolean checkDays(int days){
        try {
            if (days > 0){
                return true;
            } else {
                throw new IllegalArgumentException("Days must me greater than 0.");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return  false;
    }

    //Getters
    public Person getPerson(){
        return person;
    }

    public Book getBook(){
        return book;
    }

    public int getDays(){
        return days;
    }

    // Override toString method
    @Override
    public String toString() {
        return "\nBookRent details:\n" + person + "\n" + book + "\ndays: " + days + "\n" ;
    }
}
