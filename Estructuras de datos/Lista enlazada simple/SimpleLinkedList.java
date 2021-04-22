package mylinkedlist;

/**
 * Implementación de una lista enlazada simple.
 * @author Felipe Buriticá
 */
public class SimpleLinkedList {
    public Node head;

    public SimpleLinkedList() {
        this.head = null;
    }

    // Evalúa si la lista está vacía.
    public boolean isEmpty() {
        return (head == null);
    }

    // Evalúa si la lista contiene el elemento.
    public boolean contains(Object data) {
        Node aux = head;
        while (aux != null) {
            if (aux.data.equals(data))
                return true;
            aux = aux.next;
        }
        return false;
    }

    // Vacía la lista.
    public void clear() {
        head = null;
    }

    // Añade un elemento al inicio de la lista.
    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Añade un elemento en la posición dada.
    public void addAt(int index, Object data) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }
        else {
            Node aux = head;
            int count = 0;
            while (count < (index - 1)) {
                aux = aux.next;
                count++;
            }
            newNode.next = aux.next;
            aux.next = newNode;
        }
    }

    // Añade un elemento al final de la lista.
    public void addLast(Object data) {
        Node newNode = new Node(data);
        Node last = head;
        if (this.isEmpty())
            head = newNode;
        else {
            while (last.next != null)
                last = last.next;
            last.next = newNode;
        }
    }

    // Retorna el elemento en la posición dada.
    public Object get(int index) {
        Node aux = head;
        int count = 0;
        while (count < index) {
            aux = aux.next;
            count++;
        }
        return aux;
    }

    // Remueve y retorna el primer elemento de la lista.
    public Object removeFirst() {
        Node aux = head;
        if (!this.isEmpty())
            head = head.next;
        return aux;
    }

    // Remueve el elemento en la posición dada.
    public void removeAt(int index) {
        if (index == 0)
            head = head.next;
        else {
            Node aux = head;
            int count = 0;
            while (count < (index - 1 )) {
                aux = aux.next;
                count++;
            }
            aux.next = aux.next.next;
        }
    }

    // Remueve y retorna el último elemento de la lista.
    public Object removeLast() {
        if (this.isEmpty())
            return null;
        Node aux = head;
        while (aux.next.next != null)
            aux = aux.next;
        Node last = aux.next;
        aux.next = null;
        return last;
    }

    // Retorna el tamaño de la lista.
    public int size() {
        Node aux = head;
        int size = 0;
        while (aux != null) {
            aux = aux.next;
            size++;
        }
        return size;
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
