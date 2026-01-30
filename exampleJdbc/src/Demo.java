import java.sql.*;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws SQLException {
//        String sql="select name from users where id=2";
//        String url="jdbc:postgresql://localhost:5432/postgres";
//        String username="postgres";
//        String password="postgres";
//        Connection con= DriverManager.getConnection(url ,username , password);
//        Statement st=con.createStatement();
//        ResultSet rs=st.executeQuery(sql);
//
//        rs.next();
//        String name=rs.getString(1);
//        System.out.println(name);
//        con.close();
        String sql="select name from users where id=?";
        String url="jdbc:postgresql://localhost:5432/postgres";
        String username="postgres";
        String password="postgres";
        try(
                Scanner sc=new Scanner(System.in);
                Connection con=DriverManager.getConnection(url,username,password);
                PreparedStatement st=con.prepareStatement(sql);
        ){
            System.out.print("Enter user id: ");
            int userId = sc.nextInt();   // dynamic input

            st.setInt(1, userId);        // bind value to ?

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                System.out.println("User name: " + name);
            } else {
                System.out.println("User not found");
            }
        }



    }
}
