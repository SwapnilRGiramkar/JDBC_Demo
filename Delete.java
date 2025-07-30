//This program delete the entry in database using JDBC java Program
import java.sql.*;
public class Main
{
    private static final String url="jdbc:mysql://localhost:3306/mydb";
    private static final String username="root";
    private static final String password="Swap@123";
    public static void main(String[] args)
    {
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");

       }
       catch(ClassNotFoundException e)
       {
           System.out.println(e.getMessage());
       }

       try
       {
           Connection connection =DriverManager.getConnection(url,username,password);
           Statement statement = connection.createStatement();
           String query = "DELETE FROM students WHERE id=6";
           int rowsAffected = statement.executeUpdate(query);
           if(rowsAffected>0)
           {
                System.out.println("DATA Deleted successfully");
           }
           else
           {
               System.out.println("DATA Deletion failed");
           }

       }
       catch (SQLException e)
       {
           System.out.println(e.getMessage());
       }

    }
}
