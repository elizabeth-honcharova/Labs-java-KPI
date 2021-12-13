import java.util.Objects;

/**
 * Class intended to store data of notebook
 */
public class Notebook {

    private String name, nickname, phone, email, telegram;

    Notebook(String name, String nickname, String phone, String email, String telegram) throws IllegalAccessException {
        setName(name);
        setNickname(nickname);
        setPhone(phone);
        setEmail(email);
        setTelegram(telegram);
    }
    Notebook() {}

    /**
     * Check str for emptiness
     * @param str the string to check
     * @return true if str is empty and false if not
     */
    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public void setName(String name) throws IllegalAccessException {
        if(isEmpty(name))
            throw new IllegalAccessException("name cannot be empty");
        this.name = name;
    }
    public String getName(){ return name; }

    public void setNickname(String nickname) throws IllegalAccessException {
        if(isEmpty(nickname))
            throw new IllegalAccessException("nickname cannot be empty");
        this.nickname = nickname;
    }
    public String getNickname(){ return nickname; }

    public void setPhone(String phone) throws IllegalAccessException {
        if(isEmpty(phone))
            throw new IllegalAccessException("phone cannot be empty");
        this.phone = phone;
    }
    public String getPhone(){ return phone; }

    public void setEmail(String email) throws IllegalAccessException {
        if(isEmpty(email))
            throw new IllegalAccessException("email cannot be empty");
        this.email = email;
    }
    public String getEmail(){ return email; }

    public void setTelegram(String telegram) throws IllegalAccessException {
        if(isEmpty(telegram))
            throw new IllegalAccessException("telegram cannot be empty");
        this.telegram = telegram;
    }
    public String getTelegram(){ return telegram; }

    @Override
    public String toString() {
        return String.format("name: %s \nnickname: %s \nphone: %s \nemail: %s \ntelegram: %s",
                name, nickname, phone, email, telegram);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Notebook compObj = (Notebook) obj;
        return Objects.equals(name, compObj.name) && Objects.equals(nickname, compObj.nickname) &&
                Objects.equals(phone, compObj.phone) && Objects.equals(email, compObj.email) &&
                Objects.equals(telegram, compObj.telegram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nickname, phone, email, telegram);
    }
}
