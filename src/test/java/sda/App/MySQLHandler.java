package sda.App;

import java.sql.*;
import java.util.Scanner;

import static sda.App.Main.currentuser;

class MySQLHandler {
    private Connection dbConnection;

    boolean addUser(User user) {
        System.out.println("Tastati Username");
        String sqlCmd =
                "INSERT INTO users(username,passsword,email)" +
                "VALUES('" + user.username + "','" + user.passsoword + "','" + user.email + "')";
        try {
            Statement statement = dbConnection.createStatement();
            return statement.execute(sqlCmd);

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Username already existing");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Startup failed");

        }
        return false;
    }

    boolean loginAttempt() {
        Scanner sc = new Scanner(System.in);
        System.out.print(">>>MySqlProject>login>");
        System.out.println(" Tastati username");
        System.out.print(">>>MySqlProject>login>");
        String username = sc.next();
        currentuser=username;
        System.out.print(">>>MySqlProject>login>");
        System.out.println(" Tastati password");
        System.out.print(">>>MySqlProject>login>");
        String pwd = sc.next();
        String sqlCmd =
                "SELECT username,passsword " +
                "FROM demologin.users " +
                "WHERE username = '" + username + "' " +
                "AND passsword ='" + pwd + "'";
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCmd);

            if (resultSet.next()) {
                System.out.println("Te-ai logat");
                return true;
            } else {
                System.out.println("Username sau paroala gresita");
                currentuser="";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    MySQLHandler() throws SQLException {
        dbConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demologin"
                , "root"
                , "admin");
    }
}
