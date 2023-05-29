/*
package dachaja.idsProject.domain.makePDF.Service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dachaja.idsProject.domain.makePDF.FlowDB.FlowData;
import dachaja.idsProject.domain.makePDF.FlowDB.FlowRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class PDFGeneratorService {
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("This is a title.", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("This is a paragraph.", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(paragraph2);
        document.close();
    }
}

*/
/*@Service
public class PDFGeneratorService {
    private final FlowRepository flowRepository;
    @Autowired
    public PDFGeneratorService(FlowRepository flowRepository){
        this.flowRepository = flowRepository;

    }

    public void export(HttpServletResponse response) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream()); // document, where

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.COURIER); //폰트 종류 -> 수정하기
        fontTitle.setSize(20);

        Paragraph paragraph = new Paragraph("IDS Project DACHAJA", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("Group 11 : DACHAJA");
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;
    }

*//*
*/
/*
*//*

*/
/*
        //cell 안에 넣을 ids information -> 가장 최신의 benign이 아닌 데이터가 담기도록 설정해둠
       // List<String> dbInfo = idsInfoRepository.IdsInfo();



        cell = new PdfPCell(new Phrase("IDS Information"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("id");
        //table.addCell(String.valueOf(dbInfo.get(0)));
        table.addCell("---");

        table.addCell("Source IP");
        table.addCell("---");

        table.addCell("Destination IP");
        table.addCell("---");

        table.addCell("Source Port");
        table.addCell("---");

        table.addCell("Destination Port");
        table.addCell("---");

        table.addCell("Protocol");
        table.addCell("---");

        table.addCell("Time Stamp");
        table.addCell("---");

        table.addCell("Flow Duration");
        table.addCell("---");

        table.addCell("Label");
        table.addCell("---");


        document.add(paragraph);
        document.add(paragraph2);
        document.add(table);
        document.close();

    }*//*
*/
/*
*//*

*/
/*


}*//*
*/
/*

*/
