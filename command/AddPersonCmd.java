package contacts.command;

import contacts.IO;
import contacts.Menu;
import contacts.Validate;
import contacts.command.Command;
import contacts.phonebook.Contact;
import contacts.phonebook.ContactPerson;
import contacts.phonebook.PhoneBook;

import java.util.Scanner;

public class AddPersonCmd implements Command {
    private PhoneBook phoneBook;

    public AddPersonCmd(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        Scanner in = IO.scanner();
        System.out.println("Enter the name:");
        String name = in.nextLine();

        System.out.println("Enter the surname:");
        String surname = in.nextLine();

        System.out.println("Enter the birth date: ");
        String birth = in.nextLine();
        if (Validate.date(birth).isEmpty()){
            System.out.println("Bad birth date!");
        }

        System.out.println("Enter the gender (M, F): ");
        String gender = in.nextLine();
        if (Validate.gender(gender).isEmpty()){
            System.out.println("Bad gender!");
        }

        System.out.println("Enter the number");
        String phone = in.nextLine();
        if (Validate.phone(phone).isEmpty()){
            System.out.println("Wrong number format!");
        }
        Contact c  = new ContactPerson(name,surname,phone,gender,birth);

        if (phoneBook.addContact(c)){
            System.out.println("The record added.");
        }
        System.out.println();
        new Menu(phoneBook).execute();
    }
}
