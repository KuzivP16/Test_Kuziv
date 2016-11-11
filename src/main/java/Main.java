import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleLibraryManaging consoleLibraryManaging = new ConsoleLibraryManaging();

        Scanner in = new Scanner(System.in);
        String c;
        while (true) {
            c = in.nextLine().toLowerCase();
            if(c.startsWith("add book")){
                String name = c.substring(c.indexOf('"')+1,c.lastIndexOf('"'));
                String author = c.substring(8,c.indexOf('"'));
                name.replace("\"","");
                consoleLibraryManaging.add(author,name);
                System.out.println("book"+author +" " +name + " was added ");

            }else if(c.startsWith("remove")){
               String name = c.substring(7,c.length());
                consoleLibraryManaging.remove(name);
                System.out.println("book " + name + " was removed ");

            }else if(c.startsWith("edit book")){
                int i1 = c.indexOf('"');
                int i2 = c.indexOf('"', i1+1);
                int i3 = c.indexOf('"', i2+1);
                int i4 = c.indexOf('"', i3+1);
                String book1 = c.substring(i1+1, i2);
                String book2 = c.substring(i3+1,i4);
                consoleLibraryManaging.edit(book1,book2);

            }else if (c.startsWith("all books")){
                consoleLibraryManaging.all_books();
            }
            else {
                System.out.println("Try again");
            }
        }
    }
}
