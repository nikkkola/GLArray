/**
 * Created by Nikola on 31/10/2016.
 */
public class GLArray {
    public static int length(Node n) {
        if(n == null) {
            return 0;
        }
        return n.size + length(n.next);
    }

    public static int get(Node n, int index) throws EndOfListException {
        if(n != null && index < n.size) {
            return n.elements[index];
        }
        if(n == null) {
            throw new EndOfListException("You've reached the end of the list.");
        }
        return get(n.next, index - n.size);
    }

    public static void add(Node n, Integer i) {
        while(n.next != null && n.size >= n.elements.length) {
            n = n.next;
        }

        if(n.size < n.elements.length) {
            n.elements[n.size] = i;
            n.size++;
        }
        else {
            Node newNode = new Node(n.size*2);
            newNode.elements[0] = i;
            newNode.size++;
            n.next = newNode;
        }
    }

    public static void main(String[] args) {
        Node n = new Node(5);
        System.out.println(length(n));
        add(n, 7);
        System.out.println(length(n));
        try {
            System.out.println(get(n, 0));
        } catch (EndOfListException e) {
            e.printStackTrace();
        }
        add(n, 8);
        add(n, 9);
        add(n, 10);
        add(n, 11);
        add(n, 1);
        System.out.println(length(n));
        try {
            System.out.println();
            System.out.println(get(n, 0));
            System.out.println(get(n, 1));
            System.out.println(get(n, 2));
            System.out.println(get(n, 3));
            System.out.println(get(n, 4));
            System.out.println(get(n, 5));
        } catch (EndOfListException e) {
            e.printStackTrace();
        }
    }
}
