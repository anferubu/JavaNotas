package mylinkedlist;

/**
 * Implementacion de una lista doblemente enlazada.
 * @author Felipe Buriticá
 */
public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Evalúa si la lista está vacía.
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    // Vacía la lista.
    public void clear() {
        head = null;
        tail = null;
    }

    // Obtener tamaño de la lista.
    public int size() {
        Node aux = head;
        int size = 0;
        while (aux != null) {
            aux = aux.next;
            size++;
        }
        return size;
    }

    // Comprobar si la lista contiene un elemento.
    public boolean contains(Object data) {
        Node aux = head;
        while (aux != null) {
            if (aux.data.equals(data))
                return true;
            aux = aux.next;
        }
        return false;
    }

    // Obtener un elemento de la lista.
    public Object get(int index) {
        Node aux = head;
        int count = 0;
        while (count < index) {
            aux = aux.next;
            count++;
        }
        return aux;
    }

    // Añade un elemento al inicio de la lista.
    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Añade un elemento en la posición dada.
    public void addAt(int index, Object data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else if (index == this.size()) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        else {
            Node aux = head;
            int count = 0;
            while (count < (index - 1)) {
                aux = aux.next;
                count++;
            }
            newNode.next = aux.next;
            newNode.prev = aux;
            aux.next.prev = newNode;
            aux.next = newNode;
        }
    }

    // Añade un elemento al final de la lista.
    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Remueve el primer elemento de la lista.
    public void removeFirst() {
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
    }

    // Remueve elemento en una posición dada.
    public void removeAt(int index) {
        if (head == tail && index == 0) {
            head = null;
            tail = null;
        }
        else if (index == 0) {
            head = head.next;
            head.prev = null;
        }
        else if (index == this.size() - 1) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            Node aux = head;
            int count = 0;
            while (count < (index - 1)) {
                aux = aux.next;
                count++;
            }
            aux.next = aux.next.next;
            aux.next.prev = aux;
        }
    }

    // Remueve el último elemento de la lista.
    public void removeLast() {
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Imprime lista de izquierda a derecha.
    public void forwards() {
        System.out.print("[");
        Node aux = head;
        while (aux != null) {
            System.out.print(aux);
            if (aux.next != null)
                System.out.print(", ");
            aux = aux.next;
        }
        System.out.println("]");
    }

    // Imprime lista de derecha a izquierda.
    public void backwards() {
        System.out.print("[");
        Node aux = tail;
        while (aux != null) {
            System.out.print(aux);
            if (aux.prev != null)
                System.out.print(", ");
            aux = aux.prev;
        }
        System.out.println("]");
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
