package hr.pmf.np.actions;

import javax.swing.*;
import javax.swing.text.Document;

public abstract class AbstractNotepadAction extends AbstractAction {

    protected Document doc;

    public AbstractNotepadAction(String name, String desc, Document doc){
        putValue(Action.NAME, name);
        putValue(Action.SHORT_DESCRIPTION, desc);

        this.doc = doc;
    }
}
