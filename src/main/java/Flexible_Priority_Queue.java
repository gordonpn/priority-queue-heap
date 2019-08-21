package java;

public class Flexible_Priority_Queue {
    /* Instances variables */
    private Node[] array;
    private int capacity, size;
    private String state;

    /**
     * Default Constructor, with 1 parameter
     *
     * @param state either minimum or maximum
     */
    public Flexible_Priority_Queue(String state) {
        this.state = state.toUpperCase();
        this.size = -1;
        this.capacity = 1;
        array = new Node[capacity];
    }

    /**
     * Default Constructor, with 2 parameter
     *
     * @param array an array of Node unsorted.
     * @param state either minimum or maximum
     */
    public Flexible_Priority_Queue(Node array[], String state) {
        this(state);
        for (Node n : array) {
            insert(n.getKey(), n.getValue());
        }
    }

    /**
     * Removes and returns the entry (a key, value pair) with the smallest or
     * biggest key depending on the current state of the priority queue(either
     * Minimum or Maximum).
     *
     * @return an Element
     */
    public Node remove() {
        if (isEmpty()) {
            System.out.println("\nPriority queue is empty!");
            return null;
        }
        Node nodeRemoved = array[0];
        System.out.println("  Remove: " + nodeRemoved);
        show();
        array[0] = array[size];
        array[size] = null;
        downHeap(array, 0);
        size--;
        shrink();
        return nodeRemoved;
    }

    /**
     * Recursive downHeap, to adjust the priority of the queue.
     *
     * @param array the priority queue
     * @param root  the root node
     */
    public void downHeap(Node[] array, int root) {
        int leftChild = 2 * root + 1; /* Left child location */
        int rightChild = 2 * root + 2; /* Right child location */

        /* Minimum Heap */
        if (state().equalsIgnoreCase("MIN")) {
            show();
            /* leftChildd != null */
            if (array[leftChild] != null
                    /* leftChild < root */
                    && array[leftChild].compareTo(array[root]) < 0
                    /* rightChild != null */
                    && (array[rightChild] == null
                    /* leftChild < rightChild */
                    || array[leftChild].compareTo(array[rightChild]) < 0)) {
                Node temp = array[root];
                array[root] = array[leftChild];
                array[leftChild] = temp;
                downHeap(array, leftChild);

            } else if (array[rightChild] != null /* rightChild != null */
                    /* rightChild < root */
                    && array[rightChild].compareTo(array[root]) < 0
                    /* leftChild != null */
                    && (array[leftChild] == null
                    /* rightChild < leftChild */
                    || array[rightChild].compareTo(array[leftChild]) < 0)) {
                Node temp = array[root];
                array[root] = array[rightChild];
                array[rightChild] = temp;
                downHeap(array, rightChild);

            } else {
                System.out.println("  *No more Adjustment needed.\n");
            }
        }

        /* Maximum Heap */
        if (state().equalsIgnoreCase("MAX")) {
            show();
            /* leftChildd != null */
            if (array[leftChild] != null
                    /* leftChild > root */
                    && array[leftChild].compareTo(array[root]) > 0
                    /* rightChild != null */
                    && (array[rightChild] == null
                    /* leftChild > rightChild */
                    || array[leftChild].compareTo(array[rightChild]) > 0)) {
                Node temp = array[root];
                array[root] = array[leftChild];
                array[leftChild] = temp;
                downHeap(array, leftChild);

            } else if (array[rightChild] != null /* rightChild != null */
                    /* rightChild > root */
                    && array[rightChild].compareTo(array[root]) > 0
                    /* leftChild != null */
                    && (array[leftChild] == null
                    /* rightChild > leftChild */
                    || array[rightChild].compareTo(array[leftChild]) > 0)) {
                Node temp = array[root];
                array[root] = array[rightChild];
                array[rightChild] = temp;
                downHeap(array, rightChild);

            } else {
                System.out.println("  *No more Adjustment needed.\n");
            }
        }
    }

