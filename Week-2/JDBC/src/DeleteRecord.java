import java.sql.*;

public class DeleteRecord {
    public static void main(String[] args)throws Exception{
        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="1234";
        String sql="delete from students where id=3";

        Connection con= DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection established");
        Statement st=con.createStatement();
        st.execute(sql);
        System.out.println("1 row deleted");

        st.close();
        con.close();
        System.out.println("Resources closed");
    }
}
