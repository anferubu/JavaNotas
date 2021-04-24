## Lista doblemente enlazada

Consiste en una secuencia de nodos, en los que se guardan datos arbitrarios y dos referencia, una al nodo anterior y otra al nodo siguiente, mientras que el final de la lista está marcado por el valor `null`.

![Lista doblemente enlazada](./doublyLinkedList.png)

A continuación se encuentra la implementación en Java de una lista doblemente enlazada.

- [Clase **Node**](#clase-node).
- [Clase **DoublyLinkedList**](#clase-doublylinkedlist).
    - [Métodos de la clase **DoublyLinkedList**](#métodos-de-la-clase-doublylinkedlist).
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
        - [Imprimir lista de izquierda a derecha](#imprimir-lista-de-izquierda-a-derecha).
        - [Imprimir lista de derecha a izquierda](#imprimir-lista-de-derecha-a-izquierda).
        - [Sobrescribir **toString**](#sobrescribir-tostring).


---


### Clase **Node**

Esta clase contiene tres campos, el dato que almacena y las referencias al nodo anterior y siguiente. Al inicializar un objeto de esta clase, se pasa como parámetro el dato que guardará el nodo y se establece las referencias como nulas.

Se sobrescribe el método `toString()` para que cuando se imprima el objeto, se obtenga simplemente el valor del nodo.

~~~java
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
~~~


---

### Clase **DoublyLinkedList**

Esta clase contiene como campos el primer y último nodo de la lista, los cuales se establecen como nulos al inicializar un objeto de este tipo. 

~~~java
public class DoublyLinkedList {
    public Node head;
    pubilc Node tail;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    // other methods...
}
~~~


---

#### Métodos de la clase **DoublyLinkedList**

##### Comprobar si la lista está vacía.

Evalúa si la lista está vacía, comprobando si el primer y último elemento de la lista es `null`.

~~~java
public boolean isEmpty() {
    return (head == null && tail == null);
}
~~~


---


##### Limpiar lista.

Para vaciar una lista enlazada, simplemente se asigna el primer y último elemento como nulo. De esta manera, los demás elementos quedarán sin referencia y posteriormente serán eliminados por el recogedor de basura de Java.

~~~java
public void clear() {
    head = null;
    tail = null;
}
~~~


---

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


---

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


---

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


---

##### Agregar elemento al inicio de la lista.

Para añadir un nuevo elemento al inicio de la lista se crea el nodo. Si la lista está vacía, se establece dicho nodo como cabeza y cola. Si no está vacía, se establece que el nodo siguiente al nuevo sea la cabeza y que el previo a la cabeza sea el nuevo, y por último se establece que la cabeza de la lista sea ahora el nuevo nodo.

~~~java
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
~~~


---

##### Agregar elemento en una posición dada.

Para añadir un nuevo elemento en cualquier posición de la lista, primero se crea el nuevo nodo. Si la lista está vacía, se establece este nuevo nodo como cabeza y cola. 

Si el índice es `0`, se indica que después del nodo siga la cabeza y que antes de la cabeza esté el nodo, luego se establece como nueva cabeza dicho nodo.

Si el índice está una posición después del último elemento, se indica que después de la cola sigue el nodo y que antes del nodo está la cola, luego se establece como nueva cola dicho nodo.

Si no se cumple ninguna de las condiciones anteriores, se crea un nodo auxiliar y un contador para recorrer la lista. Se ubica el nodo auxiliar justo antes de la posición deseada y se ubica el nodo entre el auxiliar y el siguiente a este.

~~~java
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
~~~


---


##### Agregar elemento al final de la lista.

Para añadir un elemento al final de la lista, se crea un nuevo nodo. Si la lista está vacía, se establece este nodo como cabeza y cola de la lista. Si no, que establece el nodo siguiente a la cola sea este nuevo nodo y que el previo al nuevo nodo sea la cola. Por último, se establece que la cola de la lista sea ahora el nuevo nodo.

~~~java
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
~~~


---


##### Eliminar primer elemento de la lista.

Para eliminar el primer elemento de la lista se evalúa si la cabeza y la cola son iguales,  en cuyo caso se establecen ambas como `null`. Si no, se establece como el primer elemento de la lista al segundo, y el previo a este se establece en nulo.

~~~java
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
~~~


---

##### Eliminar elemento en una posición dada.

Remueve el elemento en la posición dada. Si la lista solo tiene un elemento, se establece la cabeza y la cola como nulos.

Si el índice es 0 pero hay más de un elemento, se establece como la cabeza al segundo elemento y se indica que antes de este está un valor nulo.

Si el índice corresponde al último elemento, se establece como cola al penúltimo elemento y se indica que después de este hay un valor nulo.

Si ninguna de estas condiciones se cumple, se crea un nodo auxiliar y un contador para ubicar al nodo justo antes de la posición deseada. Luego se relaciona el nodo auxiliar con el que está dos posiciones adelante, para que así el nodo que se quiere eliminar quede sin referencia, por lo que posteiormente será borrado por el recogedor de basura de Java.

~~~java
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
~~~


---

##### Eliminar último elemento de la lista.

Para eliminar el último elemento de la lista se evalúa si la cabeza y la cola son iguales,  en cuyo caso se establecen ambas como `null`. Si no, se establece como el último elemento de la lista al penúltimo, y el siguiente a este se establece en nulo.

~~~java
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
~~~


---

##### Imprimir lista de izquierda a derecha

Para esto se crea un nodo auxiliar que corresponde a la cabeza de la lista, el cual permite recorrer la lista y a medida que avanza, se imprime el valor de cada nodo.

~~~java
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
~~~

---

##### Imprimir lista de derecha a izquierda

Para esto se crea un nodo auxiliar que corresponde a la cola de la lista, el cual permite recorrer la lista hacia atrás y a medida que retrocede, se imprime el valor de cada nodo.

~~~java
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
~~~

---

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

