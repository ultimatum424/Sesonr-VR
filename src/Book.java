import java.util.Date;

public class Book {
    private String title;
    private String author;
    private int numberOfPages;
    private Date date;
    private boolean isNewBook;

    public Book(String title, String author, int numberOfPages, Date date, boolean isNewBook) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.date = date;
        this.isNewBook = isNewBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isNewBook() {
        return isNewBook;
    }

    public void setNewBook(boolean newBook) {
        isNewBook = newBook;
    }

    @Override
    public String toString() {
        String isNewString;
        if (isNewBook){
            isNewString = "YES";
        } else {
            isNewString = "NO";
        }
        return "<tr><td>"
                + title + "</td><td>"
                + author + "</td><td>"
                + numberOfPages + "</td><td>"
                + date + "</td><td>"
                + isNewString + "</td></tr>";

    }
}
