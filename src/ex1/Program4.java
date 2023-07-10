package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Program4 {
    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:33066/testdb","lee","whdtjd89!");
        //Statement st = con.createStatement();
        String sql = "delete from testdb.notice " +
                     "WHERE ID=?";
        PreparedStatement st = con.prepareStatement(sql);


        int id = 5;

        st.setInt(1,id);

        int result = st.executeUpdate();
        System.out.println(result);
//        while(rs.next()){
//            String id = rs.getString("id");
//            String pw = rs.getString("pw");
//            String name = rs.getString("name");
//            String email = rs.getString("email");
//            int hit = rs.getInt("hit");
//
//            //if(hit < 10) continue;
//
//            System.out.printf("id : %s, pw : %s, name : %s, email : %s, hit : %d\n",id,pw,name,email,hit);
//        }
        st.close();
        con.close();
    }
}
