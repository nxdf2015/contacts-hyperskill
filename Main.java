package contacts;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu app = new Menu();
        Controler contactsApp = new Controler(new PhoneBook());

        while (app.isActive){

            String  cmd = app.getCommand();
            if (!cmd.equals("exit")) {
                contactsApp.setCommand(cmd);
                contactsApp.executeCommand();
            }
        }



    }
}
