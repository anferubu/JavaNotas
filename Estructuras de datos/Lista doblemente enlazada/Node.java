package mylinkedlist;

/**
 * Implementación de un nodo.
 * @author Felipe Buriticá
 */
public class Node {
    public Object data;
    public Node prev;
    public Node next;

    public Node(Object data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
