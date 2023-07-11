package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Program3 {
    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","lee","whdtjd89!");
        //Statement st = con.createStatement();
        String sql = "UPDATE studydb.notice " +
                     "SET    TITLE = ?  ," +
                     "       CONTENT = ?," +
                     "       FILES = ?   " +
                     "WHERE  ID = ?";
        PreparedStatement st = con.prepareStatement(sql);

        String title = "수정 제목이오";
        String content = "수정 컨텐트입니다용!!";
        String files = "";
        int id = 3;

        st.setString(1,title);
        st.setString(2,content);
        st.setString(3,files);
        st.setInt(4,id);
        int result = st.executeUpdate();
        System.out.println(result);

        st.close();
        con.close();
    }
}
