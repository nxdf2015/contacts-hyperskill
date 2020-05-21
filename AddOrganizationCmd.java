package contacts;

import java.util.Scanner;

public class AddOrganizationCmd implements Command {
    private PhoneBook phoneBook;

    public AddOrganizationCmd(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
       ;
    }

    @Override
    public void execute() {
        Scanner   scanner = new Scanner(System.in);

        System.out.println("Enter the organization name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the number: ");
        String phone = scanner.nextLine();
        if (Validate.phone(phone).isEmpty()){
            System.out.println("Wrong number format!");
        }
        Contact c = new ContactOrganisation(name,phone,address);

        if (phoneBook.addContact(c)){
            System.out.println("The record added.");
        }
    }
}
