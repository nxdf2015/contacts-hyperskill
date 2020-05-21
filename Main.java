package contacts;


public class Main {
    public static void main(String[] args) {
        Menu app = new Menu();
        Controler contactsApp = new Controler(new PhoneBook());

        while (app.isActive){

            String  cmd = app.getCommand();

            if (cmd.equals("exit")){
                break;}
            else if (! cmd.equals("add")){

                    contactsApp.setCommand(cmd);
                    contactsApp.executeCommand();
                }
            else if ( cmd.equals("add")){
                String type = app.getType();
                contactsApp.setCommand(cmd,type);
                contactsApp.executeCommand();
            }
        }



    }
}
