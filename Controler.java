package contacts;

import contacts.command.*;
import contacts.phonebook.PhoneBook;

public class Controler {
    private Command cmd;
    private PhoneBook phoneBook;

    public Controler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void setCommand(String nameCommand){
        switch(nameCommand) {
            case "count":
                cmd = new CountCommand(phoneBook);
                break;
            case "search":
                cmd = new SearchCommand(phoneBook);
                break;
            case "list":
                cmd = new ListCommand(phoneBook);


        }
    }


    public void setCommand(String nameCommand,String type) {
        Type t = Type.valueOf(type.toUpperCase());
        switch(nameCommand){

            case "add":
                if (t == Type.ORGANIZATION){
                    cmd = new AddOrganizationCmd(phoneBook);
                }
                else{
                    cmd = new AddPersonCmd(phoneBook);
                }
                break;
        }
    }

    public void executeCommand(){
        cmd.execute();
    }
}
