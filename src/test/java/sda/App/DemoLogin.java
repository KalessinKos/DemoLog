package sda.App;

import java.sql.SQLException;

public class DemoLogin implements LogInCapable {

    private MySQLHandler sql;

    DemoLogin() throws SQLException {
        sql = new MySQLHandler();
    }

    public boolean register(User x) {
        return sql.addUser(x);
    }

    public boolean login() {
        return sql.loginAttempt();
    }

    public boolean logout() {
        return false;
    }
}
