package contacts;


public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook;
        if (args.length == 0){
            phoneBook = new PhoneBook();

        }
        else {
            String nameFile=args[0];
            phoneBook = new PhoneBook(nameFile);
            phoneBook.load();
        }

        new Menu(phoneBook).execute();

//        Menu app = new Menu();
//        Controler contactsApp = new Controler(new PhoneBook());
//
//        while (true){
//
//            String  cmd = app.getCommand();
//
//            if (cmd.equals("exit")){
//                break;}
//            else if (! cmd.equals("add")){
//
//                    contactsApp.setCommand(cmd);
//                    contactsApp.executeCommand();
//                }
//            else if ( cmd.equals("add")){
//                String type = app.getType();
//                contactsApp.setCommand(cmd,type);
//                contactsApp.executeCommand();
//            }
//        }



    }
}
