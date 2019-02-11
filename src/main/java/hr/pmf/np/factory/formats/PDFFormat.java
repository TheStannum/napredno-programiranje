package hr.pmf.np.factory.formats;

import hr.pmf.np.factory.IDocumentFormat;

import javax.swing.text.Document;

public class PDFFormat implements IDocumentFormat {

    private Document doc;

    public PDFFormat(Document doc) {
        this.doc = doc;
    }

    @Override
    public void write(String filePath) {
        // TODO
    }

    @Override
    public Document getDocument() {
        return this.doc;
    }


}
