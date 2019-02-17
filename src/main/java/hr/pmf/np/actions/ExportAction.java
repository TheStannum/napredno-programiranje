package hr.pmf.np.actions;

import hr.pmf.np.factory.FormatFactory;
import hr.pmf.np.factory.Formats;
import hr.pmf.np.factory.IDocumentFormat;

import javax.swing.JFileChooser;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class ExportAction extends AbstractNotepadAction {

    public ExportAction(String name, String desc, Document doc) {
        super(name, desc, doc);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String actionName = actionEvent.getActionCommand().toUpperCase();
        JFileChooser chooser = new JFileChooser(".");

        if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            String filePath = chooser.getSelectedFile().getAbsolutePath();

            IDocumentFormat format = FormatFactory.generateFormat(this.doc,
                    Formats.valueOf(actionName));

            try {
                format.write(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
