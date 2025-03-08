package main.ui;

import main.FileManager;
import main.operations.FileOperations;

import javax.swing.*;
import java.io.File;

public class FileManagerController {
    private FileManagerGUI view;
    private FileOperations model;

    public FileManagerController(FileManagerGUI view, FileOperations model) {
        this.view = view;
        this.model = model;
        setupListeners();
    }

    private void setupListeners() {
        view.getMainMenu().setCreateFileListener(e -> createFile());
        ///...
    }

    private void createFile() {
        File selectedFolder = view.getSelectedFile();
        if (selectedFolder != null) {
            String fileName = JOptionPane.showInputDialog(view, "Enter file name:");
            if (fileName != null && !fileName.trim().isEmpty()) {
                boolean success = model.createFile(selectedFolder.getAbsolutePath(), fileName);
                if (success) {
                    view.refreshTree();
                }
            }
        }
    }

    private void deleteFile() {
        File selectedFile = view.getSelectedFile();
        if (selectedFile != null) {
            int confirm = JOptionPane.showConfirmDialog(view, "Are you sure you want to delete " + selectedFile.getName() + "?");
            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = model.delete(selectedFile);
                if (success) {
                    view.refreshTree();
                }
            }
        }
    }
}
