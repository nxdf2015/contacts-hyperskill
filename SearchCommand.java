package contacts;

import java.util.List;
import java.util.Scanner;

public class SearchCommand implements Command {

    private final PhoneBook phoneBook;

    public SearchCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;

    }

    @Override
    public void execute() {
        String text = "Enter search query: ";

        String query = IO.nextLine(text);
        List<Contact> contacts = phoneBook.find(query);
        System.out.println("Found " + contacts.size() + " results:");
        int i = 1;
        for (Contact c : contacts) {
            System.out.println(i + ". " + c.getName());
            i++;

        }
        System.out.println();
        text = "[search] Enter action([number], back, again): ";

        String action = IO.nextLine(text);

        try {
            int id = Integer.parseInt(action);

            System.out.println(phoneBook.getContact(id  ));
            System.out.println();

            Action actionRecord = new ActionRecord(phoneBook);
            actionRecord.execute(id);
        }
        catch(Exception e) {
            switch(action){
                case "back":
                     new Menu(phoneBook).execute();
                     return;
                case "again":

                    execute();

            }
        }
    }
}

