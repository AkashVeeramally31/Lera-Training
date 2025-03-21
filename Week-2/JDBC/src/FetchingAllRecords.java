import java.sql.*;

public class FetchingAllRecords {
    public static void main(String[] args) throws Exception{
        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="1234";
        String sql="select * from students";

        Connection con= DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection established");

        Statement st= con.createStatement();

        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){
            System.out.println(rs.getInt("id")+" "
                              +rs.getString("name")+" "
                              +rs.getInt("marks"));
        }

        //Also we can print using column index
//        while(rs.next()){
//            System.out.println(rs.getInt(1)+" "
//                    +rs.getString(2)+" "
//                    +rs.getInt(3));
//        }

        rs.close();
        st.close();
        con.close();
        System.out.println("Resources closed");
    }
}
