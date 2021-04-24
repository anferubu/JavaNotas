package Queue;

/**
 * Implementación de una cola a partir de una lista enlazada.
 * @author Felipe Buriticá
 */
public class LinkedListQueue {
    private Node head;
    private Node tail;
    private int length;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // Añade un elemento al final de la cola.
    public void push(Object data) {
        Node newNode = new Node(data);
        if (this.isEmpty())
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
        length++;
    }

    // Retorna y elimina el primer elemento de la cola.
    public Node pop() {
        Node removed = head;
        if (head == tail) {
            head = null;
            tail = null;
        }
        else
            head = head.next;
        length--;
        return removed;
    }

    // Evalúa si la cola está vacía.
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    // Retorna el tamaño de la cola.
    public int size() {
        return length;
    }

    // Retorna el primer elemento de la cola.
    public Object first() {
        return head;
    }

    @Override
    public String toString() {
        String result = "[";
        Node aux = head;
        while (aux != null) {
            result += aux;
            if (aux.next != null)
                result += ", ";
            aux = aux.next;
        }
        return result + "]";
    }
}
