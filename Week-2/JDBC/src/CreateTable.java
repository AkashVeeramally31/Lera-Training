import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args)throws Exception{
        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="1234";
//        String sql="CREATE TABLE students ("
//                + "id INTEGER NOT NULL, "
//                + "name TEXT, "
//                + "marks INTEGER, "
//                + "CONSTRAINT students_pkey PRIMARY KEY (id))";

        //Also written as
        String sql = """
                    CREATE TABLE students (
                        id INTEGER PRIMARY KEY, 
                        name TEXT, 
                        marks INTEGER
                    )""";

        Connection con= DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection established");
        Statement st=con.createStatement();
        st.execute(sql);
        System.out.println("Table created");

        st.close();
        con.close();
        System.out.println("Resources closed");
    }
}
