import java.util.*;

public class PhoneBook {

    private Map<String, Abonent> abonents;

    public PhoneBook(TreeMap<String, Abonent> abonents) {
        setPhoneBook(abonents);
    }

    public Map<String, Abonent> getPhoneBook() { return abonents; }

    public void setPhoneBook(TreeMap<String, Abonent> abonents) throws IllegalArgumentException {

        for (String key : abonents.keySet())
            if(key == null || !key.matches("^\\+?380[0-9]{9}"))
                throw new IllegalArgumentException("Invalid phone");

        this.abonents = abonents;
    }

    public String findAbonent(String phone) {

        if(abonents.containsKey(phone))
            return abonents.get(phone).toString();

        return "Abonent is not found";
    }

    public void addAbonent(String phone, Abonent abonent) {

        if(phone == null || !phone.matches("^\\+?380[0-9]{9}"))
            throw new IllegalArgumentException("Invalid phone");

        abonents.put(phone, abonent);
    }

    public void delAbonent(String phone) {

        if (abonents.containsKey(phone))
            abonents.remove(phone);
    }

    public static Map<String, Abonent> sortBySurname(PhoneBook ph) {

        Comparator<String> valueComparator = new Comparator<>() {

            public int compare(String abonent1, String abonent2)
            {
                int comp = ph.abonents.get(abonent1).compareTo(ph.abonents.get(abonent2));

                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };

        Map<String, Abonent> sorted = new TreeMap<String, Abonent>(valueComparator);
        sorted.putAll(ph.abonents);

        return sorted;
    }

    public static void print(PhoneBook ph) {

        for(Map.Entry<String, Abonent> pair : ph.abonents.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        System.out.println();
    }
    public static void print(Map<String, Abonent> subs) {

        for(Map.Entry<String, Abonent> pair : subs.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        System.out.println();
    }
}
