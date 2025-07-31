//This program Insert the data using a PreparedStatement Interface
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
          // Statement statement = connection.createStatement();
           String query = "INSERT INTO students(name,age,marks) VALUES (?,?,?)";
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1,"Archana");
           preparedStatement.setInt(2,27);
           preparedStatement.setDouble(3,78.90);
           int rowsAffected = preparedStatement.executeUpdate();
           if(rowsAffected>0)
           {
                System.out.println("DATA Inserted successfully");
           }
           else
           {
               System.out.println("DATA Not Inserted");
           }

       }
       catch (SQLException e)
       {
           System.out.println(e.getMessage());
       }
    }
}
