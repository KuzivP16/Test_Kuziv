

public interface Library {
    public void add(String author, String name);
    public void remove (String book_name);
    public void edit(String oldBook, String newBook);
    public void all_books();
}
