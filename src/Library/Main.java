package Library;

public class Main {
    public static void main(String[] args) {
        AllData data = new AllData();

        Book booK = new Book("1234567891011", "A", "2", "B");
        Book book1 = new Book("1234567891111", "D", "2024", "D");
        data.addBook(booK);
        data.addBook(book1);


        Person person = new Person("ID 1", "D", "E", "123456789");
        data.addPerson(person);

        //Renting a book
        data.rentBook(person, book1, 5);

        new Enter(data);
    }
}
