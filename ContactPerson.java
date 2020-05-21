package contacts;

import java.time.LocalDate;
import java.util.Optional;

public class ContactPerson extends Contact  {
    private String  surname;
    private Optional<String > phone;
    private Optional<Gender> gender;
    private Optional<LocalDate> birth;

    public ContactPerson(String name, String surname, String phone,String gender,String birth) {
        super(name,phone);

        this.surname = surname;
        this.gender=Validate.gender(gender);
        this.birth=Validate.date(birth);
        this.phone = Validate.phone(phone);
    }

    @Override
    public String toString() {
         StringBuilder s = new StringBuilder();
         s.append("Name: ")
         .append(name)
         .append(System.lineSeparator())
         .append("Surname: ")
         .append(surname)
          .append(System.lineSeparator())
         .append("Birth date: ")
          .append( Render.ifPresent(birth))
         .append(System.lineSeparator())
          .append("Gender: ")
          .append(Render.ifPresent(gender))
          .append(System.lineSeparator())
          .append("Number: ")
         .append(Render.ifPresent(phone))
          .append(System.lineSeparator())
                 //append timestamps
          .append(super.toString());
         return s.toString();
    }

    public void update(String field, String value) {
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
            case "gender":
                gender = Validate.gender(value);
                if (gender.isEmpty()){
                    System.out.println("Bad Gender!");
                }
                break;

        }
    }
}
