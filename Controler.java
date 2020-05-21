package contacts;

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
            case "remove":
                cmd = new RemoveCommand(phoneBook);
                break;
            case "info":
                cmd = new InfoCommand(phoneBook);
                break;
            case "edit":
                cmd = new EditCommand(phoneBook);

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
