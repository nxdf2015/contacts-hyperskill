package contacts;

import java.util.Scanner;

public class ActionEdit implements Action {
    private final PhoneBook phoneBook;

    public ActionEdit(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute(int id) {
       // System.out.println("4----------------------------");
        Type type = phoneBook.getType(id);

        if (type == Type.ORGANIZATION){
            editOrganisation();
        }
        else {
            editPerson();
        }
       // System.out.println("2----------------------------");
        Scanner scanner = IO.scanner();
        String field = scanner.nextLine();
       // System.out.println("3----------------------------");
        System.out.println("Enter "+field+" :");
        String value = scanner.nextLine();
        if (phoneBook.update(id,field,value)){
            System.out.println("Saved");
        }
        System.out.println(phoneBook.getContact(id));
        System.out.println();

    }

    private void editPerson() {
        System.out.println("Select a field (organization, address, number):");
    }

    private void editOrganisation() {
        System.out.println("Select a field (name, surname, birth, gender, number):");
    }
}
