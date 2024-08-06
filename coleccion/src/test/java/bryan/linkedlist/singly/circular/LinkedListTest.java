package bryan.linkedlist.singly.circular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Test;

import bryan.array.Array;
import bryan.util.iterator.Iterator;

public class LinkedListTest {

     @Test    
    public void testAdd() {
        LinkedList<Integer> list = new LinkedList<>();  
        assertTrue(list.add(23));
        assertTrue(list.add(30));
        assertTrue(list.add(20));
        assertTrue(list.add(0));
        assertEquals(4, list.size());
        
        Object[] expected = {23,30,20,0};
        int i = 0;
        for(Iterator<Integer> it = list.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }

    }

    @Test
    public void testAdd2() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {23, 30, 20, 7};
        assertTrue(list.add(array));
        assertEquals(4, list.size());

        Object[] expected = {23,30,20,7};
        int i = 0;
        for(Iterator<Integer> it = list.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }

    }

    @Test
    public void testAdd3() {
        Array<Integer> array= new Array<>(4);
        array.add(23);
        array.add(30);
        array.add(20);
        array.add(7);
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(array);

        Object[] expected = {23,30,20,7};
        int i = 0;
        for(Iterator<Integer> it = lista.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testAddFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.addFirst(23));
        assertTrue(list.addFirst(30));
        assertTrue(list.addFirst(20));
        assertTrue(list.addFirst(7));
        assertEquals(4, list.size());

        Object[] expected = {7, 20, 30, 23};
        int i = 0;
        for(Iterator<Integer> it = list.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testAddFirst2() { 
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {1, 5, 67, null};
        assertTrue(list.add(array));
        assertEquals(4, list.size());

        Object[] expected = {1, 5, 67, null};
        int i = 0;
        for(Iterator<Integer> it = list.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }

    }

    @Test
    public void testAddFirst3() {
        Array<Integer> array = new Array<>(4);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(9);
        Integer[] integers = {1, 5, 67, null};
        assertTrue(array.add(0, integers));
        assertTrue(list.addFirst(integers));
        assertEquals(6, list.size());

        Object[] expected = {null, 67 , 5, 1, 4, 9};
        int i = 0;
        for(Iterator<Integer> it = list.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testClear() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testContains() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        assertTrue(list.contains(2));
        assertFalse(list.contains(4));
    }

    @Test
    public void testContains2() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        Integer[] array = {3, 4};
        assertTrue(list.contains(array));
        
        Integer[] array2 = {4, 5};
        assertFalse(list.contains(array2));
    }

    @Test
    public void testContains3() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        LinkedList<Integer> collection = new LinkedList<>();
        collection.add(2);
        collection.add(4);
        
        assertTrue(list.contains(collection));
        
        LinkedList<Integer> collection2 = new LinkedList<>();
        collection2.add(4);
        collection2.add(5);
        
        assertFalse(list.contains(collection2));
    }

    @Test
    public void testForEach() {
        
    }

    @Test
    public void testIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testIterator() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        assertEquals("123", sb.toString());
    }

    @Test
    public void testPeek() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {1, 5, 67, null};
        assertTrue(list.add(array));
        assertEquals(4, list.size());
        Object numero = 1;
        assertEquals(numero , list.peek());
    }

    @Test
    public void testPeekArray() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {1, 5, 67, 56, 67, 89, 200};
        assertTrue(list.add(array));
        assertEquals(7, list.size());

        Object[] expected = {1,5,67,56};
        Object[] real = list.peekArray(4);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], real[i]);
        }

    }

    /** 
    @Test
    public void testPeekCollection() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {1, 5, 67, 56, 67, 89, 200};
        assertTrue(list.add(array));
        assertEquals(7, list.size());

        Object[] expected = {1,5,67,56};
        Object[] real = list.peekCollection(4).toArray();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], real[i]);
        }

    }
*/
    @Test
    public void testPeekLast() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {1, 5, 67, 56};
        assertTrue(list.add(array));
        assertEquals(4, list.size());
        Object numero = 56;
        assertEquals(numero , list.peekLast());
    }

    @Test
    public void testPeekLastArray() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {1, 5, 67, 56, 67, 89, 200};
        assertTrue(list.add(array));
        assertEquals(7, list.size());

        Object[] expected = {56,67,89,200};
        Object[] real = list.peekLastArray(4);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], real[i]);
        }
    }

    /** 
    @Test
    public void testPeekLastCollection() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {1, 5, 67, 56, 67, 89, 200};
        assertTrue(list.add(array));
        assertEquals(7, list.size());

        Object[] expected = {56,67,89,200};
        Object[] real = list.peekLastCollection(4).toArray();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], real[i]);
        }
    }
*/
    @Test
    public void testPoll() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {77, 5, 67, 56};
        assertTrue(list.add(array));
        assertEquals(4, list.size());

        Object numero = 77;
        assertEquals(numero , list.poll());
        Object[] expected = {5, 67, 56};
        int i = 0;
        for(Iterator<Integer> it = list.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testPollArray() {
        // Crear una lista y agregar algunos elementos
    LinkedList<Integer> list = new LinkedList<>();
    Integer[] array = {1, 5, 64, 56, 67, 89, 200};
    assertTrue(list.add(array));
    assertEquals(7, list.size());

    Object[] extracted = list.pollArray(4);

    // Verificar que los elementos extraídos sean los esperados
    Object[] expected = {1, 5, 64, 56};
    for (int i = 0; i < expected.length; i++) {
        assertEquals(expected[i], extracted[i]);
    }

    // Verificar que los elementos restantes sean los esperados
    Object[] remaining = {67,89,200};
    int i = 0;
    for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
        assertEquals(remaining[i++], it.next());
    }

    }

    @Test
    public void testPollCollection() {

    }

    @Test
    public void testPollLast() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {77, 5, 67, 56};
        assertTrue(list.add(array));
        assertEquals(4, list.size());

        Object numero = 56;
        assertEquals(numero , list.pollLast());
        Object[] expected = {77, 5, 67};
        int i = 0;
        for(Iterator<Integer> it = list.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testPollLastArray() {
                // Crear una lista y agregar algunos elementos
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {1, 5, 64, 56, 67, 89, 200};
        assertTrue(list.add(array));
        assertEquals(7, list.size());

        Object[] extracted = list.pollLastArray(8);

        // Verificar que los elementos extraídos sean los esperados
        Object[] expected = {1,5,64,56,67,89,200};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], extracted[i]);
        }

        // Verificar que los elementos restantes sean los esperados
        Object[] remaining = {null};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(remaining[i++], it.next());
        }

    }

    @Test
    public void testPollLastCollection() {

    }

    @Test
    public void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {1, 5, 67, 56};
        assertTrue(list.add(array));
        assertEquals(4, list.size());

        assertTrue(list.remove(5));
        assertTrue(list.remove(1));
        Object[] expected = {67, 56};
        int i = 0;
        for(Iterator<Integer> it = list.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testRemove2() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {1, 5, 67, 56, 54};
        assertTrue(list.add(array));
        assertEquals(5, list.size());

        // Prueba eliminando un solo elemento
        assertTrue(list.remove(new Integer[]{5}));
        assertFalse(list.contains(5));
        assertEquals(4, list.size());

        // Prueba eliminando múltiples elementos
        assertTrue(list.remove(new Integer[]{56, 54}));
        assertFalse(list.contains(56));
        assertFalse(list.contains(54));
        assertEquals(2, list.size());

        // Prueba eliminando todos los elementos
        assertTrue(list.remove(new Integer[]{1}));
        assertTrue(list.remove(new Integer[]{67}));
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        // Prueba eliminando un elemento que no existe
        assertFalse(list.remove(new Integer[]{10}));
        assertEquals(0, list.size());

        // Prueba eliminando con un array vacío
        assertFalse(list.remove(new Integer[]{}));
        assertEquals(0, list.size());
    }

    @Test
    public void testRemove3() {
    LinkedList<Integer> list = new LinkedList<>();
    Integer[] elements = {1, 2, 3, 4, 5};
    list.add(elements);
    Predicate<Integer> filter = n -> n % 2 == 0;

    // Imprimir el estado de la lista antes de la eliminación
    System.out.println("Lista antes de la eliminación: " + list);

    // Realizar la eliminación utilizando el predicado
    assertTrue(list.remove(filter)); // Conversión de tipo explícita

    // Imprimir el estado de la lista después de la eliminación
    System.out.println("Lista después de la eliminación: " + list);

    // Verificar que los números pares se hayan eliminado de la lista
    assertFalse(list.contains(2));
    assertFalse(list.contains(4));
    assertEquals(3, list.size());

    // Verificar que los números impares sigan en la lista
    assertTrue(list.contains(1));
    assertTrue(list.contains(3));
    assertTrue(list.contains(5));
    }

    @Test
    public void testRemove4() {

    }

    @Test
    public void testReplace() {
    LinkedList<Integer> list = new LinkedList<>();
     Integer[] array = {2,6,7,8,5,6,7,8,9};
     
     Integer[] expected = {2,6,7,9,5,6,7,9,9};
     
     assertTrue(list.add(array));
     assertTrue(list.replace(8, 9, element -> element.equals(8)));
     assertEquals(9,list.size());
     
     int i = 0;
     for(Iterator<Integer> it =list.iterator(); it.hasNext();){
         assertEquals(expected[i++],it.next());
     }
        
    }

    @Test
    public void testReplace2() {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = {2,6,7,8,5,6,7,8,9};

        Integer[] expected = {2,10,2,9,5,10,2,9,9};

        assertTrue(list.add(array));
        assertTrue(list.replace(new Integer[]{8, 7, 6}, new Integer[]{9, 2, 10}, element -> {
            int value = element.intValue();
            return value == 8 || value == 7 || value == 6;
        }));

        assertEquals(9, list.size());

        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testReplace3() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> collection = new LinkedList<>();
        LinkedList<Integer> newCollection = new LinkedList<>();

        Integer[] array = {2, 6, 7, 8, 5, 6, 7, 8, 9};
        Integer[] array3 = {9, 2, 10};
        Integer[] array4 = {8, 7, 6};

        Integer[] expected = {2, 10, 2, 9, 5, 10, 2, 9, 9};

        // Agregar elementos a la lista original
        assertTrue(list.add(array));

        // Agregar elementos a la colección original y a la nueva colección
        collection.add(array4);
        newCollection.add(array3);

        // Realizar el reemplazo
        assertTrue(list.replace(collection, newCollection, element -> {
            int value = element;
            return value == 8 || value == 7 || value == 6;
        }));

        // Verificar el tamaño de la lista
        assertEquals(9, list.size());

        // Verificar los elementos de la lista después del reemplazo
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testRetain() {
        // Crear una lista y agregar elementos
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        // Retener solo los elementos 2, 3, 4
        assertTrue(list.retain(new Integer[] {2, 3, 4}));
        
        // Verificar el tamaño y los elementos retenidos
        assertEquals(3, list.size());
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertTrue(list.contains(4));
        assertFalse(list.contains(1));
        assertFalse(list.contains(5));
        
        // Intentar retener un array vacío
        assertFalse(list.retain(new Integer[] {}));
        assertEquals(3, list.size()); // La lista no debe cambiar
        
        // Intentar retener elementos que no están en la lista
        assertFalse(list.retain(new Integer[] {6, 7}));
        assertEquals(0, list.size()); // La lista debería quedar vacía
        
        // Crear una nueva lista y agregar elementos
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        
        // Retener solo los elementos de list2 que están en la lista original
        assertTrue(list2.retain(new Integer[] {2, 3, 6, 7}));
        
        // Verificar el tamaño y los elementos retenidos
        assertEquals(2, list2.size());
        assertTrue(list2.contains(2));
        assertTrue(list2.contains(3));
        assertFalse(list2.contains(1));
        assertFalse(list2.contains(4));
    }

    @Test
    public void testRetain2() {
        // Crear una lista y agregar elementos
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        // Caso 1: Retener elementos de una LinkedList
        LinkedList<Integer> elementsToRetainList = new LinkedList<>();
        elementsToRetainList.add(2);
        elementsToRetainList.add(3);
        elementsToRetainList.add(4);
        assertTrue(list.retain(elementsToRetainList));
        assertEquals(3, list.size());
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertTrue(list.contains(4));
        assertFalse(list.contains(1));
        assertFalse(list.contains(5));
        
        // Caso 2: Retener elementos de un Array
        list.clear(); // Limpiar la lista para el siguiente caso
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Integer[] elementsToRetainArray = {2, 3, 4};
        assertTrue(list.retain(elementsToRetainArray));
        assertEquals(3, list.size());
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertTrue(list.contains(4));
        assertFalse(list.contains(1));
        assertFalse(list.contains(5));
        
        // Caso 3: Retener elementos de una colección vacía
        list.clear(); // Limpiar la lista para el siguiente caso
        list.add(1);
        list.add(2);
        list.add(3);
        assertFalse(list.retain(new LinkedList<>()));
        assertEquals(3, list.size());
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        
        // Caso 4: No retener elementos si no hay elementos comunes
        list.clear(); // Limpiar la lista para el siguiente caso
        list.add(1);
        list.add(2);
        list.add(3);
        LinkedList<Integer> elementsNoCommon = new LinkedList<>();
        elementsNoCommon.add(4);
        elementsNoCommon.add(5);
        assertFalse(list.retain(elementsNoCommon));
        assertEquals(0, list.size());
        
    }

    @Test
    public void testReverse() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        assertTrue(list.reverse());
        Object[] expected = {4,3,2,1};
        int ii = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[ii++], it.next());
        }
    }

    @Test
    public void testSet() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.set(3, 5)); // Cambiar el valor en la posición 0 a 5
        Integer[] expected = {1, 2, 5}; // Ahora esperamos que el valor en la posición 0 sea 5
        int contador = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            assertEquals(expected[contador++], it.next());
        }
    }

    @Test
    public void testSort() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);
        list.add(6);
    
        assertTrue(list.sort(Integer::intValue));
    
        Integer[] expected = {1, 3, 5, 6, 8};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        } 
    }
}
