package hr.pmf.np.factory.formats;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import hr.pmf.np.factory.IDocumentFormat;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFFormat implements IDocumentFormat {

    private Document doc;

    public PDFFormat(javax.swing.text.Document doc) {
        this.doc = doc;
    }

    @Override
    public void write(String filePath) throws IOException {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document();

        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(document,
                    new FileOutputStream(filePath));

            document.open();

            Paragraph paragraph = new Paragraph();
            paragraph.add(doc.getText(0, doc.getLength()));

            document.add(paragraph);
            document.close();
        } catch (DocumentException e) {
            throw new IOException(e.getMessage());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Document getDocument() {
        return this.doc;
    }


}
