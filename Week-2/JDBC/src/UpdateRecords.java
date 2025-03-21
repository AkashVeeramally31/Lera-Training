import java.sql.*;
public class UpdateRecords {
    public static void main(String[] args)throws Exception{
        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="1234";
        String sql="update students set marks=100 where id=2";

        Connection con=DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection established");
        Statement st=con.createStatement();
        st.execute(sql);
        System.out.println("1 row updated");

        st.close();
        con.close();
        System.out.println("Resources closed");
    }
}
