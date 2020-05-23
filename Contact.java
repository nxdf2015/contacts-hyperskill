package contacts;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

public abstract class Contact  implements Serializable {
    private final LocalDateTime created;
    private   LocalDateTime edit;
    protected String name,surname;
    protected String  phone;

    public Contact(String name , String phone) {
        this.name = name;
        this.phone = Validate.phone(phone).orElse("");
        this.created = LocalDateTime.now().withNano(0);
        this.edit = LocalDateTime.now().withNano(0);
    }



    @Override
    public String toString() {
        StringBuilder builder  = new StringBuilder();
        builder.append("Time created: ")
                .append(created)
                .append(System.lineSeparator())
                .append("Time last edit: ")
                .append(created);
        return builder.toString();
    }

    public abstract void update(String field,String value);

    public void set(String field, String value) {
        this.edit=LocalDateTime.now().withNano(0);
        update(field,value);
    }

    public abstract List<String> values();

    public abstract String getValue(String field);

    public abstract List<String> fields();

    public String getName() {
        return  this.name;
    }
}
