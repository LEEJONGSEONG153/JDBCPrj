package ex1;

import java.sql.*;

public class Program2 {
    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","lee","whdtjd89!");
        //Statement st = con.createStatement();
        String sql = "INSERT INTO studydb.notice" +
                "(TITLE" +
                ", WRITER_ID" +
                ", CONTENT" +
                ",  FILES)" +
                "values" +
                "(?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);

        String title = "title";
        String writerId = "newlec";
        String content = "dsfdsfdsvsdfsfvsdv";
        String files = "";

        st.setString(1,title);
        st.setString(2,writerId);
        st.setString(3,content);
        st.setString(4,files);
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
