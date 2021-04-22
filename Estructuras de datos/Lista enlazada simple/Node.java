package mylinkedlist;

/**
 * Implementación de un nodo simple.
 * @author Felipe Buriticá
 */
public class Node {
    public Object data;
    public Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
