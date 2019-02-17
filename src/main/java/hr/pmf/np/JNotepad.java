package hr.pmf.np;

import hr.pmf.np.actions.*;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;

public class JNotepad extends JFrame {

    private Document doc;

    private Action newAction;
    private Action openAction;
    private Action saveAction;
    private Action saveAsAction;
    private Action exitAction;
    private Action exportAction;

    public JNotepad() {
        setTitle("Jnotepad");
        setSize(800, 600);
        setLocation(100, 100);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Lijepši pregled "New"
        }


        initGUI();
    }

    private void initGUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        createEditor(mainPanel);

        createMenu();

        DocumentListener counter = new CharacterCounter();
        this.doc.addDocumentListener(counter);

        mainPanel.add((Component) counter, BorderLayout.SOUTH);
    }

    private void createEditor(JPanel panel) {
        JTextArea area = new JTextArea();
        area.setLineWrap(true);

        area.setBackground(Color.DARK_GRAY);
        area.setForeground(Color.LIGHT_GRAY);
        area.setFont(new Font("consolas", Font.PLAIN, 20));

        area.setCaretColor(Color.WHITE);

        this.doc = area.getDocument();
        panel.add(new JScrollPane(area));
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        createActions();

        menuBar.add(createFileMenu());
        menuBar.add(createExportMenu());
    }

    private JMenu createExportMenu() {


        JMenu exportMenu = new JMenu("Export");

        JMenuItem asPDF = new JMenuItem(exportAction);
        asPDF.setActionCommand("pdf");
        asPDF.setText("as .pdf");
        exportMenu.add(asPDF);

        JMenuItem asPNG = new JMenuItem(exportAction);
        asPNG.setActionCommand("png");
        asPNG.setText("as .png");
        exportMenu.add(asPNG);

        JMenuItem asTXT = new JMenuItem(exportAction);
        asTXT.setActionCommand("txt");
        asTXT.setText("as .txt");
        exportMenu.add(asTXT);


        return exportMenu;
    }

    private void createActions() {
        this.newAction = new NewAction("New", "Create new file...", this.doc);
        this.openAction = new OpenAction("Open new file", "Opens a new file...", this.doc);
        this.saveAction = new SaveAction("Save file", "Save file on disk", this.doc);
        this.saveAsAction = new SaveAsAction("Save file as", "Choose how so save a file", this.doc);
        this.exitAction = new ExitAction("Exit ", "Exit the program without saving", this.doc);
        this.exportAction = new ExportAction("Export", "Export the file with " +
                "specified format", this.doc);
    }

    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem(this.newAction);
        fileMenu.add(newItem);


        JMenuItem openItem = new JMenuItem(this.openAction);
        fileMenu.add(openItem);


        JMenuItem saveItem = new JMenuItem(this.saveAction);
        fileMenu.add(saveItem);

        JMenuItem saveAsItem = new JMenuItem(this.saveAsAction);
        fileMenu.add(saveAsItem);

        JMenuItem exitItem = new JMenuItem(this.exitAction);
        fileMenu.add(exitItem);

        return fileMenu;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JNotepad().setVisible(true));
    }
}
