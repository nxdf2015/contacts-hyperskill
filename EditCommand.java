package contacts;

import java.util.List;
import java.util.Scanner;

public class EditCommand implements Command {
    private final PhoneBook phoneBook;
    private final Scanner scanner;

    public EditCommand(PhoneBook phoneBook) {
        this.phoneBook=phoneBook;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        List<Contact> contacts = phoneBook.getContacts();
        if (contacts.isEmpty()){
            System.out.println("No records to edit!");
        }
        else {
            int i = 1;
            for(Contact c : phoneBook.getContacts()){
                System.out.println(i+". "+ c);
                i++;
            }
            System.out.println("Select a record: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Select a field (name, surname, number):");
            String field = scanner.nextLine();
            System.out.println("Enter "+field+": ");
            String value = scanner.nextLine();

            if (phoneBook.update(id-1,field,value)){
                System.out.println("The record is updated!");
            }
        }
    }
}
