package hr.pmf.np.factory.formats;
import java.io.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.util.jar.JarFile;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;


import hr.pmf.np.factory.IDocumentFormat;

public class PDFFormat implements IDocumentFormat {

    private javax.swing.text.Document doc;

    public PDFFormat(javax.swing.text.Document doc) {
        this.doc = doc;
    }

    @Override
    public void write(String filePath) {

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("ExportedPDF.pdf"));
            document.open();
            document.add(new Paragraph(doc.getText(0, doc.getLength())));
            document.close();
            writer.close();
        }
        catch (DocumentException | FileNotFoundException | BadLocationException de) {
            de.printStackTrace();
        }


    }

    @Override
    public javax.swing.text.Document getDocument() {
        return this.doc;
    }


}
