package ru.chigaev;

/**
 * Created by vaso on 07.04.2016.
 */
import java.sql.*;

public class JdbcTutor {
    /**
     * Please rename DB_NAME to your name, for example
     * static final String DB_NAME="VladimirSonkin";
     */
    static final String DB_NAME="test";

    Connection conn;

    public static void main(String[] a) {
        JdbcTutor t = null;
        try {
            t = new JdbcTutor();

            /**
             * Create table and Insert can be executed only once!
             */
            t.dropTableNames();  // drop table if it already exist
            t.createTableNames();
            t.addName(1, "Andrew");
            t.addName(2, "George");
            t.addName(3, "Maria");
            t.addName(4, "Vladimir");

            /**
             * Read data from table - you can run it every time
             */
            t.printNames();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            t.closeConnection();
        }
    }

    public JdbcTutor() {
        openConnection();
    }

    public Connection openConnection() {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.
                    getConnection("jdbc:h2:~/IdeaProjects/spb16/vasiliy/BankApplication/data/"+DB_NAME,
                            "sa", // login
                            "" // password
                    );
            return conn;
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTableNames() throws SQLException {
        String sql = "DROP TABLE IF EXISTS NAMES";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void createTableNames() throws SQLException {
        String sql = "CREATE TABLE NAMES " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255)," +
                " PRIMARY KEY ( id ))";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void addName(int id, String val) throws SQLException {
        String sql = "INSERT INTO NAMES(id,name) " +
                "VALUES("+id+",'"+val+"') ";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void printNames() throws SQLException {
        try {
            // 1) Create statement
            Statement stmt = conn.createStatement();
            String sql = "SELECT id, name FROM NAMES ";
            // 2) Execute query and get the ResultSet
            ResultSet rs = stmt.executeQuery(sql);

            // Iterate over results and print it
            while(rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                String name = rs.getString("name");

                // Display data
                System.out.print("ID: " + id + ", ");
                System.out.print("Name: " + name + "\n");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}


