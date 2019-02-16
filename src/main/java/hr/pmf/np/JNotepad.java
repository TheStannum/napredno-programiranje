package hr.pmf.np;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class JNotepad extends JFrame {

    private Document doc;

    public JNotepad() {
        setTitle("Jnotepad");
        setSize(800, 600);
        setLocation(100, 100);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        initGUI();
    }

    private void initGUI() {
        createMenu();

        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        createEditor(mainPanel);
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

        menuBar.add(createFileMenu());
    }

    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        fileMenu.add(newItem);

        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);

        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);

        JMenuItem saveAsItem = new JMenuItem("Save as");
        fileMenu.add(saveAsItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        return fileMenu;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JNotepad().setVisible(true));
    }
}
