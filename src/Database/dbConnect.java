package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbConnect {
    private String user = "postgres";
    private String pass = "040205";

    public Connection connect_to_db() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RPG", user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public void createCharacterTable() {
        Connection conn = connect_to_db();
        if (conn != null) {
            try {
                String createTableSQL = "CREATE TABLE IF NOT EXISTS characters " +
                        "(id SERIAL PRIMARY KEY, " +
                        "name VARCHAR(255), " +
                        "character_class VARCHAR(255), " +
                        "state VARCHAR(255), " +
                        "ability VARCHAR(255))";
                PreparedStatement preparedStatement = conn.prepareStatement(createTableSQL);
                preparedStatement.execute();
                preparedStatement.close();
                conn.close();
                System.out.println("Table 'characters' created successfully.");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    public void insertCharacter(String name, String characterClass, String state, String ability) {
        Connection conn = connect_to_db();
        if (conn != null) {
            try {
                String insertSQL = "INSERT INTO characters (name, character_class, state, ability) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, characterClass);
                preparedStatement.setString(3, state);
                preparedStatement.setString(4, ability);
                preparedStatement.execute();
                preparedStatement.close();
                conn.close();
                System.out.println("Character data inserted successfully.");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public String getCharacterState(String name) {
        return null;
    }
}
