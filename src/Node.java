import java.util.Arrays;

public class Node {
    public int size; // field to hold the number of added elements
    public Integer[] elements;
    public Node next;

    /**
     * Constructor for objects of class Node.
     * @param arrSize The actual size of the holding array.
     */
    public Node(int arrSize) {
        size = 0;
        elements = new Integer[arrSize];
        next = null;
    }

    @Override
    public String toString() {
        Integer[] usedSpaces = new Integer[size];
        for(int i = 0; i < size; i++) {
            usedSpaces[i] = elements[i];
        }
        return Arrays.toString(usedSpaces);
    }
}
