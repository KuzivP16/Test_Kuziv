import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ConsoleLibraryManaging implements Library {


    public void add(String author, String name) {
        TestDB testDB = new TestDB();
        try {
            Statement statement = testDB.connection.createStatement();
            String addSql = "INSERT INTO library (author, name) VALUES ('" + author+"', '"+ name + "')";
            statement.executeUpdate(addSql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void remove(String book_name) {
        TestDB testDB = new TestDB();
        String query = "SELECT COUNT(name) FROM library WHERE name = '"+book_name + "'";
        try {
            Statement statement = testDB.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            int c = resultSet.getInt(1);
            if (c <2){
                String removeSql = "DELETE FROM library WHERE name = '" + book_name + "'";
                statement.executeUpdate(removeSql);
            }
            else {
                System.out.println("we have few books with such name please choose one by typing a number of book:");
                String q = "SELECT * FROM library  WHERE name = '"+ book_name +"'";
                resultSet = statement.executeQuery(q);
                while (resultSet.next()){
                    System.out.println(resultSet.getString(1)+ " " + resultSet.getString(2)+ " " + resultSet.getString(3) );
                }
                Scanner sc = new Scanner(System.in);
                int i = sc.nextInt() ;
                String removeSql = "DELETE FROM library WHERE name = '" + book_name + "' AND id_library = "+ i ;
                statement.executeUpdate(removeSql);
                statement.close();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void all_books() {
        TestDB myDBconn = new TestDB();
        String query = "SELECT author, name FROM library  ORDER BY name ";
        try {
            Statement statement = myDBconn.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println(" Our books : ");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+ " " + resultSet.getString(2));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(){
        TestDB testDB = new TestDB();
        String createSql = "create table library (id_library int (10) AUTO_INCREMENT,"
                +"author  varchar(30) NOT NULL," +
                "name  varchar(30) NOT NULL,PRIMARY KEY (id_library) )";
        try {
            Statement statement = testDB.connection.createStatement();
            statement.executeUpdate(createSql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(String oldBook, String newBook) {
        TestDB testDB = new TestDB();
        String query = "SELECT COUNT(name) FROM library WHERE name = '"+oldBook + "'";
        try {
            Statement statement = testDB.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            int c = resultSet.getInt(1);
            if (c <2){
                String editSql = "UPDATE library SET name = '" + newBook + "' WHERE name = '" + oldBook + "' ";
                statement.executeUpdate(editSql);
            }
            else {
                System.out.println("we have few books with such name please choose one by typing a number of book:");
                String q = "SELECT * FROM library  WHERE name = '"+ oldBook +"'";
                resultSet = statement.executeQuery(q);
                while (resultSet.next()){
                    System.out.println(resultSet.getString(1)+ " " + resultSet.getString(2)+ " " + resultSet.getString(3) );
                }
                Scanner sc = new Scanner(System.in);
                int i = sc.nextInt() ;
                String editSql = "UPDATE library SET name = '" + newBook + "' WHERE name = '" + oldBook + "' AND id_library = "+ i ;
                statement.executeUpdate(editSql);
                statement.close();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
