import java.util.*;

public class Library {

    private Map<Integer, Book> catalog;

    public Library(HashMap<Integer, Book> catalog)
    {
        setCatalog(catalog);
    }

    public Map<Integer, Book> getCatalog() { return catalog; }

    public void setCatalog(HashMap<Integer, Book> catalog) throws IllegalArgumentException {

        for (Integer key : catalog.keySet())
            if(key <= 0)
                throw new IllegalArgumentException("Invalid index");

        this.catalog = catalog;
    }

    public List<Integer> findByFullName(String full_name)
    {
        List<Integer> indexes = new ArrayList<>();
        for(Map.Entry<Integer, Book> item : catalog.entrySet()){

            if(item.getValue().getFullName().equals(full_name));
                indexes.add(item.getKey());
        }
        return indexes;
    }
    public List<Integer> findByPublishingHouse(String publishing_house)
    {
        List<Integer> indexes = new ArrayList<>();
        for(Map.Entry<Integer, Book> item : catalog.entrySet()){

            if(item.getValue().getPublishingHouse().equals(publishing_house));
                indexes.add(item.getKey());
        }
        return indexes;
    }
    public List<Integer> findByPublishingYear(int publishing_year)
    {
        List<Integer> indexes = new ArrayList<>();
        for(Map.Entry<Integer, Book> item : catalog.entrySet()){

            if(item.getValue().getPublishingYear() == publishing_year);
                indexes.add(item.getKey());
        }
        return indexes;
    }
    public List<Integer> findByPrice(int price)
    {
        List<Integer> indexes = new ArrayList<>();
        for(Map.Entry<Integer, Book> item : catalog.entrySet()){

            if(item.getValue().getPrice() == price);
                indexes.add(item.getKey());
        }
        return indexes;
    }

    public static HashMap<Integer, Book> sortByFullName(Library lib) {

        List<Map.Entry<Integer, Book>> list = new ArrayList(lib.catalog.entrySet());

        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Book> book1, Map.Entry<Integer, Book> book2)
            {
                int comp = book1.getValue().compareTo(book2.getValue());
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        });

        HashMap<Integer, Book> sorted = new LinkedHashMap<>();
        for(Map.Entry<Integer, Book> entry : list)
        {
            sorted.put(entry.getKey(), entry.getValue());
        }
        return sorted;
    }

    public boolean isUnique(Book book)
    {
        Set<Book> treeSet = new TreeSet<Book>(catalog.values());
        return treeSet.add(book);
    }

    public static void print(Library lib) {

        for(Map.Entry<Integer, Book> pair : lib.catalog.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        System.out.println();
    }
}
