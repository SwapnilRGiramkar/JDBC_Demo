//Using PreparedStatement we retrieve the data from the database 
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
          String query="SELECT name FROM students WHERE id=?";
          PreparedStatement preparedStatement=connection.prepareStatement(query);
          preparedStatement.setInt(1,8);
          ResultSet resultSet=preparedStatement.executeQuery();
           if(resultSet.next())
           {
                String name=resultSet.getString("name");
                System.out.println("name: "+name);
           }
           else
           {
               System.out.println("Name Not Found ");
           }

       }
       catch (SQLException e)
       {
           System.out.println(e.getMessage());
       }
    }
}
