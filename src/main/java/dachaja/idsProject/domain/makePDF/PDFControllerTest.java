package dachaja.idsProject.domain.makePDF;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.sql.*;
import java.awt.event.ActionEvent;

public class PDFControllerTest {

    Connection con;
    public PDFControllerTest(){
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
            con=DriverManager.getConnection(url, userid, pwd);
            System.out.println("데이터베이스 연결 성공");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void TableGenerate(){
        String query2="SELECT * FROM idsinfo"; /* SQL 문 */
        try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query2);

            while(rs.next()) {
                System.out.println(rs.getString(1));

            }
            con.close();
        } catch(SQLException k){
            k.printStackTrace();
        }
    }
}





