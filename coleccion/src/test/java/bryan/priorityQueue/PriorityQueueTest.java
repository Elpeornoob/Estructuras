package bryan.priorityQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PriorityQueueTest {

    @Test
    public void testInsertAndContains() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3);
        priorityQueue.insert(2);
        priorityQueue.insert(1);
        priorityQueue.insert(3);
        assertTrue(priorityQueue.contains(1));
        assertTrue(priorityQueue.contains(2));
        assertTrue(priorityQueue.contains(3));
        assertFalse(priorityQueue.contains(0));
        assertFalse(priorityQueue.contains(4));
    }

    @Test
    public void testInsertAtIndex() {
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(4);
        priorityQueue.insert(0, 'c');
        priorityQueue.insert(1, 'b');
        priorityQueue.insert(1, 'd'); // Inserts 'd' between 'c' and 'b'
        priorityQueue.insert(3, 'a'); // Inserts 'a' at the end
        
        Character expected = 'c';
        assertEquals(expected, priorityQueue.peek());
        assertEquals(4, priorityQueue.size());
        assertEquals(expected, priorityQueue.extract());
    }

    @Test
    public void testPeek() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(2);
        priorityQueue.insert("one");
        priorityQueue.insert("two");
        assertEquals("one", priorityQueue.peek());
    }

    @Test
    public void testExtract() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3);
        priorityQueue.insert(1, 5);
        priorityQueue.insert(0, 3);
        priorityQueue.insert(1, 7);
        Integer expected = 3;
        assertEquals(expected, priorityQueue.extract());
        assertEquals(2, priorityQueue.size());
    }

    @Test
    public void testIsEmpty() {
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(1);
        assertTrue(priorityQueue.isEmpty());
        priorityQueue.insert(4.5);
        assertFalse(priorityQueue.isEmpty());
    }

    @Test
    public void testReverse() {
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(3);
        priorityQueue.insert('c');
        priorityQueue.insert('a');
        priorityQueue.insert('b');
        priorityQueue.reverse();
        Character expected = 'b';
        assertEquals(expected, priorityQueue.extract());
    }
}
