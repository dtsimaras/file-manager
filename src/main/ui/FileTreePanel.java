package main.ui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;

public class FileTreePanel extends JPanel {
    private final JTree fileTree;
    private final DefaultMutableTreeNode rootNode;

    public FileTreePanel() {
        setLayout(new java.awt.BorderLayout());

        File root = new File(System.getProperty("user.home"));
        rootNode = new DefaultMutableTreeNode(root);
        fileTree = new JTree(rootNode);
        loadFileTree(root, rootNode);

        JScrollPane scrollPane = new JScrollPane(fileTree);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadFileTree(File directory, DefaultMutableTreeNode parentNode) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(file);
                parentNode.add(node);
                if (file.isDirectory()) {
                    loadFileTree(file, node);
                }
            }
        }
    }

    public void refresh() {
        rootNode.removeAllChildren();
        loadFileTree((File) rootNode.getUserObject(), rootNode);
        ((DefaultTreeModel) fileTree.getModel()).reload();
    }

    public JTree getFileTree() {
        return fileTree;
    }

}
