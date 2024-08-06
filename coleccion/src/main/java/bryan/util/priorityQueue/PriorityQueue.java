package bryan.util.priorityQueue;

import bryan.util.queue.Queue;

public interface PriorityQueue<E> extends Queue<E>{

    boolean insert(int index, E element);
}
