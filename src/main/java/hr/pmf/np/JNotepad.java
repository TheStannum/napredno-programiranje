package hr.pmf.np;

import hr.pmf.np.actions.*;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JNotepad extends JFrame {

    private Document doc;

    private Action newAction;
    private Action OpenAction;
    private Action SaveAction;
    private Action SaveAsAction;
    private Action ExitAction;

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
    }

    private void createEditor(JPanel panel) {
        JTextArea area = new JTextArea();

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
        JMenu exportMenu = new JMenu("Export as:");

        JMenuItem asPDF = new JMenuItem("As PDF");
        exportMenu.add(asPDF);

        JMenuItem asPNG = new JMenuItem("As png");
        exportMenu.add(asPNG);

        JMenuItem asJPG = new JMenuItem("as jpg" );
        exportMenu.add(asJPG);


        return exportMenu;
    }

    private void createActions() {
        this.newAction = new NewAction("New", "Create new file...", this.doc);
        this.OpenAction = new OpenAction("Open new file", "Opens a new file...", this.doc);
        this.SaveAction = new SaveAction("Save file", "Save file on disk",this.doc);
        this.SaveAsAction = new SaveAsAction("Save file as","Choose how so save a file", this.doc);
        this.ExitAction = new ExitAction("Exit ", "Exit the program without saving",this.doc);

    }

    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem(this.newAction);
        fileMenu.add(newItem);



        JMenuItem openItem = new JMenuItem(this.OpenAction);
        fileMenu.add(openItem);



        JMenuItem saveItem = new JMenuItem(this.SaveAction);
        fileMenu.add(saveItem);

        JMenuItem saveAsItem = new JMenuItem(this.SaveAsAction);
        fileMenu.add(saveAsItem);

        JMenuItem exitItem = new JMenuItem(this.ExitAction);
        fileMenu.add(exitItem);

        return fileMenu;
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JNotepad().setVisible(true));
    }
}
