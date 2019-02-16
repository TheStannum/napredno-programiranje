package hr.pmf.np.factory.formats;

import hr.pmf.np.factory.IDocumentFormat;

import javax.swing.text.Document;

public class PNGFormat implements IDocumentFormat {

    private Document doc;

    public PNGFormat(Document doc) {
        this.doc = doc;
    }

    @Override
    public void write(String filePath) {
        // TODO
    }

    @Override
    public Document getDocument() {
        return null;
    }

}
