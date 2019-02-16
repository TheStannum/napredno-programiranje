package hr.pmf.np.actions;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;

public class ExitAction extends AbstractNotepadAction {

    public ExitAction(String name, String desc, Document doc) {

        super(name, desc, doc);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        System.exit(0);
    }
}
