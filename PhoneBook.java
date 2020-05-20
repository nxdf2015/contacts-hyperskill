package contacts;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private static  PhoneBook phoneBook = null;
    private List<Contact> contacts ;

    public static PhoneBook add(Contact c) {
        if (phoneBook == null){

            System.out.println("A Phone book with a single record created!");
            phoneBook = new PhoneBook();
            phoneBook.addContact(c);

        }
        else{
            phoneBook.addContact(c);

        }
        return phoneBook;
    }

    private PhoneBook(){
        contacts = new ArrayList<>();
    }
    private void addContact(Contact c) {

    }


}