    /**
     * Insert the (k,v) entry which is a key(k), value(v) pair to the priority
     * queue.
     *
     * @param key   the priority queue value
     * @param value the value of that element
     */
    public void insert(String key, String value) {
        if (isFull())
            expand();
        array[size()] = new Node(key, value);
        System.out.println("  Insert: " + array[size()]);
        upHeap(array, size());
        size++;
    }

    /**
     * Recursive upHeap, to adjust the priority of the queue.
     *
     * @param array the priority queue
     * @param root  the root node
     */
    public void upHeap(Node[] array, int current) {

        int fatherNode = (current - 1) / 2; /* Father location */

        /* Minimum Heap */
        if (state().equalsIgnoreCase("MIN")) {
            show();
            /* Father is not null */
            if (array[fatherNode] != null && fatherNode != current
                    /* Father smallest then me */
                    && array[current].compareTo(array[fatherNode]) < 0) {
                Node temp = array[current];
                array[current] = array[fatherNode];
                array[fatherNode] = temp;
                upHeap(array, fatherNode);
            } else {
                System.out.println("  *No more Adjustment needed.\n");
            }
        }

        /* Maximum Heap */
        if (state().equalsIgnoreCase("MAX")) {
            show();
            /* Father is not null */
            if (array[fatherNode] != null && fatherNode != current
                    /* Father bigger then me */
                    && array[current].compareTo(array[fatherNode]) > 0) {
                Node temp = array[current];
                array[current] = array[fatherNode];
                array[fatherNode] = temp;
                upHeap(array, fatherNode);
            } else {
                System.out.println("  *No more Adjustment needed.\n");
            }
        }
    }

    /**
     * Returns the top entry (with the minimum of the maximum key depending on
     * whether it is a Minimum of Maximum priority queue, without removing the
     * entry.
     *
     * @return an Element
     */
    public Node top() {
        if (isEmpty())
            return null;
        return array[0];
    }

    /**
     * Transforms a minimum to a maximum priority queue or vice versa.
     */
    public void toogle() {
        if (state().equalsIgnoreCase("MIN")) {
            state = "MAX";
            switchToMax();
        } else {
            state = "MIN";
            switchToMin();
        }
    }

    /**
     * Transforms a maximum to a minimum priority queue; else leave unchanged.
     */
    public void switchToMax() {
        for (int midNode = size() / 2; midNode >= 0; midNode--) {
            downHeap(array, midNode);
        }
        this.state = "MAX";
    }

    /**
     * Transforms a minimum to a maximum priority queue; else leave unchanged.
     */
    public void switchToMin() {
        for (int midNode = size() / 2; midNode >= 0; midNode--) {
            downHeap(array, midNode);
        }
        this.state = "MIN";
    }

    /**
     * Returns the current state (minimum or maximum) of the priority queue.
     *
     * @return minimum or maximum heap
     */
    public String state() {
        return state;
    }

    /**
     * Return true if the priority queue is full.
     *
     * @return boolean answer
     */
    public boolean isFull() {
        // return size() == capacity - 1;
        return size() < capacity * 2 - 1;
    }

    /**
     * Returns true if the priority queue is empty.
     *
     * @return boolean answer
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * returns the current number of entries in the priority queue
     *
     * @return the size of priority queue
     */
    public int size() {
        return size + 1;
    }

    /**
     * Expand array when size reaches same as capacity. Double the size of the
     * array. Dynamic array.
     */
    public void expand() {
        int newCapacity = (size() + 1) * 2 + 1;
        Node array2[] = new Node[newCapacity];
        System.arraycopy(array, 0, array2, 0, size());
        array = array2;
        capacity = newCapacity;
    }

    /**
     * Shrink size of my array, if there is less then half unused space.
     */
    public void shrink() {
        int newCapacity = size() * 2 + 1;
        if (size() < newCapacity) {
            Node array2[] = new Node[newCapacity];
            System.arraycopy(array, 0, array2, 0, size());
            array = array2;
        }
    }

    /**
     * Display everything inside my priority queue.
     */
    public void show() {
        System.out.print("Priority_Queue: ");
        for (Node n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

}