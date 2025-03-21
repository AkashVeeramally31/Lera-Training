import java.sql.*;

import static java.lang.Class.forName;

public class DemoJDBC {
    public static void main(String[] args) throws Exception{
        /*
            1)Import Packages
            2)Load and Register the driver
            3)Create connection
            4)Create Statement
            5)Execute query
            6)Process the results
            7)Close the resources
         */

        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="1234";
        String sql="select name from students where id=1";

        //In java 8 or above, we don't have to manually load the driver, java does automatically,
        // So the below is optional.
        //Load and Register the driver
        //Class.forName("org.postgresql.Driver");

        //Create connection
        Connection con=DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection established");

        //Create Statement
        Statement st= con.createStatement();

        //Execute query.
        ResultSet rs=st.executeQuery(sql);
        rs.next();// To go to the first row of a table, if rs.next() is not there it will throw an error.

        //Process the results
        String name=rs.getString("name");
        System.out.println(name);

        //Close the resources
        rs.close();
        st.close();
        con.close();
    }
}

