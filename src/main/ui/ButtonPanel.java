package main.ui;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private final JButton createFileBtn;
    private final JButton createFolderBtn;
    private final JButton renameBtn;
    private final JButton deleteBtn;
    private final JButton copyBtn;
    private final JButton moveBtn;

    public ButtonPanel() {
        setLayout(new FlowLayout());

        createFileBtn = new JButton("Create File");
        createFolderBtn = new JButton("Create Folder");
        renameBtn = new JButton("Rename");
        deleteBtn = new JButton("Delete");
        copyBtn = new JButton("Copy");
        moveBtn = new JButton("Move");

        add(createFileBtn);
        add(createFolderBtn);
        add(renameBtn);
        add(deleteBtn);
        add(copyBtn);
        add(moveBtn);
    }

    public JButton getCreateFileBtn() { return createFileBtn; }
    public JButton getCreateFolderBtn() { return createFolderBtn; }
    public JButton getRenameBtn() { return renameBtn; }
    public JButton getDeleteBtn() { return deleteBtn; }
    public JButton getCopyBtn() { return copyBtn; }
    public JButton getMoveBtn() { return moveBtn; }
}
