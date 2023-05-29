/*
package dachaja.idsProject.domain.makePDF.Controller;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.annotation.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;

@RestController
@RequestMapping("/api/pdf")
public class PDFController {

    private DataSource dataSource;

    @GetMapping("/generate")
    public ResponseEntity<Resource> generatePDF() throws IOException, DocumentException, SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM idsinfo")) {

       //
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);

            document.open();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                StringBuilder rowData = new StringBuilder();
                for (int i = 1; i <= columnCount; i++) {
                    if (i > 1) {
                        rowData.append(" - ");
                    }
                    rowData.append(resultSet.getString(i));
                }
                Paragraph paragraph = new Paragraph(rowData.toString());
                document.add(paragraph);
            }
            document.close();

            byte[] bytes = outputStream.toByteArray();
            ByteArrayResource resource = new ByteArrayResource(bytes);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .contentLength(bytes.length)
                    .body(resource);
        }
    }
}
*/
