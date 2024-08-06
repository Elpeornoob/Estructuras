package bryan.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Test;

import bryan.util.iterator.Iterator;

public class ArrayTest {
    @Test
    public void testAdd() {
        Array<Integer> array = new Array<>(6);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(45));
        
        assertEquals(5, array.size());;
        
        Object[] expected = {4,5,7,78,45,null};
        int i = 0;
        for(Iterator<Integer> it = array.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testAdd2() {
        Array<Integer> array = new Array<>(20);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(45));
        assertTrue(array.add(44));
        assertTrue(array.add(55));
        assertTrue(array.add(76));
        assertTrue(array.add(28));
        assertTrue(array.add(85));
        
        Integer[] elements = {12,56,78,44,3,2,56,4,34,67};
        assertTrue(array.add(10, elements));
        
        Object[] expected = {4,5,7,78,45,44,55,76,28,85,12,56,78,44,3,2,56,4,34,67};
        int i = 0;
        for(Iterator<Integer> it = array.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }

    }

    @Test
    public void testAdd3() {

    }

    @Test
    public void testClear() {
        Array<Integer> array = new Array<>(6);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(45));
        assertEquals(5, array.size());

        assertTrue(array.clear());

        Object[] expected = {null,null,null,null,null,null};
        int i = 0;
        for(Iterator<Integer> it = array.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }

    }

    @Test
    public void testContains() {
        Array<Integer> array = new Array<>(6);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(45));
        assertEquals(5, array.size());

        assertTrue(array.contains(4));
    }

    @Test
    public void testContains2() {
        Array<Integer> array = new Array<>(6);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(45));
        assertEquals(5, array.size());

        Integer[] expected = {5,4,7};
        assertTrue(array.contains(expected));
    }

    @Test
    public void testContains3() {

    }

    @Test
    public void testDefragment() {
        Array<Integer> array = new Array<>(7);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(null));
        assertTrue(array.add(null));
        assertTrue(array.add(74));
        assertTrue(array.add(68));
        assertTrue(array.add(81));

        array.defragment();

        Object[] expected = {4,5,74,68,81,null,null};
        int i = 0;
        for(Iterator<Integer> it = array.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }

    }

    @Test
    public void testDimension() {
        Array<Integer> array = new Array<>(6);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(45));
        assertEquals(5, array.size());
        
        assertTrue(array.dimension(10));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(45));

        assertEquals(9, array.size());
        Object[] expected = {4,5,7,78,45,5,7,78,45,null};
        int i = 0;
        for(Iterator<Integer> it = array.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }

    }

    @Test
    public void testForEach() {

    }

    @Test
    public void testGet() {
        Array<Integer> array = new Array<>(6);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(45));
        assertEquals(5, array.size());
        Object element = array.get(2);
        assertEquals(7, element);
    }

    @Test
    public void testIndexOf() {
        Array<Integer> array = new Array<>(6);
        assertTrue(array.add(4));
        assertTrue(array.add(78));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(45));
        assertEquals(5, array.size());
        Object element = array.indexOf(78);
        assertEquals(1, element);

    }

    @Test
    public void testIsEmpty() {
        Array<Integer> array = new Array<>(6);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(45));
        assertEquals(5, array.size());
        assertFalse(array.isEmpty());
        assertTrue(array.clear());
        assertTrue(array.isEmpty());

    }

    @Test
    public void testIterator() {

    }

    @Test
    public void testLastIndex() {
        Array<Integer> array = new Array<>(6);
        assertTrue(array.add(4));
        assertTrue(array.add(78));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(45));
        assertEquals(5, array.size());
        Object element = array.lastIndex(78);
        assertEquals(3, element);

    }

    @Test
    public void testRemove() {
        Array<Integer> array= new Array<>(7);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(74));
        assertTrue(array.add(68));
        assertTrue(array.add(81));

        assertTrue(array.remove(2));
        assertTrue(array.remove(3));

        Object[] expected = {4,5,78,68,81,null,null};
        int i = 0;
        for(Iterator<Integer> it = array.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testRemove2() {
        Array<Integer> array= new Array<>(7);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(74));
        assertTrue(array.add(78));
        assertTrue(array.add(81));

        Predicate<Integer> filtro = t -> t != null && t == 78;
        assertTrue(array.remove(filtro));

        Object[] expected = {4,5,7,74,81,null,null};
        int i = 0;
        for(Iterator<Integer> it = array.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testRemove3() {
        Array<Integer> array= new Array<>(7);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(74));
        assertTrue(array.add(78));
        assertTrue(array.add(81));

        assertTrue(array.remove(1, 4));

        Object[] expected = {4,78,81,null,null,null,null};
        int i = 0;
        for(Iterator<Integer> it = array.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testReverse() {
        Array<Integer> array= new Array<>(7);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(74));
        assertTrue(array.add(78));
        assertTrue(array.add(81));

        assertTrue(array.reverse());
        Object[] expected = {81,78,74,78,7,5,4};
        int i = 0;
        for(Iterator<Integer> it = array.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }

    }

    @Test
    public void testSet() {
        Array<Integer> array= new Array<>(7);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(74));
        assertTrue(array.add(78));
        assertTrue(array.add(81));
        
        assertTrue(array.set(6, 2));
        assertTrue(array.set(1, 9));
        Object[] expected = {4,9,7,78,74,78,2};
        int i = 0;
        for(Iterator<Integer> it = array.iterator(); it.hasNext();){
            assertEquals(expected[i++], it.next());
        }

    }

    @Test
    public void testSize() {
        Array<Integer> array= new Array<>(7);
        assertTrue(array.add(4));
        assertTrue(array.add(5));
        assertTrue(array.add(7));
        assertTrue(array.add(78));
        assertTrue(array.add(74));
        assertTrue(array.add(78));
  
        assertEquals(6, array.size());

    }
}
