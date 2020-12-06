package Java_Homework_4;

public class Book {
    private int numberOfPages;
    private String title;
    private String author;
    private int yearOfPublishing;


    public Book(int numberOfPages, String title, String author, int yearOfPublishing) {
        setNumberOfPages(numberOfPages);
        setTitle(title);
        setAuthor(author);
        setYearOfPublishing(yearOfPublishing);
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        if (numberOfPages < 1) {
            return;
        }
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length() < 1) {
            return;

        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.length() < 1) {
            return;
        }
        this.author = author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        if (yearOfPublishing > 2020) {
            return;
        }
        this.yearOfPublishing = yearOfPublishing;
    }

    public void details() {
        System.out.println(author + "'s '" + title + "', published on " + yearOfPublishing +
                ": " + numberOfPages + " pages.");
        ;
    }
}
