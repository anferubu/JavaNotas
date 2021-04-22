## Lista enlazada simple

Consiste en una secuencia de nodos, en los que se guardan datos arbitrarios y una referencia al nodo siguiente, mientras que el último nodo apunta a `null` para indicar el final de la lista.

A continuación se encuentra la implementación en Java de una lista enlazada simple.

- [Clase **Node**](#clase-node).
- [Clase **SimpleLinkedList**](#clase-simplelinkedlist).
    - [Métodos de la clase **SimpleLinkedList**](#métodos-de-la-clase-simplelinkedlist).
        - [Comprobar si la lista está vacía](#comprobar-si-la-lista-está-vacía).
        - [Limpiar lista](#limpiar-lista).
        - [Obtener tamaño de lista](#obtener-tamaño-de-lista).
        - [Comprobar si la lista contiene un elemento](#comprobar-si-la-lista-contiene-un-elemento).
        - [Obtener un elemento de la lista](#obtener-un-elemento-de-la-lista).
        - [Agregar elemento al inicio de la lista](#agregar-elemento-al-inicio-de-la-lista).
        - [Agregar elemento en una posición dada](#agregar-elemento-en-una-posición-dada).
        - [Agregar elemento al final de la lista](#agregar-elemento-al-final-de-la-lista).
        - [Eliminar primer elemento de la lista](#eliminar-primer-elemento-de-la-lista).
        - [Eliminar elemento en una posición dada](#eliminar-elemento-en-una-posición-dada).
        - [Eliminar último elemento de la lista](#eliminar-último-elemento-de-la-lista).
        - [Sobrescribir **toString**](#sobrescribir-tostring).



### Clase **Node**

Esta clase contiene dos campos, el dato que almacena y una referencia al nodo siguiente. Al inicializar un objeto de esta clase, se pasa como parámetro el dato que guardará el nodo y se establece la referencia al siguiente como nula.

Se sobrescribe el método `toString()` para que cuando se imprima el objeto, se obtenga simplemente el valor del nodo.

~~~java
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
~~~




### Clase **SimpleLinkedList**

Esta clase contiene como campo el primer nodo de la lista, el cual se establece como nulo al inicializar un objeto de este tipo. 

~~~java
public class SimpleLinkedList {
    public Node head;
    
    public SimpleLinkedList() {
        this.head = null;
    }
    
    // other methods...
}
~~~




#### Métodos de la clase **SimpleLinkedList**

##### Comprobar si la lista está vacía.

Evalúa si la lista está vacía, comprobando si el primer elemento de la lista es `null`.

~~~java
public boolean isEmpty() {
    return (head == null);
}
~~~




##### Limpiar lista.

Para vaciar una lista enlazada, simplemente se asigna el primer elemento como nulo. De esta manera, los demás elementos quedarán sin referencia y posteriormente serán eliminados por el recogedor de basura de Java.

~~~java
public void clear() {
    head = null;
}
~~~




##### Obtener tamaño de lista.

Para obtener el tamaño de la lista se utiliza un nodo auxiliar que recorre cada nodo y a medida que avanza, se va contando el número de elementos.

~~~java
public int size() {
    Node aux = head;
    int size = 0;
    while (aux != null) {
        aux = aux.next;
        size++;
    }
    return size;
}
~~~




##### Comprobar si la lista contiene un elemento.

Evalúa si la lista contiene el elemento pasado como parámetro. Se utiliza un nodo auxiliar para recorrer la lista, el cual comienza en la cabeza y a medida que avanza, se compara su valor con el parámetro.

~~~java
public boolean contains(Object data) {
    Node aux = head;
    while (aux != null) {
        if (aux.data.equals(data)) 
            return true;
        aux = aux.next;
    }
    return false;
}
~~~




##### Obtener un elemento de la lista.

Este método retorna el elemento de la lista en la posición dada, en donde el primer elemento tiene un índice `0`. Para esto se utiliza un nodo auxiliar, el cual inicia en la cabeza de la lista y a medida que avanza, se va contando la posición del nodo.

~~~java
public Object get(int index) {
    Node aux = head;
    int count = 0;
    while (count < index) {
        aux = aux.next;
        count++;
    }
    return aux;
}
~~~




##### Agregar elemento al inicio de la lista.

Para añadir un nuevo elemento al inicio de la lista se crea el nodo. Luego, se establece que el nodo siguiente a este sea la cabeza de la lista (*si la lista está vacía, apuntará a `null`*). Al final, se establece como cabeza de la lista al nuevo nodo.

~~~java
public void addFirst(Object data) {
    Node newNode = new Node(data);   
    newNode.next = head;
    head = newNode;
}
~~~




##### Agregar elemento en una posición dada.

Para añadir un nuevo elemento en cualquier posición de la lista, primero se crea el nuevo nodo. Si el índice es `0` se realiza el mismo procedimiento en que `addFirst()`. 

Si no, se crea un nodo auxiliar y un contador. Luego se recorre la lista hasta que el contador sea menor al índice menos 1, para así ubicar el nodo auxiliar justo antes de la posición deseada. Se establece que el nuevo nodo apunte al siguiente del nodo auxiliar y que este apunte al nuevo nodo, para así ubicar al nuevo nodo entre el auxiliar y el siguiente a este.

~~~java
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
~~~




##### Agregar elemento al final de la lista.

Para añadir un elemento al final de la lista, se crean dos nodos, uno correspondiente al nuevo elemento y otro utilizado para recorrer la lista. Si la lista está vacía, establece el nuevo nodo como la cabeza de la lista. Si no, recorre la lista hasta llegar al último nodo y se asigna que en vez de apuntar a `null`, ahora apunte al nuevo nodo.

~~~java
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
~~~




##### Eliminar primer elemento de la lista.

Este método retorna el primer elemento de la lista y lo elimina de esta. Se crea un nodo auxiliar que corresponde a la cabeza de la lista y al elemento que será retornado. Luego, si la lista no está vacía, hace que la nueva cabeza sea el segundo elemento de esta.

~~~java
public Object removeFirst() {
    Node aux = head;
    if (!this.isEmpty()) 
        head = head.next;
    return aux;
}
~~~




##### Eliminar elemento en una posición dada.

Remueve el elemento en la posición dada. Si el índice es `0`, se establece como primer elemento de la lista al segundo. Si no, se crea un nodo auxiliar para recorrer la lista junto a un contador, se ubica el nodo auxiliar justo antes de la posición deseada y se indica que el nodo siguiente a este sea el que está a dos posiciones, para así dejar el nodo deseado sin referencia, por lo que posteriormente será eliminado por el recogedor de basura de Java.

~~~java
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
~~~




##### Eliminar último elemento de la lista.

Remueve y retorna el último elemento de la lista. Si la lista está vacía, retorna `null`. Si no, se crea un nodo auxiliar y se ubica justo antes del último elemento. Luego se crea otro nodo que corresponde al último y que será el objeto retornado. Por último, se establece que el elemento siguiente al penúltimo sea `null`.

~~~java
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
~~~




##### Sobrescribir **toString**

Se sobrescribe este método para que al imprimir la lista, se obtenga una cadena legible de la forma `["A", "B", "C"]`. Básicamente, se crea un nodo auxiliar para recorrer toda la lista, y a medida que avanza se va concatenando su valor a una cadena de caracteres previamente inicializada.

~~~java
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
~~~

