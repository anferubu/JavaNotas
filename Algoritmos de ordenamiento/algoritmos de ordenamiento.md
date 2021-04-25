# Algoritmos de ordenamiento



Un algoritmo de ordenamiento (*sorting algorithm*) es un algoritmo que ubica los elementos de una lista en cierto orden, generalmente en un orden numérico o lexicográfico. Un ordenamiento eficiente es importante para optimizar otros algoritmos tales como los de búsqueda y combinación, que requieren que los datos de entrada estén ordenados. 

Aunque hay una gran cantidad de algoritmos de ordenamiento, en la práctica predominan unos pocos. Por ejemplo, ***insertion sort*** es ampliamente utilizado para ordenar conjuntos pequeños de datos, mientras que, para grandes conjuntos de datos se suelen utilizar ***heap sort***, ***merge sort*** o ***quicksort***. Además, a pesar de ser raramente utilizado en la práctica, ***buble sort*** se suele utilizar en la enseñanza.

| **Nombre**     | **Best** | **Average** | **Worst** | **Memory** |
| -------------- | -------- | ----------- | --------- | ---------- |
| Heapsort       | n log(n) | n log(n)    | n log(n)  | 1          |
| Merge sort     | n log(n) | n log(n)    | n log(n)  | n          |
| Quicksort      | n log(n) | n log(n)    | n^2^      | log(n)     |
| Insertion sort | n        | n^2^        | n^2^      | 1          |
| Bubble sort    | n        | n^2^        | n^2^      | 1          |
| Selection sort | n^2^     | n^2^        | n^2^      | 1          |



---

## Implementación en Java

### Bubble sort

En el ordenamiento por burbuja, se compara cada elemento de la lista con el siguiente, intercambiándolos de posición si están en el orden equivocado. Esto hace que sea necesario recorrer varias veces la lista entera hasta ordenarla por completo. No se recomienda su uso debido a lo ineficiente que es.

![Bubble sort](./images/bubblesort.gif)

En la implementación se utilizan dos bucles `for`, el primero sirve para recorrer la lista completa varias veces, mientras que el segundo permite recorrer cada elemento y compararlo con el siguiente, si es mayor se intercambian los valores.

~~~java
public static void bubbleSort(int[] array) {
    int n = array.length;
    for (int i=0; i<n; i++) {
        for (int j=0; j<(n-1); j++) {
            if (array[j] > array[j+1]) {
                int aux = array[j];
                array[j] = array[j+1];
                array[j+1] = aux;
            }
        }
    }
}
~~~



### Selection sort

Este algoritmo mejora ligeramente el *bubble sort*, ya que requiere muchas menos operaciones de intercambio, aunque la mejora no es muy sustancial. Funciona buscando el mínimo elemento de la lista, lo intercambia con el primero, luego busca el siguiente mínimo en el resto de la lista y lo intercambia con el segundo, hasta llegar al final de la lista.

![Selection sort](./images/selectionsort.gif)

En la implementación, se usan dos bucles `for`, el primero recorre toda la lista una vez, mientras que el segundo permite recorrer los elementos posteriores a la posición actual para buscar el valor que sea más pequeño que el número actual y guardar su índice en una variable auxiliar para luego hacer el intercambio.

~~~java
public static void selectionSort(int[] array) {
    for (int i=0; i<array.length; i++) {
        int min = i;
        for (int j=i+1; j<array.length; j++) 
            if (array[j] < array[min]) 
                min = j;   
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }
}
~~~



### Insertion sort

Este algoritmo funciona tomando el primer elemento y tratándolo como un conjunto ordenado, luego cuando hay *k* elementos ordenados de menor a mayor, se toma el siguiente elemento *k+1* y se compara con todos los elementos ya ordenados, deteniéndose cuando se encuentra un elemento menor (*todos los elementos mayores han sido desplazados una posición a la derecha*) o cuando ya no se encuentran elementos (*todos los elementos fueron desplazados y este es el más pequeño*).

![Insertion sort](./images/insertionsort.gif)

En la implementación, se recorre toda la lista y se compara el elemento actual con los anteriores, si los elementos previos son mayores que el valor actual, se van desplazando hacia la derecha, hasta que el valor actual se encuentre con un número menor, en cuyo caso realiza el intercambio de posiciones.

~~~java
public static void insertionSort(int[] array) {
    for (int i=1; i<array.length; i++) {
        int current = array[i];
        int j = i - 1;
        while (j >= 0 && current < array[j]) {
            array[j+1] = array[j];
            j--;
        }
        array[j+1] = current;
    }
}
~~~



### Quicksort





### Merge sort





### Heapsort

