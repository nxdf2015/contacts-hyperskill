package contacts;

public class Contact {
    private String name,surname,phone;

    public Contact(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        System.out.println("A record created!");
    }
}
