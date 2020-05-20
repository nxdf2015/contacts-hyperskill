package contacts;

import java.util.List;
import java.util.Scanner;

public class ListCommand implements Command{

    private PhoneBook phoneBook;

    public ListCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        List<Contact> contacts = phoneBook.getContacts();
        if (contacts.isEmpty()){
            System.out.println("No records!");
        }
        else {
            int i = 1;
            for(Contact c : phoneBook.getContacts()){
                System.out.println(i+". "+ c);
                i++;
            }

        }

    }
}
