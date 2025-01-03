package apitesting.LibMS.models;

public class Book {
    private Integer id;
    private String title;
    private String author;
    public Book(){}
    public Book(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public void setId(final Integer id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return " { " +
                "\"id\": " + this.id + ",\n" +
                "\"title\": \"" + this.title + "\",\n" +
                "\"author\": \"" + this.author + "\"\n" +
                "}";
    }
}