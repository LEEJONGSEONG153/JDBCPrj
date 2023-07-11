package ex1;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;

import java.sql.*;
import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","lee","whdtjd89!");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from notice where hit>10");

        NoticeService service = new NoticeService();
        List<Notice> list = service.getList(1,"","");

//        while(rs.next()){
//            int id = rs.getInt("ID");
//            String title = rs.getString("TITLE");
//            String writerId = rs.getString("WRITER_ID");
//            Date regDate = rs.getDate("REG_DATE");
//            int hit = rs.getInt("hit");
//
//            System.out.printf("id : %d, title : %s, writerId : %s, regDate : %s, hit : %d\n",id,title,writerId,regDate,hit);
//        }
//        rs.close();
//        st.close();
//        con.close();


    }
}
