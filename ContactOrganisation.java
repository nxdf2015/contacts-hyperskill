package contacts;

public class ContactOrganisation extends Contact{
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
                phone = Validate.phone(value);
        }

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
                .append(Render.ifPresent(phone))
                .append(System.lineSeparator())
                .append(super.toString());

        return builder.toString();
    }
}
