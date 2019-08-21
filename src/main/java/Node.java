package java;

public class Node implements Comparable<Node> {

    /* Instances variables */
    private String key;
    private String value;

    /**
     * Default Constructor
     *
     * @param key   priority key
     * @param value node value
     */
	Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Get key value
     *
     * @return key value
     */
	String getKey() {
        return key;
    }

    /**
     * Set key value
     *
     * @param key value
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Get the value
     *
     * @return the value
     */
	String getValue() {
        return value;
    }

    /**
     * Set the value
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Override default toString
     */
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    /**
     * Comparable method, that compares two key value, to determinate which one is
     * greater.
     */
    public int compareTo(Node o) {
        Node x = (Node) o;
        //return this.getKey().compareTo(x.getKey());
        if (Integer.parseInt(this.getKey()) < Integer.parseInt(x.getKey()))
            return -1;
        else
            return 1;
    }

}
