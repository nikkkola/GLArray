public class GLArray {
    public static int length(Node n) {
        if(n == null) {
            return 0;
        }
        // the length is the size of current node plus the length of the next
        return n.size + length(n.next);
    }

    public static Integer get(Node n, int index)
            throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if(index < 0) {
            throw new IllegalArgumentException("You can't retrieve an element with a negative index.");
        }
        else if(n == null || (n.next == null && index >= n.size)) {
            throw new ArrayIndexOutOfBoundsException("Index is higher than the size of the list.");
        }
        else if(index < n.size) {
            return n.elements[index];
        }
        // if this node is not the one we're looking for, we need to look in
        // the next one but for the size of the current one fewer steps
        return get(n.next, index - n.size);
    }

    public static void add(Node n, Integer i) {
        if(n.next == null) { // base case where the next node is null
            if(n.size < n.elements.length) { // if there is space in the holding array, we can add to it
                n.elements[n.size] = i;
                n.size++;
            }
            else { // else we create a new node and attach it to the current one
                Node newNode = new Node(n.size * 2);
                newNode.elements[0] = i;
                newNode.size++;
                n.next = newNode;
            }
        }
        else { // if base case doesn't apply, we make a recursive call on the next node in the list
            add(n.next, i);
        }
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        add(n, 100);
        System.out.println(n);
        add(n, 101);
        System.out.println(n.next);
        System.out.println(length(n));
        try {
            System.out.println(get(n, -1));
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(get(n, 100));
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        n.next = new Node(10);
        add(n, 1); add(n, 2); add(n, 3); add(n, 4); add(n, 5); add(n, 6); add(n, 7); add(n, 8);
        add(n, 9); add(n, 10); add(n, 11); add(n, 12);
        try {
            System.out.println(get(n, 0));
            System.out.println(get(n, 2));
            System.out.println(get(n, 5));
            System.out.println(get(n, 8));
            System.out.println(get(n, 12));
        }
        catch(ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        for(Node tmp = n; tmp != null; tmp = tmp.next) {
            System.out.println(tmp);
        }
        System.out.println(length(n));
        for(int i = 13; i <= 200; i++) {
            add(n, i);
        }
        System.out.println(length(n));
        try {
            System.out.println(get(n, 50));
            System.out.println(get(n, 75));
            System.out.println(get(n, 100));
            System.out.println(get(n, 125));
            System.out.println(get(n, 150));
            System.out.println(get(n, 175));
            System.out.println(get(n, 200));
        }
        catch(ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        for(Node tmp = n; tmp != null; tmp = tmp.next) {
            System.out.println(tmp);
        }
    }

    // Question 1
    // The number of steps grows proportionally with the number of added elements. For every 100 new elements, it would
    // take 1 more step. That's the case because for every 100 elements it's just an array lookup but the steps increase
    // by 1 depending on the number of recursion calls that have to be made. Roughly n/100 steps or just the number of
    // nodes amount of steps.

    // Question 2
    // If you double (or indeed multiply by any factor > 1) the size of the previous node then you get logarithmic traversals.
    // Roughly log(n) steps to get to the last element.

    // Question 3
    // It's linear (O(n)) because it would run n items in order to get to the last node and then it's either assigning
    // a value to a variable from the array or allocating a new array which are both constant time O(1) and are disregarded.

    // Question 4
    // I would use a GLArray if I didn't know what the size of my data would be because it's easier to grow it compared to
    // a growable array and I won't be punished as much in terms of time complexity. Whereas I would use a growable array if I
    // needed to retrieve an element quickly, i.e. in a constant amount of time because in a GLArray that operation might take a
    // constant amount of time but that won't always be the case - more often it would be logarithmic.
}
