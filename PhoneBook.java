package contacts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {
    private static  PhoneBook phoneBook = null;
    private List<Contact> contacts ;



    protected PhoneBook(){
        contacts = new ArrayList<>();
    }


    boolean remove(int id) {
        try {
            contacts.remove(id);
            return true;
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
    }



     boolean addContact(Contact c) {

         return contacts.add(c);
    }


    public int count() {
        return contacts.size();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public boolean update(int id, String field, String value) {
        try {
            contacts.get(id).set(field, value);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
}
