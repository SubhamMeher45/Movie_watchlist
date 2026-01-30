import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class movie 
{
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/movie";
        String user = "root";
        String pass = "subham45";
        try
        {
            Connection con=DriverManager.getConnection (url,user,pass);
            Scanner sc=new Scanner(System.in);
            String op="select * from watchlist";
            System.out.println("Enter movie name:");
            String mov=sc.next();
            System.out.println("Enter genre:");
            String gen=sc.next();
            System.out.println("Enter rating:");
            float rat=sc.nextFloat();
            System.out.println("Enter status:");
            String stat=sc.next();
            String query="insert into watchlist value(?,?,?,?)";
            PreparedStatement st=con.prepareStatement(query);
            st.setString(1,mov);
            st.setString(2,gen);
            st.setFloat(3,rat);
            st.setString(4,stat);
            ResultSet rs=st.executeQuery(query);
            while (rs.next()) 
            {
                System.out.println(op);
            }
            con.close();
            sc.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
