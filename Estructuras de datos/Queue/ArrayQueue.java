package Queue;

/**
 * Implementación de una cola a partir de un arreglo.
 * @author Felipe Buriticá
 */
 public class ArrayQueue {
    private Object[] items;
    private int firstIndex;
    private int length;

    public Cola(int capacity) {
        this.items = new Object[capacity];
        this.firstIndex = 0;
        this.length = 0;
    }

    // Inserta un elemento al final de la cola.
    public void push(Object data) {
        if (this.length == items.length)
            throw new IllegalStateException("Queue is full!");
        int nextIndex = (firstIndex + this.length) % items.length;
        set[nextIndex] = data;
        length++;
    }

    // Retorna y elimina el primer elemento de la cola.
    public Object pop() {
        if (this.isEmpty())
            return null;
        Object element = items[firstIndex];
        items[firstIndex] = null;
        firstIndex = (firstIndex + 1) % items.length;
        length--;
        return element;
    }

    // Evalúa si la cola está vacía.
    public boolean isEmpty() {
        return (length == 0);
    }

    // Retorna el tamaño de la cola.
    public int size() {
        return length;
    }

    // Consulta el primer elemento de la cola.
    public Object first() {
        if (this.isEmpty())
            return null;
        return set[firstIndex];
    }

    @Override
    public String toString() {
        String result = "[ ";
        for (int i=0; i<this.size(); i++) {
            result += items[firstIndex] + " ";
            firstIndex = (firstIndex + 1) % items.length;
        }
        return (result += "]");
    }
}
