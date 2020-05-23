package contacts;


import contacts.phonebook.PhoneBook;

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




    }
}
