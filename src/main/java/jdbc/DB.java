package jdbc;

import practice.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/user_info";
    private final String DB_USER = "postgres";
    private final String DB_PASSWORD = "admin";
    private Connection connection;

    public DB() {
        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close(){
        if (connection!= null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteUserById(int id){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM users WHERE id = "+id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {//переписать в одну строчку
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO users(first_name, last_name, email)" +
                            "VALUES ('"
                            + user.getFirstName() + "', '"
                            + user.getLastName() + "', '"
                            + user.getEmail() + "')"
            );
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
