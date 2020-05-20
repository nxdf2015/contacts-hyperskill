package contacts;

public class Controler {
    private Command cmd;
    private PhoneBook phoneBook;

    public Controler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void setCommand(String nameCommand){
        switch(nameCommand){
            case "count":
                cmd = new CountCommand(phoneBook);
                break;
            case "list":
                cmd = new ListCommand(phoneBook);
                break;
            case "remove":
                cmd = new RemoveCommand(phoneBook);
                break;
            case "edit":
                cmd = new EditCommand(phoneBook);
                break;
            case "add":
                cmd = new AddCommand(phoneBook);
                break;



        }
    }
    public void executeCommand(){
        cmd.execute();
    }
}
