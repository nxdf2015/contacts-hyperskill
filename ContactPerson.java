package contacts;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ContactPerson extends Contact implements Serializable {
    private String  surname;

    private Gender gender;
    private LocalDate birth;

    public ContactPerson(String name, String surname, String phone,String gender,String birth) {
        super(name,phone);

        this.surname = surname;
        this.gender=Validate.gender(gender).orElse(null);
        this.birth=Validate.date(birth).orElse(null);
        this.phone = Validate.phone(phone).orElse("");
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
          .append( birth == null ? "[no data]" : birth)
         .append(System.lineSeparator())
          .append("Gender: ")
          .append(gender == null ? "[no data]" : gender)
          .append(System.lineSeparator())
          .append("Number: ")
         .append( phone.isEmpty() ? "[no data]" : phone)
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
                Optional<String> phoneOption = Validate.phone(value);
                if (phone.isEmpty()){
                    System.out.println("Wrong number format!");
                    phone= "";
                }
                else {
                    phone = phoneOption.get();
                }
                break;
            case "birth":
                Optional<LocalDate> birthOption = Validate.date(value);
                if (birthOption.isEmpty()){
                    System.out.println("Bad birth date!");
                    birth = null;
                }
                else {
                    birth = birthOption.get();
                }
            case "gender":
                Optional<Gender> genderOption = Validate.gender(value);
                if (genderOption.isEmpty()){
                    System.out.println("Bad Gender!");
                    gender = null;
                }
                else {
                    gender = genderOption.get();
                }
                break;

        }
    }

    @Override
    public List<String> values() {
        return List.of(surname,name);
    }

    @Override
    public List<String> fields(){
        return List.of("name","surname","number");
    }

    @Override
    public String getValue(String field) {


        switch (field) {

            case "surname":
                return surname;
            case "name":
                return name;
            case "number":
                return phone;
            default:
                return "";

        }
    }

    @Override
    public String getName() {
        return name+" "+surname;
    }
}
