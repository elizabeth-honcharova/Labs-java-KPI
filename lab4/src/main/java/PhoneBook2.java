import java.util.*;

public class PhoneBook2 {

    private Map<Integer, Abonent> abonents;

    public PhoneBook2(HashMap<Integer, Abonent> abonents)
    {
        setPhoneBook(abonents);
    }

    public Map<Integer, Abonent> getPhoneBook() { return abonents; }

    public void setPhoneBook(HashMap<Integer, Abonent> abonents) throws IllegalArgumentException {

        for (Integer key : abonents.keySet())
            if(key <= 0)
                throw new IllegalArgumentException("Invalid phone");

        this.abonents = abonents;
    }

    public void addAbonent(Integer phone, Abonent abonent) {

        if(phone <= 0)
            throw new IllegalArgumentException("Invalid phone");

        abonents.put(phone, abonent);
    }

    public Abonent getAbonent(Integer key)
    {
        return abonents.get(key);
    }

    public void delAbonent(Integer key) {

        if (abonents.containsKey(key))
            abonents.remove(key);
    }

    public static HashMap<Integer, Abonent> sortBySurname(PhoneBook2 ph) {

        List<Map.Entry<Integer, Abonent>> list = new ArrayList(ph.abonents.entrySet());

        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Abonent> abonent1, Map.Entry<Integer, Abonent> abonent2)
            {
                int comp = abonent1.getValue().compareTo(abonent2.getValue());
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        });

        HashMap<Integer, Abonent> sorted = new LinkedHashMap<>();
        for(Map.Entry<Integer, Abonent> entry : list)
        {
            sorted.put(entry.getKey(), entry.getValue());
        }
        return sorted;
    }

    public static void print(PhoneBook2 ph) {

        for(Map.Entry<Integer, Abonent> pair : ph.abonents.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        System.out.println();
    }
    public static void print(Map<Integer, Abonent> subs) {

        for(Map.Entry<Integer, Abonent> pair : subs.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        System.out.println();
    }
}
