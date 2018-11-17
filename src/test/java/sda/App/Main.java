package sda.App;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class Main {
    static String currentuser = "";

    public static void main(String args[]) {
        String userchoice = "";
        while (true) {
            Scanner sc = new Scanner(System.in);
            String current = ">>>MySqlProject>" + userchoice + ">" + currentuser + ">";
            System.out.print(">>>MySqlProject>");
            System.out.println("Tastati \"create\",\"login\",\"logout\" sau \"exit\"");
            System.out.print(current);
            while (true) {
                userchoice = sc.next().toLowerCase();
                if (userchoice.contains("'")) {
                    System.out.println("Nope, retry");
                    continue;
                } else break;
            }
            current = ">>>MySqlProject>" + userchoice + ">";
            System.out.println(current);
            switch (userchoice) {
                case ("create"):
                    try {
                        DemoLogin app = new DemoLogin();
                        app.register(createUser());

                    } catch (SQLIntegrityConstraintViolationException e) {
                        System.out.println(current);
                        System.out.println("Username already existing");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println(current);
                        System.out.println("Startup failed");

                    }
                    break;
                case ("login"):
                    try {
                        int i = 0;
                        DemoLogin app = new DemoLogin();
                        if (app.login()) {
                            current = ">>>MySqlProject>" + userchoice + ">" + currentuser + ">";
                        } else break;

                    } catch (SQLIntegrityConstraintViolationException e) {
                        System.out.println(current);
                        System.out.println("Username already existing");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println(current);
                        System.out.println("Startup failed");

                    }
                    break;
                case ("logout"):
                    current = ">>>MySqlProject>";
                    currentuser = "";
                    break;
                case ("exit"):
                    System.out.println("Ati iesit din MySqlProject");
                    System.exit(1);
                    break;
            }
        }

    }

    private static User createUser() {
        String username;
        String password;
        String email;
        Scanner sc = new Scanner(System.in);
        System.out.print(">>>MySqlProject>create>");
        System.out.println("Tastati username");
        while (true) {
            username = sc.next();
            if (username.contains("'")) {
                System.out.println("Nope, retry");
                continue;
            } else break;
        }
        System.out.print(">>>MySqlProject>create>");
        System.out.println("Tastati password");
        while (true) {
            password = sc.next();
            if (username.contains("'")) {
                System.out.println("Nope, retry");
                continue;
            } else break;
        }
        System.out.print(">>>MySqlProject>create>");
        System.out.println("Tastati email");
        while (true) {
            email = sc.next();
            if (username.contains("'")) {
                System.out.println("Nope, retry");
                continue;
            } else break;
        }
        User user = new User(username, email, password);
        return user;
    }
}
