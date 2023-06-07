package dachaja.idsProject.domain.makePDF.AllDataTest;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableBody;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.*;

@Service
public class AllDataGenerateService {
    Connection con = null;
    public void export(HttpServletResponse response) throws IOException, DocumentException {



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

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph emptyLine = new Paragraph("\n");

        Paragraph paragraph = new Paragraph("DACHJA REPORT", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(18);

        Paragraph paragraph2 = new Paragraph("Recent intrusion information", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(emptyLine);
        document.add(paragraph2);
        document.add(emptyLine);

        String queryTotal="SELECT COUNT(*) FROM idsinfo"; /* SQL 문 */
        try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(queryTotal);
            if (rs.next()) { // 현재 행으로 이동
                int totalCount = rs.getInt(1); // 첫 번째 컬럼의 값을 가져옴
                Paragraph info1 = new Paragraph("Total number (in 2 weeks): " + totalCount);
                document.add(info1);
            }
        } catch(SQLException k){
            k.printStackTrace();
        }

        String queryMal="SELECT COUNT(*) FROM idsinfo where Label = 'Malicious'"; /* SQL 문 */
        try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(queryMal);
            if (rs.next()) { // 현재 행으로 이동
                int totalCount = rs.getInt(1); // 첫 번째 컬럼의 값을 가져옴
                Paragraph info2 = new Paragraph("Malicious: " + totalCount);
                document.add(info2);
            }
        } catch(SQLException k){
            k.printStackTrace();
        }


        document.add(emptyLine);
        document.add(emptyLine);

        //table 만들기
        String query="SELECT * FROM idsinfo"; /* SQL 문 */
        try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);

            while(rs.next()) {
                PdfPTable table = new PdfPTable(2);

                table.addCell("ID");
                table.addCell(rs.getString(1));

                table.addCell("Source IP");
                //table.addCell(rs.getString(2));
                table.addCell("123.123.0.0");

                table.addCell("Destination IP");
                table.addCell(rs.getString(3));

                table.addCell("Source Port");
                table.addCell(rs.getString(4));

                table.addCell("Destination Port");
                table.addCell(rs.getString(5));

                table.addCell("Protocol");
                table.addCell(rs.getString(6));

                table.addCell("Time Stamp(Occur time)");
                table.addCell(rs.getString(7));

                table.addCell("Flow Duration");
                table.addCell(rs.getString(8));

                table.addCell("Label");
                table.addCell(rs.getString(9));

                table.addCell("Tot Fwd Pkts");
                table.addCell(rs.getString(11));

                table.addCell("Tot Bwd Pkts");
                table.addCell(rs.getString(12));

                table.addCell("TotLen Fwd Pkts");
                table.addCell(rs.getString(13));

                table.addCell("TotLen Bwd Pkts");
                table.addCell(rs.getString(14));

                table.addCell("Fwd Pkt Len Max");
                table.addCell(rs.getString(15));

                table.addCell("Fwd Pkt Len Min");
                table.addCell(rs.getString(16));

                table.addCell("Fwd Pkt Len Mean");
                table.addCell(rs.getString(17));

                table.addCell("Fwd Pkt Len Std");
                table.addCell(rs.getString(18));

                table.addCell("Bwd Pkt Len Max");
                table.addCell(rs.getString(19));

                table.addCell("Bwd Pkt Len Min");
                table.addCell(rs.getString(20));

                table.addCell("Bwd Pkt Len Mean");
                table.addCell(rs.getString(21));

                table.addCell("Bwd Pkt Len Std");
                table.addCell(rs.getString(22));

                table.addCell("Flow Byts/s");
                table.addCell(rs.getString(23));

                table.addCell("Flow Pkts/s");
                table.addCell(rs.getString(24));

                table.addCell("Flow IAT Mean");
                table.addCell(rs.getString(25));

                table.addCell("Flow IAT Std");
                table.addCell(rs.getString(26));

                table.addCell("Flow IAT Max");
                table.addCell(rs.getString(27));

                table.addCell("Flow IAT Min");
                table.addCell(rs.getString(28));


                table.addCell("Pkt Len Min");
                table.addCell(rs.getString(29));


                table.addCell("Pkt Len Max");
                table.addCell(rs.getString(30));

                table.addCell("Pkt Len Mean");
                table.addCell(rs.getString(31));

                table.addCell("Pkt Len Std");
                table.addCell(rs.getString(32));

                table.addCell("Pkt Len Var");
                table.addCell(rs.getString(33));

                table.addCell("FIN Flag Cnt");
                table.addCell(rs.getString(34));

                table.addCell("SYN Flag Cnt");
                table.addCell(rs.getString(35));

                table.addCell("RST Flag Cnt");
                table.addCell(rs.getString(36));

                table.addCell("PSH Flag Cnt");
                table.addCell(rs.getString(37));

                table.addCell("Active Mean");
                table.addCell(rs.getString(38));

                table.addCell("Active Std");
                table.addCell(rs.getString(39));

                table.addCell("Active Max");
                table.addCell(rs.getString(40));

                table.addCell("Active Min");
                table.addCell(rs.getString(41));


                document.add(table);
                document.add(emptyLine);

            }
            con.close();
        } catch(SQLException k){
            k.printStackTrace();
        }


        document.close();
    }
}
