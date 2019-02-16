package hr.pmf.np.actions;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;

public class NewAction extends AbstractNotepadAction {

    public NewAction(String name, String desc, Document doc){
        super(name, desc, doc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO provjera sadrzaja

        try {
            this.doc.remove(0, this.doc.getLength());
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }
}
