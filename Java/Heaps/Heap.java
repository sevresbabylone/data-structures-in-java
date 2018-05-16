// Array-based heap

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int max) {
        maxSize = max;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }
    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }
    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        // keep moving parent nodes down while parent is less than inserted node OR have reached the top node
        while (index > 0 && heapArray[index].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }
//    public Node remove() {
//
//    }
    public void trickleDown(int index) {

    }
    public void displayHeap() {
        System.out.print("heapArray:");
        for (int m = 0; m < currentSize; m++) {
            if (heapArray[m] != null) {
                System.out.print(heapArray[m].getKey() + " ");
            }
            else {
                System.out.print("--");
            }
        }
        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;

        while (currentSize > 0) {
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize)
                break;
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            }
            else {
                for (int k = 0; k < nBlanks*2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }
    }
}