//This Program update the data using java JDBC but in this program we use PreparedStatement 
//example --->
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
           String query="UPDATE students SET name=? where id=?";
           PreparedStatement preparedStatement=connection.prepareStatement(query);
           preparedStatement.setString(1,"Swappy");
           preparedStatement .setInt(2,8);
           int rowsAffected = preparedStatement.executeUpdate();

           if(rowsAffected>0)
           {
                System.out.println("DATA Updated successfully");
           }
           else
           {
               System.out.println("DATA Not Updated");
           }

       }
       catch (SQLException e)
       {
           System.out.println(e.getMessage());
       }
    }
}
