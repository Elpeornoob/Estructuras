package bryan.util.queue;

public interface Queue<E> {
    
   E peek();
   
   E extract();
   
   boolean insert(E element);
}
