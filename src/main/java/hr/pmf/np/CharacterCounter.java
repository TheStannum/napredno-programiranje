package hr.pmf.np;

import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class CharacterCounter extends JLabel implements DocumentListener {

    private static final String COUNT_FORMAT = "words: %5d | characters: %5d";

    public CharacterCounter() {
        super();
        setText(String.format(COUNT_FORMAT, 0, 0));
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        update(documentEvent);
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        update(documentEvent);
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        update(documentEvent);
    }

    private void update(DocumentEvent event) {
        Document doc = event.getDocument();

        try {
            int characters = doc.getText(0, doc.getLength()).length();
            int words = doc.getText(0, doc.getLength()).split(" ").length;

            this.setText(String.format(COUNT_FORMAT, words, characters));
            this.repaint();
            this.updateUI();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
