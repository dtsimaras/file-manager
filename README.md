# File Manager & Search Tool  

## Overview  
The **File Manager & Search Tool** is a Java-based application designed to provide file operations, advanced search capabilities, file viewing/editing, and security features. It is built using **Java Core concepts**, including **I/O, NIO, multithreading, security, and design patterns**.  

---

## Functional Requirements  

### 1. File Operations  
- Create, delete, rename files and folders.  
- Copy, move, and paste files between directories.  
- Display file properties (**size, last modified date, type**).  

### 2. File Searching  
- Search by **name, extension, date modified, and size**.  
- Implement both **recursive search** (within subdirectories) and **non-recursive search**.  
- Use **multithreading** for faster searches.  

### 3. File Viewing & Editing  
- Open text files within the application.  
- Allow **basic editing** (e.g., Notepad-like functionality).  

### 4. Security Features  
- Prevent **unauthorized access** (set file permissions).  
- **Encrypt/decrypt** sensitive files.  
- Implement a **log system** to track user operations.  

### 5. (Optional) Remote File Management  
- Connect to another computer via **sockets** and transfer files.  

---

## Design Instructions  

### **Architecture Overview**  
- **UI (Optional)**: Java **Swing** for a graphical interface.  
- **Core Logic**: Java **I/O, NIO, and Multithreading** for efficient file operations.  
- **Security Layer**: Permissions + encryption.  
- **Logging System**: `java.util.logging` for tracking operations.  

### **Design Patterns to Use**  
1. **Singleton** → Manage a global file system instance.  
2. **Factory Pattern** → Create objects for file operations dynamically.  
3. **Observer Pattern** → UI updates when files change (if using Swing/JavaFX).  

---

## **Technology Stack**  
- **Java SE 8+** (Core Java, Multithreading, File I/O)  
- **Java Swing** (Optional UI)  
- **Java NIO** (Efficient File Handling)  
- **Cryptography API** (For encryption)  
- **Sockets** (For remote file management)  
- **java.util.logging** (For tracking user operations)  

---

## **Installation & Setup**  
1. **Clone the repository:**  
   ```sh
   git clone https://github.com/dtsimaras/file-manager.git
   cd file-manager
   ```
2. **Compile the project:**
   ```sh
   javac -d bin src/**/*.java ```
3. **Run the application**
    ```sh
   java -cp bin Main ```
