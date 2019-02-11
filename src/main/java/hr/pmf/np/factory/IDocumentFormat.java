package hr.pmf.np.factory;

import javax.swing.text.Document;
import java.nio.file.Path;

public interface IDocumentFormat {


    void write(String filePath);

    Document getDocument();
}

