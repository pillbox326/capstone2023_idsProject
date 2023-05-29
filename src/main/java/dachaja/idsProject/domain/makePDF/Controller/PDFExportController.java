/*
package dachaja.idsProject.domain.makePDF.Controller;

import com.itextpdf.text.DocumentException;
import dachaja.idsProject.domain.makePDF.Service.PDFGeneratorService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PDFExportController {
    private final PDFGeneratorService pdfGeneratorService;

    public PDFExportController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @Controller
    public class PDFExportController {

        private final PDFGeneratorService pdfGeneratorService;

        public PDFExportController(PDFGeneratorService pdfGeneratorService) {
            this.pdfGeneratorService = pdfGeneratorService;
        }

        @GetMapping("/pdf/generate")
        public void generatePDF(HttpServletResponse response) throws IOException {
            response.setContentType("application/pdf");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
            response.setHeader(headerKey, headerValue);

            this.pdfGeneratorService.export(response);
        }
}
*/
