package dachaja.idsProject.domain.makePDF.Controller;

import com.itextpdf.text.DocumentException;
import dachaja.idsProject.domain.makePDF.IdsInfo;
import dachaja.idsProject.domain.makePDF.IdsInfoRepository;
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
/*
    @Autowired
    IdsInfoRepository idsInfoRepository;

    @GetMapping(value = "/pdf/idsInfo", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> idsInfoReport() throws IOException{
        List<IdsInfo> idsInfos = (List<IdsInfo>) IdsInfoRepository.findAll();
    }
*/

    private final PDFGeneratorService pdfGeneratorService;

    public PDFExportController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormat.format(new Date());



        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_"+currentDateTime+".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfGeneratorService.export(response);



    }
}
