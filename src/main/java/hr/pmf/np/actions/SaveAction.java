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

public class SaveAction extends AbstractNotepadAction {

    private static final String UNTITLED = "Untitled";

    private String fileName;

    public SaveAction (String name, String desc, Document doc) {
        super(name, desc, doc);

        this.fileName = UNTITLED;
    }

    public void actionPerformed (ActionEvent e) {
        if(this.fileName.equals(UNTITLED)){
            JFileChooser chooser = new JFileChooser(".");

            int filesave = chooser.showSaveDialog(null);
            if (filesave ==JFileChooser.APPROVE_OPTION){
                try{
                    String filePath = chooser.getSelectedFile().toPath().toAbsolutePath().toString();

                    if(Files.exists(Paths.get(filePath))){
                        int reply = JOptionPane.showConfirmDialog(null, "File already exists," +
                                "overwrite?", "Overwrite", JOptionPane.YES_NO_OPTION);

                        if(reply == JOptionPane.YES_OPTION){
                            saveFile(filePath, this.doc.getText(0, doc.getLength()));
                        }
                    }

                    saveFile(filePath, this.doc.getText(0, doc.getLength()));
                }
                catch (Exception el){
                    el.printStackTrace();
                }
            }
        } else{
            try {
                saveFile(fileName, this.doc.getText(0, doc.getLength()));
            } catch (BadLocationException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void saveFile(String filePath, String text){
        try {
            Files.write(Paths.get(filePath), text.getBytes());
            this.fileName = filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
