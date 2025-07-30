//Insert the data using JDBC Connection 
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
           String query=String.format("INSERT INTO students(name,age,marks) VALUES ('%s',%o,%f)","sahil",24,56.0);
           int rowsAffected = statement.executeUpdate(query);
           if(rowsAffected>0)
           {
               System.out.println("Data Inserted Successfully ");
           }
           else
           {
               System.out.println("Data Not Inserted ");
           }
       }
       catch (SQLException e)
       {
           System.out.println(e.getMessage());
       }

    }
}
