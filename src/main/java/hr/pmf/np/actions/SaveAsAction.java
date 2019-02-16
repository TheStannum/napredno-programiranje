package hr.pmf.np.actions;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SaveAsAction extends AbstractNotepadAction {
    private static final String UNTITLED = "Untitled";

    private String fileName;

    public SaveAsAction(String name, String desc, Document doc) {
        super(name, desc, doc);

        this.fileName = UNTITLED;
    }

    public void actionPerformed(ActionEvent e) {

            JFileChooser chooser = new JFileChooser(".");

            int filesave = chooser.showSaveDialog(null);
            if (filesave == JFileChooser.APPROVE_OPTION) {
                try {
                    String filePath = chooser.getSelectedFile().toPath().toAbsolutePath().toString();

                    if (Files.exists(Paths.get(filePath))) {
                        int reply = JOptionPane.showConfirmDialog(null, "File already exists," +
                                "overwrite?", "Overwrite", JOptionPane.YES_NO_OPTION);

                        if (reply == JOptionPane.YES_OPTION) {
                            saveFile(filePath, this.doc.getText(0, doc.getLength()));
                        }
                    }

                    saveFile(filePath, this.doc.getText(0, doc.getLength()));
                } catch (Exception el) {
                    el.printStackTrace();
                }
            }
        }



    private void saveFile (String filePath, String text){
        try {
            Files.write(Paths.get(filePath), text.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

