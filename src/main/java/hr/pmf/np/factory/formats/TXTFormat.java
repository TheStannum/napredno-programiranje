package hr.pmf.np.factory.formats;

import hr.pmf.np.factory.IDocumentFormat;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TXTFormat implements IDocumentFormat {

    private Document doc;

    public TXTFormat(Document doc) {
        this.doc = doc;
    }

    @Override
    public void write(String filePath) throws IOException {
        try {
            Files.write(Paths.get(filePath),doc.getText(0, doc.getLength()).getBytes());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Document getDocument() {
        return this.doc;
    }
}
