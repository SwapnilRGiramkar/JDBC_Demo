//Delete the data into the database using prepared sttaemnt of JDBC API's
//example
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
          Connection connection=DriverManager.getConnection(url,username,password);
          String query="DELETE FROM students where id=?";
          PreparedStatement preparedStatement=connection.prepareStatement(query);
          preparedStatement.setInt(1,7);

          int rowsAffected=preparedStatement.executeUpdate();
           if(rowsAffected > 0)
           {
               System.out.println("DATA Deleted Successfully");
           }
           else
           {
               System.out.println("DATA Not Deleted");
           }

       }
       catch (SQLException e)
       {
           System.out.println(e.getMessage());
       }
    }
}
