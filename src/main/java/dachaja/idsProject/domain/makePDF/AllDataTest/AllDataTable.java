package dachaja.idsProject.domain.makePDF.AllDataTest;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AllDataTable {

    Connection con;

    public AllDataTable(){
        String Driver="";
        String url="jdbc:mysql://localhost:3306/capstone2023?&serverTimezone=Asia/Seoul";
        String userid="root";
        String pwd="9631";

        try { /* 드라이버를 찾는 과정 */
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로드 성공");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try { /* 데이터베이스를 연결하는 과정 */
            System.out.println("데이터베이스 연결 준비...");
            con= DriverManager.getConnection(url, userid, pwd);
            System.out.println("데이터베이스 연결 성공");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void makeTable(Document document) throws DocumentException {
        Paragraph test = new Paragraph("THis is test paragraph");

        document.add(test);
    }
}
