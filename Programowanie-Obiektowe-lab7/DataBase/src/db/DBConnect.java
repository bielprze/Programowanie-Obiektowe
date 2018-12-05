package db;

import java.sql.*;

public class DBConnect {

    public static Connection DBConnector() {
        try {
            Connection con;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl:3306/pbieleck","pbieleck","NHb06YJw982o9k9u");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}