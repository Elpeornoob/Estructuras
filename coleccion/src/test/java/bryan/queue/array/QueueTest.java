package bryan.queue.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bryan.util.iterator.Iterator;

public class QueueTest {

    @Test
    public void testIsEmpty() {
        Queue<Integer> queue = new Queue<>(3);
        assertTrue(queue.isEmpty());

        queue.insert(5);
        assertFalse(queue.isEmpty());

        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testSize() {
        Queue<String> queue = new Queue<>(3);
        assertEquals(0, queue.size());

        queue.insert("a");
        queue.insert("b");
        assertEquals(2, queue.size());

        queue.extract();
        assertEquals(1, queue.size());

        queue.clear();
        assertEquals(0, queue.size());
    }

   @Test
    public void testInsert() {
        Queue<Integer> queue = new Queue<>(3);
        assertTrue(queue.insert(10));  // Insertar un elemento
        assertEquals(1, queue.size()); // Verificar el tamaño después de insertar un elemento

        assertTrue(queue.insert(20));  // Insertar otro elemento
        assertEquals(2, queue.size()); // Verificar el tamaño después de insertar otro elemento

        assertTrue(queue.insert(30));  // Insertar un tercer elemento
        assertEquals(3, queue.size()); // Verificar el tamaño después de insertar un tercer elemento
    }

    @Test
    public void testExtract() {
        Queue<String> queue = new Queue<>(3);
        assertNull(queue.extract()); // Extraer de una cola vacía debe devolver null

        queue.insert("a");
        queue.insert("b");
        queue.insert("c");

        assertEquals("a", queue.extract()); // Extraer el primer elemento
        assertEquals("b", queue.extract()); // Extraer el segundo elemento
        assertEquals("c", queue.extract()); // Extraer el tercer elemento

        assertTrue(queue.isEmpty()); // La cola debe estar vacía después de extraer todos los elementos
    }

    @Test
    public void testContains() {
        Queue<String> queue = new Queue<>(3);
        queue.insert("apple");
        queue.insert("banana");
        queue.insert("cherry");

        assertTrue(queue.contains("banana"));
        assertFalse(queue.contains("grape"));
    }

    @Test
    public void testClear() {
        Queue<Character> queue = new Queue<>(3);
        queue.insert('a');
        queue.insert('b');
        queue.insert('c');

        assertFalse(queue.isEmpty());

        assertTrue(queue.clear());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIterator() {
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        int expected = 1;
        for (Iterator<Integer> it = queue.iterator(); it.hasNext();) {
            assertEquals(Integer.valueOf(expected), it.next());
            expected++;
        }
    }
}
