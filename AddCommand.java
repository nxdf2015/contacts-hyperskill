package contacts;

import java.util.Scanner;

public class AddCommand implements Command{
    private PhoneBook phoneBook;

    public AddCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = in.nextLine();
        System.out.println("Enter the surname:");
        String surname = in.nextLine();
        System.out.println("Enter the number");
        String phone = in.nextLine();
        if (Validate.phone(phone).isEmpty()){
            System.out.println("Wrong number format!");
        }
        Contact c  = new Contact(name,surname,phone);

        if (phoneBook.addContact(c)){
            System.out.println("The record added.");
        }
    }
}
