import java.sql.*;
public class InsertRecords {
    public static void main(String[] args)throws Exception{
        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="1234";
        String sql="insert into students values (3,'Anand',99)";

        Connection con=DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection established");
        Statement st=con.createStatement();
        st.execute(sql);
        System.out.println("1 row inserted");

        st.close();
        con.close();
        System.out.println("Resources closed");
    }
}
