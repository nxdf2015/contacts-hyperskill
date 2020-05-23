package contacts.command;

import contacts.*;
import contacts.action.Action;
import contacts.phonebook.Contact;
import contacts.phonebook.PhoneBook;

import java.util.List;
import java.util.Scanner;

public class ListCommand implements Command {


    private final PhoneBook phoneBook;

    public ListCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }


    @Override
    public void execute() {
        Scanner scanner = IO.scanner();
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
            System.out.println();
            String text = "[list] Enter action ([number], back): ";
            try {
                int id = Integer.parseInt(IO.nextLine(text));

                System.out.println(phoneBook.getContact(id  ));
                System.out.println();

                Action actionRecord = new ActionRecord( phoneBook);
                actionRecord.execute(id);
            }
            catch (Exception e){
                new Menu(phoneBook).execute();
                return;
            }

        }
    }
}
