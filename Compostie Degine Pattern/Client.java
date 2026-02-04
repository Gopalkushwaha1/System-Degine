import java.util.*;

// Component
interface FileSystemItem {
    int getSize();
}

// Leaf
class File implements FileSystemItem {
    private int size;

    File(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

// Composite
class Folder implements FileSystemItem {
    private List<FileSystemItem> items = new ArrayList<>();

    public void addItem(FileSystemItem item) {
        items.add(item);
    }

    public int getSize() {
        int totalSize = 0;
        for (FileSystemItem item : items) {
            totalSize += item.getSize();
        }
        return totalSize;
    }
}

// Client
class Client {
    public static void main(String[] args) {

        System.out.println("=== Composite Design Pattern Demo ===");

        FileSystemItem file1 = new File(20);
        FileSystemItem file2 = new File(10);

        Folder documents = new Folder();
        documents.addItem(file1);
        documents.addItem(file2);

        Folder rootFolder = new Folder();
        rootFolder.addItem(documents);
        rootFolder.addItem(new File(30));

        System.out.println("Total size of root folder: " + rootFolder.getSize());
    }
}
