import java.util.Objects;

/**
 * Class intended to store data about a book
 */

public class Book {

    private String title;
    private String[] authors;
    private int publishingYear, edition, numOfPages;
    
    public Book(String title, int publishingYear, int edition, int numOfPages, String... authors) throws IllegalAccessException {
        setTitle(title);
        setPublishingYear(publishingYear);
        setEdition(edition);
        setNumOfPages(numOfPages);
        setAuthors(authors);
    }
    Book() {}

    public void setTitle(String title) throws IllegalAccessException {
        if(title == null || title.trim().isEmpty())
            throw new IllegalAccessException("Empty title");
        this.title = title;
    }
    public String getTitle() { return title; }

    public void setAuthors(String ... authors) throws IllegalAccessException {
        for (String author: authors)
            if(author == null || author.trim().isEmpty())
                throw new IllegalAccessException("Empty author");
        this.authors = authors;
    }
    public String[] getAuthors() { return authors; }

    public void setPublishingYear(int publishingYear) throws IllegalAccessException {
        if(publishingYear <= 0)
            throw new IllegalAccessException("Invalid year");
        this.publishingYear = publishingYear;
    }
    public int getPublishingYear() { return publishingYear; }

    public void setEdition(int edition) throws IllegalAccessException {
        if(edition <= 0)
            throw new IllegalAccessException("Invalid edition");
        this.edition = edition;
    }
    public int getEdition() { return edition; }

    public void setNumOfPages(int numOfPages) throws IllegalAccessException {
        if(numOfPages <= 0)
            throw new IllegalAccessException("Invalid numOfPages");
        this.numOfPages = numOfPages;
    }
    public int getNumOfPages() { return numOfPages; }

    @Override
    public String toString() {
        StringBuilder allAuthors = new StringBuilder();
        for (String author : authors)
            allAuthors.append(author).append(", ");
        return String.format("title: \"%s\" \nauthors: %s \npages: %d \npublishing year: %d \nedition: %d copies",
                title, allAuthors, numOfPages, publishingYear, edition);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book compObj = (Book) obj;
        return publishingYear == compObj.publishingYear && edition == compObj.edition &&
                numOfPages == compObj.numOfPages && Objects.equals(title, compObj.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publishingYear, edition, numOfPages);
    }
}
