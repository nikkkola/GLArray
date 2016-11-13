public class GLArray {
    public static int length(Node n) {
        if(n == null) {
            return 0;
        }
        // the length is the size of current node plus the length of the next
        return n.size + length(n.next);
    }

    public static Integer get(Node n, int index) throws EndOfListException, IllegalArgumentException {
        if(index < 0) {
            throw new IllegalArgumentException("You can't retrieve an element with a negative index.");
        }
        else if(n == null) {
            throw new EndOfListException("Index is higher than the size of the list.");
        }
        else if(index < n.size) {
            return n.elements[index];
        }
        // if this node is not the one we're looking for, we need to look in
        // the next one but for the size of the current one fewer steps
        return get(n.next, index - n.size);
    }

    public static Node add(Node n, Integer i) {
        if(n == null) { // first base case where the node is null
            n = new Node(100);
            n.elements[0] = i;
            n.size++;
        }
        else if(n.size < n.elements.length) { // second base case where there is space in the holding array
            n.elements[n.size] = i;
            n.size++;
        }
        else { // if base cases don't apply, we make a recursive call on the next node in the list
            n.next = add(n.next, i);
        }
        // return a reference to either a new node or the node that was passed
        return n;
    }

    public static void main(String[] args) {
        Node n = new Node(5);
        n = add(n, 7);
        n = add(n, 8);
        n = add(n, 9);
        n = add(n, 10);
        n = add(n, 11);
        n = add(n, 12);
        System.out.println(length(n));
<<<<<<< HEAD
        System.out.println(n);
        System.out.println(n.next);
        try {
=======
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
>>>>>>> origin/master
            System.out.println(get(n, 0));
            System.out.println(get(n, 3));
            System.out.println(get(n, 5));
<<<<<<< HEAD
            System.out.println(get(n, 15));
        }
        catch (EndOfListException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        n = new Node(1);
        n = add(n, 100);
        System.out.println(n);
        n = add(n, 101);
        System.out.println(n.next);
        System.out.println(length(n));
        try {
            System.out.println(get(n, -1));
        }
        catch(EndOfListException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
=======
        } catch (EndOfListException e) {
            e.printStackTrace();
>>>>>>> origin/master
        }
    }

    // Question 1
    // The number of steps grows proportionally with the number of added elements. For every 100 new elements, it would
    // take 1 more step. That's the case because for every 100 elements it's just an array lookup but the steps increase
    // by 1 depending on the number of recursion calls that have to be made.

    // Question 2
    // Again, the number of steps grows proportionally with the number of added elements. Whenever a new array is allocated,
    // the steps increase by 1.

    // Question 3
    // It's constant time (O(1)) because it would just include assigning a value to a variable from the newly created array.

    // Question 4
    // I would use a GLArray if I didn't know what the size of my data would be because it's easier to grow it compared to
    // a growable array and I won't be punished as much in terms of time. Whereas I would use a growable array if I needed
    // to retrieve an element quickly, i.e. in a constant amount of time because in a GLArray that operation might take a
    // constant amount of time but that won't always be the case - more often it would be linear.
}
