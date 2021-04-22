package mylinkedlist;

/**
 * Ejecución de una lista enlazada simple.
 * @author Felipe Buriticá
 */
public class Main {

    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();

        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addFirst("A");

        System.out.println(list);
        System.out.println("Tamaño de la lista: " + list.size());

        list.removeFirst();
        list.removeLast();

        System.out.println(list);

        /*
        * output:
        * [A, B, C, D]
        * Tamaño de la lista: 4
        * [B, C]
        */
    }
}
