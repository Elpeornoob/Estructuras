package bryan.stack.array;

import java.util.function.Function;

import bryan.array.Array;
import bryan.util.collection.Collection;
import bryan.util.iterator.Iterator;
import bryan.util.stack.AbstractStack;

public class Stack<E> extends AbstractStack<E>{
    private Array<E> elements;
    @SuppressWarnings("unused")
    private int indicador;
    @SuppressWarnings("unused")
    private int lenght ;

    public Stack(int lenght){
        this.elements = new Array<>(lenght); 
        indicador = 0;
    }

    @Override
    public E peek() {
        return elements.get(0);
    }

    @Override
    public E pop() {
        int indexE = elements.size() - 1;
        E element = elements.get(indexE);
        elements.remove(elements.size()-1);
        return element;
    }

    @Override
    public boolean push(E element) {
        return elements.add(element);
    }

    @Override
    public boolean clear() {
        return elements.clear();
    }

    @Override
    public boolean contains(E element) {
        return elements.contains(element);
    }

    @Override
    public boolean contains(E[] array) {
        return elements.contains(array);
    }

    @Override
    public boolean contains(Collection<E> collection) {
        return elements.contains(collection);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean reverse() {
        return elements.reverse();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void forEach(Function<E, Void> action) {
        elements.forEach(action);
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }
    
}
