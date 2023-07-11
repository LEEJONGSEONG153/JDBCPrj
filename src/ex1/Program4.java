package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Program4 {
    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","lee","whdtjd89!");
        //Statement st = con.createStatement();
        String sql = "delete from studydb.notice " +
                     "WHERE ID=?";
        PreparedStatement st = con.prepareStatement(sql);


        int id = 3;

        st.setInt(1,id);

        int result = st.executeUpdate();
        System.out.println(result);

        st.close();
        con.close();
    }
}
