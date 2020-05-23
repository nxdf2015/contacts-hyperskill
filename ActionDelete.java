package contacts;

public class ActionDelete implements Action {
    private final PhoneBook phoneBook;

    public ActionDelete(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute(int id) {
        if (phoneBook.remove(id-1)){
            System.out.println("The record removed!");
        }
    }
}
