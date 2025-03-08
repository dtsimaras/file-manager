package main;

import main.ui.FileManagerGUI;

import javax.swing.*;

public class FileManager extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FileManagerGUI app = new FileManagerGUI();
            app.setVisible(true);
        });
        System.out.println("Hello World");
    }
}
