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
                table.addCell(rs.getString(2));

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

/*                table.addCell("");
                table.addCell(rs.getString(1));*/

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
