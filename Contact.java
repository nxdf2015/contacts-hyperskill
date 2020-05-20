package contacts;

import java.util.Optional;

public class Contact {
    private String name,surname;
    private Optional<String > phone;

    public Contact(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = Validate.phone(phone);
    }

    @Override
    public String toString() {
         StringBuilder s = new StringBuilder();
         s.append(name);
         s.append(" ");
         s.append(surname);
         s.append(", " );
         if (phone.isPresent())
         s.append(phone.get());
         else
             s.append("[no number]");
         return s.toString();
    }

    public void set(String field, String value) {
        switch(field){
            case "name":
                name = value;
                break;
            case "surname":
                surname=value;
                break;
            case "number":
                phone = Validate.phone(value);
                if (phone.isEmpty()){
                    System.out.println("Wrong number format!");
                }
                break;

        }
    }
}
