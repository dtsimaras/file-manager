package main.operations;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.Files.createDirectory;

/**
 * Create, delete, rename, move, copy Files
 */
public class FileOperations {

    public static boolean createFile(String filepath) {
        File file = new File(filepath);

        try {
            if (file.createNewFile()) {
                System.out.println("File Create: " + file.getAbsolutePath());
                return true;
            } else {
                System.out.println("File already exists.");
                return false;
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
            return false;
        }
    }

    public static boolean createDirectory(String dirPath) {
        File dir = new File(dirPath);

        if (dir.exists()) {
            System.out.println("Directory already exists.");
            return false;
        }

        if (dir.mkdir()) {
            System.out.println("Directory created: " + dir.getAbsolutePath());
            return true;
        } else {
            System.err.println("Failed to create directory.");
            return false;
        }
    }

    public static boolean delete (String path) {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File/Directory does not exist.");
            return false;
        }

        try {
            if (file.isDirectory()) {
                deleteRecursive(path);
            }
            if (file.delete()) {
                System.out.println("Deleted: " + file.getAbsolutePath());
                return true;
            } else {
                System.err.println("Failed to delete file.");
                return false;
            }
        } catch (SecurityException e) {
            System.err.println("Permission denied: " + e.getMessage());
            return false;
        }
    }

    private static boolean deleteRecursive(String path) {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File/Directory does not exist.");
            return false;
        }

        if (file.isDirectory()) {
            File[] contents = file.listFiles();
            if (contents != null) {
                for (File f : contents) {
                    deleteRecursive(f.getAbsolutePath());
                }
            }
        }

        if (file.delete()) {
            System.out.println("Deleted: " + file.getAbsolutePath());
            return true;
        } else {
            System.err.println("Failed to delete: " + file.getAbsolutePath());
            return false;
        }
    }


    public static boolean rename(String oldPath, String newPath) {
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);
        if (!oldFile.exists()) {
            System.err.println("File does not exist: " + oldPath);
            return false;
        }
        if (newFile.exists()) {
            System.err.println("Target name already exists: " + newPath);
            return false;
        }
        if (oldFile.renameTo(newFile)) {
            System.out.println("Renamed: " + newFile.getAbsolutePath());
            return true;
        } else {
            System.err.println("Failed to rename file.");
            return false;
        }
    }

    public static boolean copyFile(String sourcePath, String destPath) {
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destPath);
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied to: " + destination.toAbsolutePath());
            return true;
        } catch (NoSuchFileException e) {
            System.err.println("Source file does not exist.");
        } catch (FileAlreadyExistsException e) {
            System.err.println("Destination file already exists.");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
        return false;
    }

    public static boolean moveFile(String sourcePath, String destPath) {
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destPath);
        try {
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved to: " + destination.toAbsolutePath());
            return true;
        } catch (NoSuchFileException e) {
            System.err.println("Source file does not exist.");
        } catch (DirectoryNotEmptyException e) {
            System.err.println("Destination directory is not empty.");
        } catch (IOException e) {
            System.err.println("Error moving file: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");

        createFile("test.txt");
        createDirectory("new_folder");
        rename("test.txt", "renamed.txt");
        copyFile("renamed.txt", "copy_of_renamed.txt");
        moveFile("copy_of_renamed.txt", "new_folder/moved_file.txt");
        createDirectory("../testDir");
        createFile("../testDir/this_file.md");
        deleteRecursive("../testDir");
        delete("renamed.txt");
        //delete("new_folder/moved_file.txt");
        deleteRecursive("new_folder");
    }
}
