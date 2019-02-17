package zavrsni;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EditorTests {

    @Test
    public void testPDF() throws FileNotFoundException {
        System.out.println(System.getProperty("user.dir"));
        com.itextpdf.text.Document document = new com.itextpdf.text.Document();

        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(document,
                    new FileOutputStream("src/res/test/HelloWorld.pdf"));

            document.open();

            Paragraph paragraph = new Paragraph();
            paragraph.add("Hello World!");

            document.add(paragraph);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
