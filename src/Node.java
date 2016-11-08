import java.util.Arrays;

/**
 * Created by Nikola on 31/10/2016.
 */
public class Node {
    public int size;
    public int[] elements;
    public Node next;

    public Node(int arrSize) {
        size = 0;
        elements = new int[arrSize];
        next = null;
    }

    @Override
    public String toString() {
        int[] used = new int[size];
        for(int i = 0; i < size; i++) {
            used[i] = elements[i];
        }
        return Arrays.toString(used);
    }
}
