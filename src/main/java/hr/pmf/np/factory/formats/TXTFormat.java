package hr.pmf.np.factory.formats;

import hr.pmf.np.factory.IDocumentFormat;

import javax.swing.text.Document;

public class TXTFormat implements IDocumentFormat {

    private Document doc;

    public TXTFormat(Document doc) {
        this.doc = doc;
    }

    @Override
    public void write(String filePath) {

    }

    @Override
    public Document getDocument() {
        return this.doc;
    }
}
