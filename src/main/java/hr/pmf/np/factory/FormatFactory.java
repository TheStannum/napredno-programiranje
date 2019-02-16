package hr.pmf.np.factory;

import hr.pmf.np.factory.formats.PDFFormat;
import hr.pmf.np.factory.formats.PNGFormat;
import hr.pmf.np.factory.formats.TXTFormat;

import javax.swing.text.Document;
import java.util.NoSuchElementException;

public class FormatFactory {

    private FormatFactory() {
    }

    public static IDocumentFormat generateFormat(Document doc, Formats format) {
        switch (format) {
            case PDF:
                return new PDFFormat(doc);

            case TXT:
                return new TXTFormat(doc);

            case PNG:
                return new PNGFormat(doc);

            default:
                throw new NoSuchElementException("The specified format does " +
                        "not exist.");
        }
    }
}
