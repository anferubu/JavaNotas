package mylinkedlist;

/**
 * Ejecución de una lista enlazada simple.
 * @author Felipe Buriticá
 */
public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast("Rojo");
        list.addLast("Amarillo");
        list.addFirst("Azul");
        list.addAt(2, "Verde");

        System.out.print("Lista de izquierda a derecha: ");
        list.forwards();

        System.out.print("Lista de derecha a izquierda: ");
        list.backwards();

        System.out.println("\nTamaño de la lista: " + list.size());

        list.removeFirst();
        list.removeAt(1);

        System.out.println("\nDespués de eliminar el primer y último elemento: ");
        System.out.println(list);

        /*
        * Lista de izquierda a derecha: [Azul, Rojo, Verde, Amarillo]
        * Lista de derecha a izquierda: [Amarillo, Verde, Rojo, Azul]
        *
        * Tamaño de la lista: 4
        *
        * Después de eliminar el primer y último elemento:
        * [Rojo, Amarillo]
        */
    }
}
