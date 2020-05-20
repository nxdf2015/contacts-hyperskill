package contacts;

import java.util.Scanner;

public class RemoveCommand implements Command{
    private Scanner scanner = new Scanner(System.in);
    private PhoneBook phoneBook;

    public RemoveCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        if (phoneBook.count() == 0){
            System.out.println("No records to remove!");
        }
        else {
            int i = 1;
            for(Contact c : phoneBook.getContacts()){
                System.out.println(i+". "+ c);
                i++;
            }
            System.out.println("Select a record:");
            int id = scanner.nextInt();
            if (phoneBook.remove(id-1)){
                System.out.println("The record removed!");
            }
        }

    }
}
