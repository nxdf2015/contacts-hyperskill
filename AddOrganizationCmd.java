package contacts;

import contacts.command.Command;
import contacts.phonebook.Contact;
import contacts.phonebook.ContactOrganisation;
import contacts.phonebook.PhoneBook;

import java.util.Scanner;

public class AddOrganizationCmd implements Command {
    private PhoneBook phoneBook;

    public AddOrganizationCmd(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
       ;
    }

    @Override
    public void execute() {
        Scanner   scanner = IO.scanner();

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
        System.out.println();
        new Menu(phoneBook).execute();
    }
}
