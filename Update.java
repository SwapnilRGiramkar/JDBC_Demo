//This program update the database using JDBC java command
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
           String query = String.format("UPDATE students SET name = '%s'  WHERE id=%d ","Aditya",6);
           int rowsAffected = statement.executeUpdate(query);
           if(rowsAffected>0)
           {
                System.out.println("Student updated successfully");
           }
           else
           {
               System.out.println("Student update failed");
           }

       }
       catch (SQLException e)
       {
           System.out.println(e.getMessage());
       }

    }
}
