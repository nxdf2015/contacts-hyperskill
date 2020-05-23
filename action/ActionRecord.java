package contacts.action;

import contacts.IO;
import contacts.Menu;
import contacts.action.Action;
import contacts.action.ActionDelete;
import contacts.action.ActionEdit;
import contacts.phonebook.PhoneBook;

import java.util.Scanner;

public class ActionRecord implements Action {
    private final PhoneBook phoneBook;
    private Scanner scanner = IO.scanner();
    public ActionRecord (PhoneBook phoneBook) {

        this.phoneBook = phoneBook;
    }


    @Override
    public void execute(int id) {
//        System.out.println(phoneBook.getContact(id -1 ));
//        System.out.println();
        String text = "[record] Enter action (edit, delete, menu): ";
        String selected = IO.nextLine(text);


        switch(selected){
            case "edit":


                Action  actionEdit  = new ActionEdit(phoneBook);
                actionEdit.execute(id);
                break;
            case "delete":
                Action actionDelete = new ActionDelete(phoneBook);
                actionDelete.execute(id);
                break;
            default:
                new Menu(phoneBook).execute();
                return;
        }

        execute(id);
    }
}
