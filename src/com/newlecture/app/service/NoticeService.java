package com.newlecture.app.service;

import com.newlecture.app.entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {

    private String url = "jdbc:mariadb://localhost:3306/studydb";
    private String user_id = "lee";
    private String user_pw = "whdtjd89!";
    private String driver = "org.mariadb.jdbc.Driver";

    public List<Notice> getList(int page, String field, String query) throws SQLException, ClassNotFoundException {

//        int start = 1+(page-1)*10;
//        int end = 10*page;
        int pagePerNum = 10;
        int start = (page-1)*10;

//        String sql = "        select * from(" +
//                            "                SELECT (@rownum := @rownum + 1) AS rownum," +
//                            "                        notice.*" +
//                            "                FROM  notice,(select @rownum := 0) as rn" +
//                            "                order   by  REG_DATE desc) a" +
//                            "        where rownum between  ? and ?";
        String sql = "select * from notice where "+ field+" LIKE ? order by reg_date desc" +
                      "        limit ? offset ?;";


        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user_id,user_pw);
        //Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,query.equals("") ?"%":"%"+query+"%");
        st.setInt(2,pagePerNum);
        st.setInt(3,start);
        ResultSet rs = st.executeQuery();

        List<Notice> list = new ArrayList<>();

        while(rs.next()){
            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String content = rs.getString("CONTENT");
            String writerId = rs.getString("WRITER_ID");
            Date regDate = rs.getDate("REG_DATE");
            int hit = rs.getInt("hit");
            String files = rs.getString("FILES");

            Notice notice = new Notice(id, title, content, writerId, regDate, hit, files);

            list.add(notice);

            //System.out.printf("id : %d, title : %s, writerId : %s, regDate : %s, hit : %d\n",id,title,writerId,regDate,hit);
        }
        rs.close();
        st.close();
        con.close();

        return list;
    }

    //Scalar 값을 얻는 함수 : 단일 값을 얻는 함수
    public int getCount() throws ClassNotFoundException, SQLException {

        int count = 0;

        String sql = "select count(ID) count from notice";


        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user_id,user_pw);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        List<Notice> list = new ArrayList<>();

        while(rs.next()){
            count = rs.getInt("COUNT");
        }
        rs.close();
        st.close();
        con.close();


        return count;
    }

    public int insert(Notice notice) throws ClassNotFoundException, SQLException {

        String title = notice.getTitle();
        String writerId = notice.getTitle();
        String content = notice.getContent();
        String files = notice.getFiles();

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user_id,user_pw);

        String sql = "INSERT INTO notice" +
                "(TITLE" +
                ", WRITER_ID" +
                ", CONTENT" +
                ",  FILES)" +
                "values" +
                "(?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1,title);
        st.setString(2,writerId);
        st.setString(3,content);
        st.setString(4,files);
        int result = st.executeUpdate();

        st.close();
        con.close();

        return result ;
    }

    public int update(Notice notice) throws ClassNotFoundException, SQLException {

        String title = notice.getTitle();
        String content = notice.getContent();
        String files = notice.getFiles();
        int id = notice.getId();

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user_id,user_pw);

        String sql = "UPDATE studydb.notice " +
                "SET    TITLE = ?  ," +
                "       CONTENT = ?," +
                "       FILES = ?   " +
                "WHERE  ID = ?";
        PreparedStatement st = con.prepareStatement(sql);


        st.setString(1,title);
        st.setString(2,content);
        st.setString(3,files);
        st.setInt(4,id);
        int result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }

    public int delete(int id) throws SQLException, ClassNotFoundException {

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user_id,user_pw);

        String sql = "delete from studydb.notice " +
                "WHERE ID=?";
        PreparedStatement st = con.prepareStatement(sql);

        st.setInt(1,id);

        int result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }


}
