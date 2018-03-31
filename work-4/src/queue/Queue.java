package queue;

public interface Queue {
    // Pre: element is not nullable
    void enqueue(Object element);
    // Post: increase SIZE by one

    // Pre: Queue not empty
    Object element();
    // Post: return HEAD of Queue

    // Pre: Queue not empty
    Object dequeue();
    // Post: return HEAD of Queue, delete from Queue and decrease SIZE by one

    // Pre: always true
    int size();
    // Post: return SIZE of Queue

    // Pre: always true
    boolean isEmpty();
    // Post: return TRUE, if SIZE == 0, else return FALSE

    // Pre: always true
    void clear();
    // Post: delete all elements from Queue ans set SIZE to 0

    // Pre: always true
    Object[] toArray();
    // Post: return Queue content as array
}
