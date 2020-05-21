package contacts;

import java.util.Scanner;

public class AddPersonCmd implements Command{
    private PhoneBook phoneBook;

    public AddPersonCmd(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
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
    }
}