package contacts.phonebook;

import contacts.Type;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PhoneBook implements Serializable{

    transient private final String nameFile;
    private List<Contact> contacts ;



    public PhoneBook(){

        nameFile="default";
        contacts = new ArrayList<>();
    }

    public PhoneBook(String nameFile) {
        this.nameFile = nameFile;
        this.contacts = contacts = new ArrayList<>();
    }


    public boolean remove(int id) {
        try {
            contacts.remove(id);
            return true;
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
    }



     public boolean addContact(Contact c) {

         boolean valid = contacts.add(c);
         save();
         return valid;
    }


    public int count() {
        return contacts.size();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public boolean update(int id, String field, String value) {
        try {
            contacts.get(id-1).set(field, value);
            save();
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    public Contact getContact(int i) {
        return contacts.get(i-1);
    }

    public Type getType(int i) {
        if (contacts.get(i-1).getClass() == ContactPerson.class){
            return Type.PERSON;
        }
        else {
            return Type.ORGANIZATION;
        }
    }
    private  Predicate<Contact> predicate(String query) {


        return c -> {

            Pattern queryPattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);


            Predicate<String> p = v -> queryPattern.matcher(v).find() ;
            boolean match = false;


            for(String field : c.fields()){

                 match = match || p.test(c.getValue(field));
            }
            return match;
        };
    }

    
    public List<Contact> find(String query) {
        Predicate<Contact> p = predicate(query);
        List<Contact> contactFind = contacts.stream().filter(p).collect(Collectors.toList());
        return contactFind;
    }


    public boolean load( )  {
        System.out.println("open "+nameFile+"\n");
       try( FileInputStream fileInputStream = new FileInputStream(new File(nameFile));
        BufferedInputStream bufferedInputStream = new BufferedInputStream((fileInputStream));
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
       ){
           contacts = (List<Contact>) objectInputStream.readObject();



       }
       catch(IOException e){

          e.printStackTrace();
           return false;
       } catch (ClassNotFoundException e) {
           return false;
       }
        return true;
    }

    public boolean save( ){
        try(
                FileOutputStream fileOutputStream =new FileOutputStream(new File(nameFile));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                ObjectOutputStream os = new ObjectOutputStream(bufferedOutputStream);
                )
        {

            os.writeObject(contacts);
        }
        catch (IOException e){
            return false;
        }
        return true;
    }
}
