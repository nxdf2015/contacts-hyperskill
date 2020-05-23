package contacts;

import contacts.command.Command;
import contacts.phonebook.PhoneBook;

import java.util.Scanner;

public class Menu implements Command {
    private PhoneBook phoneBook;



    public Menu(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void  execute() {
        Scanner in = IO.scanner();
        String text = "[menu] Enter action (add, list, search, count, exit):";

        String cmd =  IO.nextLine(text);


        Controler contactsApp = new Controler(phoneBook);
        if (cmd.equals("exit")){
               return ;}
            else if (! cmd.equals("add")){

                    contactsApp.setCommand(cmd);
                    contactsApp.executeCommand();
                }
            else if ( cmd.equals("add")){
                String type = getType();
                contactsApp.setCommand(cmd,type);
                contactsApp.executeCommand();
            }
        }




    public String getType() {

        String text = "Enter the type  (person, organization):";
        return IO.nextLine(text);
    }
}
