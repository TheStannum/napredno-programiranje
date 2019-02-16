package hr.pmf.np.actions;

import javax.naming.Name;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenAction extends AbstractNotepadAction {

    public OpenAction(String name, String desc, Document doc) {

        super(name, desc, doc);
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Only .txt files", "txt");

        chooser.setFileFilter(filter);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String filePath = chooser.getSelectedFile().getAbsolutePath().toString();

            try {
                String text = new String(Files.readAllBytes(Paths.get(filePath)));

                this.doc.insertString(0, text, null);
            } catch (Exception e1) {
                e1.printStackTrace();

            }
        }

    }
}