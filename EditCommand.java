package contacts;

import java.util.Scanner;

public class EditCommand implements Command {
    private final PhoneBook phoneBook;

    public EditCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }



    @Override
    public void execute() {
        if (phoneBook.count() == 0){
            System.out.println("No records to edit");
        }
        else {
            Scanner scanner = new Scanner(System.in);
            int i = 1;
            for (Contact c : phoneBook.getContacts()) {
                System.out.println(i + ". " + c);
                i++;
            }
            System.out.println("Select a record: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Contact c = phoneBook.getContact(id - 1);
            Type type = phoneBook.getType(id - 1);
            if (type == Type.ORGANIZATION) {
                editOrganisation();
            } else {
                editPerson();
            }
            String field = scanner.nextLine();
            System.out.println("Enter " + field + ": ");
            String value = scanner.nextLine();

            if (phoneBook.update(id - 1, field, value)) {
                System.out.println("The record is updated!");
            }
        }
    }
    private void editPerson() {
        System.out.println("Select a field (organization, address, number):");
    }

    private void editOrganisation() {
        System.out.println("Select a field (name, surname, birth, gender, number):");
    }


}
