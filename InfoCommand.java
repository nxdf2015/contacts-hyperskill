package contacts;

import java.util.List;
import java.util.Scanner;

public class InfoCommand implements Command{

    private PhoneBook phoneBook;

    public InfoCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        Scanner scanner =new Scanner(System.in);
        List<Contact> contacts = phoneBook.getContacts();
        if (contacts.isEmpty()){
            System.out.println("No records!");
        }
        else {
            int i = 1;
            for(Contact c : phoneBook.getContacts()){
                System.out.println(i+". "+ c.getName());
                i++;
            }
            System.out.println("Enter index to show info: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println(phoneBook.getContact(id - 1));

        }

    }
}
