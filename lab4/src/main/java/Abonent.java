public class Abonent implements Comparable<Abonent> {

    private String name, surname, patronymic;
    private String address;

    public Abonent(String surname, String name, String patronymic, String address)
    {
        setName(name);
        setSurname(surname);
        setPatronymic(patronymic);
        setAddress(address);
    }

    public String getName() { return name; }

    public void setName(String name) throws IllegalArgumentException {
        if(name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Invalid name");
        this.name = name;
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) throws IllegalArgumentException {
        if(surname == null || surname.trim().isEmpty())
            throw new IllegalArgumentException("Invalid surname");
        this.surname = surname;
    }

    public String getPatronymic() { return patronymic; }

    public void setPatronymic(String patronymic) throws IllegalArgumentException {
        if(patronymic == null || patronymic.trim().isEmpty())
            throw new IllegalArgumentException("Invalid patronymic");
        this.patronymic = patronymic;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) throws IllegalArgumentException {
        if(address == null || address.trim().isEmpty())
            throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("[Abonent: %s %s %s, address: %s]", surname, name, patronymic, address);
    }

    @Override
    public int compareTo(Abonent sub) {
        return this.toString().compareTo(sub.toString());
    }
}
