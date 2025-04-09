
package model;
import java.sql.*;
/**
 *
 * @author Avishka Chamod
 */
public class MySQL {
    
    private static Connection connection;
    
    public static void createConnection() throws Exception{
     Class.forName("com.mysql.cj.jdbc.Driver");
     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarym", "", ""); //password and username
    }
    
    public static ResultSet exeSearch(String query) throws Exception{
        createConnection();
        return connection.createStatement().executeQuery(query);
    }
    
    public static Integer exeUpdate(String query) throws Exception{
        createConnection();
        return connection.createStatement().executeUpdate(query);
    }
    
}
