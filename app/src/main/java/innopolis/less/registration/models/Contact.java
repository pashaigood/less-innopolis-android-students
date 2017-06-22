package innopolis.less.registration.models;

public class Contact {
    private ContactType type;
    private String value;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return (21+value.hashCode()*41) + (21+type.hashCode()*41);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }

        return ((Contact) obj).getValue().equals(value) && ((Contact) obj).getType().equals(type);
    }
}
