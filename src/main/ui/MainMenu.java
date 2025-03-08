package main.ui;

import main.operations.FileOperations;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionListener;
import java.io.File;

final class MainMenu {

    private final FileTreePanel fileTreePanel;

    MainMenu(FileTreePanel fileTreePanel) {
        this.fileTreePanel = fileTreePanel;
    }

    // Creates and returns the main menu bar
    public JMenuBar createMainMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        JMenu newFileMenu = new JMenu("New");
        JMenuItem newFile = new JMenuItem("File");
        JMenuItem newDirectory = new JMenuItem("Directory");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");

        newFile.addActionListener(e -> createFile());

        exitItem.addActionListener(e -> System.exit(0));

        // Adding submenu to "File"
        newFileMenu.add(newFile);
        newFileMenu.add(newDirectory);
        fileMenu.add(newFileMenu);
        fileMenu.addSeparator();
        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        // Adding menus to the menu bar
        menuBar.add(fileMenu);
        //menuBar.add(editMenu);
        //menuBar.add(helpMenu);

        return menuBar;
    }

    private void createFile() {
        File selectedDirectory = getSelectedFile();

        if (selectedDirectory == null || !selectedDirectory.isDirectory()) {
            JOptionPane.showMessageDialog(this, "Please select a folder to create a file in.");
            return;
        }

        String fileName = JOptionPane.showInputDialog(this, "Enter file name:");
        if (fileName != null && !fileName.trim().isEmpty()) {
            boolean success = FileOperations.createFile(selectedDirectory.getAbsolutePath(), fileName);
            refreshTree();
        } else {
            JOptionPane.showMessageDialog(this, "File creation failed.");
        }
    }

    private void deleteFile() {
        File selectedFile = getSelectedFile();
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "Please select a file or folder to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + selectedFile.getName() + "?");
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = FileOperations.deleteFile(selectedFile);
            if (success) {
                JOptionPane.showMessageDialog(this, "Deleted successfully.");
                refreshTree();
            } else {
                JOptionPane.showMessageDialog(this, "Deletion failed.");
            }
        }
    }

    private File getSelectedFile() {
        TreePath selectionPath = fileTreePanel.getFileTree().getSelectionPath();
        if (selectionPath == null) return null;

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
        return (File) selectedNode.getUserObject();
    }

    private void refreshTree() {
        fileTreePanel.refresh();
    }
}
