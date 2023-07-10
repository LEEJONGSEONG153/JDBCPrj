package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","lee","whdtjd89!");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from member where hit>10");

        while(rs.next()){
            String id = rs.getString("id");
            String pw = rs.getString("pw");
            String name = rs.getString("name");
            String email = rs.getString("email");
            int hit = rs.getInt("hit");

            //if(hit < 10) continue;

            System.out.printf("id : %s, pw : %s, name : %s, email : %s, hit : %d\n",id,pw,name,email,hit);
        }
        rs.close();
        st.close();
        con.close();

//        CREATE TABLE `notice` (
//  `ID` int(11) NOT NULL AUTO_INCREMENT,
//  `TITLE` varchar(100) NOT NULL,
//  `WRITER_ID` varchar(50) NOT NULL,
//  `CONTENT` mediumtext DEFAULT NULL,
//  `REG_DATE` varchar(100) NOT NULL DEFAULT current_timestamp(),
//  `HIT` int(11) NOT NULL DEFAULT 0,
//  `FILES` varchar(1000) DEFAULT NULL,
//  `PUB` varchar(100) NOT NULL DEFAULT '0',
//                PRIMARY KEY (`ID`)
//) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
    }
}
