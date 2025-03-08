package main.ui;

import javax.swing.*;
import java.awt.*;

public class FileManagerGUI extends JFrame {
    private FileTreePanel fileTreePanel;
    private MainMenu mainMenu;

    public FileManagerGUI() {
        setTitle("File Manager");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        fileTreePanel = new FileTreePanel();
        mainMenu = new MainMenu(fileTreePanel);

        setJMenuBar(mainMenu.createMainMenuBar());
        add(fileTreePanel, BorderLayout.CENTER);
    }
}
