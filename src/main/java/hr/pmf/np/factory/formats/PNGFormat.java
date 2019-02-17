package hr.pmf.np.factory.formats;

import hr.pmf.np.factory.IDocumentFormat;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.text.Document;
import java.awt.image.BufferedImage;
import java.io.File;

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
        return doc;
    }

    private BufferedImage getScreenShot(JComponent component) {

        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
        // paints into image's Graphics
        component.paint(image.getGraphics());
        return image;
    }

    private void getSaveSnapShot(JComponent component, String fileName) throws Exception {
        BufferedImage img = getScreenShot(component);
        // write the captured image as a PNG
        ImageIO.write(img, "png", new File(fileName));
    }
}
