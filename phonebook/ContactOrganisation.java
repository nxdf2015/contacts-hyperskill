package contacts.phonebook;

import contacts.Validate;
import contacts.phonebook.Contact;

import java.util.List;
import java.util.Optional;

public class ContactOrganisation extends Contact {
    private String adress;

    public ContactOrganisation(String name, String phone, String adress) {
        super(name, phone);
        this.adress = adress;
    }

    @Override
    public void update(String field, String value) {
        switch (field){
            case "organisation":
                name = value;
                break;
            case "address":
                adress=value;
                break;
            case "number":
                Optional<String> phoneOption = Validate.phone(value);
                if (phoneOption.isEmpty()){
                    System.out.println("Wrong number!");
                }
                phone=phoneOption.orElse("");
        }

    }

    @Override
    public List<String> values() {
        return List.of(name,adress);
    }

    @Override
    public String getValue(String field) {
        switch (field){
            case "name":
                return name;
            case "adress":
                return adress;
            case "number":
                return phone;
            default:
                return "";
        }
    }

    @Override
    public List<String> fields() {
        return List.of("name","adress","number");

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Organization name: ")
                .append(name)
                .append(System.lineSeparator())
                .append("Address: ")
                .append(adress)
                .append(System.lineSeparator())
                .append("Number: ")
                .append(phone.isEmpty() ? "[no data]" : phone)
                .append(System.lineSeparator())
                .append(super.toString());

        return builder.toString();
    }
}
