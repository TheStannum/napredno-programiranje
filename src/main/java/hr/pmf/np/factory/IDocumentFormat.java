package hr.pmf.np.factory;

import javax.swing.text.Document;
import java.io.IOException;
import java.nio.file.Path;

public interface IDocumentFormat {


    void write(String filePath) throws IOException;

    Document getDocument();
}

