import java.util.Objects;

/**
 * Class intended to store data about a library book. Class extends Book.
 */
public class LibraryBook extends Book {

    private static int count = 0;
    private int id;
    private String tooker;

    LibraryBook(String title, int publishingYear, int edition, int numOfPages, String tooker ,String... authors) throws IllegalAccessException {
        super(title,publishingYear,edition,numOfPages,authors);
        setTooker(tooker);
        this.id = ++count;
    }

    public void setTooker(String tooker) throws IllegalAccessException {
        if(tooker == null || tooker.trim().isEmpty())
            throw new IllegalAccessException("Invalid tooker");
        this.tooker = tooker;
    }
    public String getTooker() {  return tooker; }

    @Override
    public String toString() {
        StringBuilder allAuthors = new StringBuilder();
        for (String author : getAuthors())
            allAuthors.append(author).append(", ");
        return String.format("id: %d \ntitle: \"%s\" \nauthors: %s " +
                        "\npages: %d \npublishing year: %d \nedition: %d copies \nuser: %s",
                id, getTitle(), allAuthors, getNumOfPages(), getPublishingYear(), getEdition(), tooker);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        LibraryBook compObj = (LibraryBook) obj;
        return id == compObj.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
