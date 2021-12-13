public class Book implements Comparable<Book> {

    private String full_name;
    private String publishing_house;
    private int publishing_year;
    private float price;

    public Book(String full_name, String publishing_house, int publishing_year, float price)
    {
        setFullName(full_name);
        setPublishingHouse(publishing_house);
        setPublishingYear(publishing_year);
        setPrice(price);
    }

    public String getFullName() { return full_name; }

    public void setFullName(String full_name) throws IllegalArgumentException {
        if(full_name == null || full_name.trim().isEmpty())
            throw new IllegalArgumentException("Invalid full name");
        this.full_name = full_name;
    }
    public String getPublishingHouse() { return publishing_house; }

    public void setPublishingHouse(String publishing_house) throws IllegalArgumentException {
        if(publishing_house == null || publishing_house.trim().isEmpty())
            throw new IllegalArgumentException("Invalid publishing house");
        this.publishing_house = publishing_house;
    }
    public int getPublishingYear() { return publishing_year; }

    public void setPublishingYear(int publishing_year) throws IllegalArgumentException {
        if(publishing_year <= 0 || publishing_year >= 2022)
            throw new IllegalArgumentException("Invalid publishing year");
        this.publishing_year = publishing_year;
    }
    public float getPrice() { return price; }

    public void setPrice(float price) throws IllegalArgumentException {
        if(price <= 0.0)
            throw new IllegalArgumentException("Invalid price");
        this.price = price;
    }

    @Override
    public int compareTo(Book book) {
        return this.full_name.compareTo(book.full_name);
    }

    @Override
    public String toString() {
        return String.format("[Author: %s, publishing house: %s, year of publishing %d, price: %f]",
                full_name, publishing_house, publishing_year, price);
    }
}
