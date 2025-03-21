import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DropTable {
    public static void main(String[] args)throws Exception{
        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="1234";
        String sql="drop table students";

        Connection con= DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection established");
        Statement st=con.createStatement();
        st.execute(sql);
        System.out.println("Table dropped");

        st.close();
        con.close();
        System.out.println("Resources closed");
    }
}
