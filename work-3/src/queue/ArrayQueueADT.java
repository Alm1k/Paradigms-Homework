package queue;

public class ArrayQueueADT {
    // Inv: (for all begin <= i < begin + size: elements[i] != null) && (size <= elements.length)
    private int begin = 0;
    private int size = 0;
    private Object[] elements = new Object[5];

    // Pre: element != null
    public static void enqueue(ArrayQueueADT q, Object element) {
        ensureCapacity(q, q.size + 1);
        q.elements[(q.begin + q.size++) % q.elements.length] = element;
    }
    // Post: (size' == size + 1) && (elements[(begin + size') % elements.length']' == element)
    // && (for all begin <= i < begin + size: elements[i] == elements[i]')
    // 1) (size + 1 <= elements.length) -> (begin' == begin) && (elements.length' == elements.length)
    // 2) (size + 1 < elements.length) -> (begin' == 0) && (elements.length' == elements.length * 2)

    // Pre: capacity >= 0
    private static void ensureCapacity(ArrayQueueADT q, int capacity) {
        if (capacity <= q.elements.length) {
            return;
        }

        q.elements = copyElementsToArray(q, new Object[2 * capacity]);
        q.begin = 0;
    }
    // Post:
    // 1) (capacity <= elements.length) -> (elements.length' == elements.length)
    // 2) (capacity > elements.length) -> (elements.length' == elements.length * 2)

    // Pre: size > 0
    private static Object element(ArrayQueueADT q) {
        return q.elements[q.begin];
    }
    // Post: (R == elements[begin]') && (size' == size) && (begin' == begin)
    // && (for all begin <= i < begin + size: elements[i] == elements[i]')

    // Pre: size > 0
    public static Object dequeue(ArrayQueueADT q) {
        Object result = element(q);

        q.begin = (q.begin + 1) % q.elements.length;
        --q.size;

        return result;
    }
    // Post: (R == elements[begin]') && (begin == (begin' + 1) % elements.length') && (size' = size - 1)
    // && (for all begin' <= i < begin' + size': elements[i] == elements[i]')

    // Pre: true
    public static int size(ArrayQueueADT q) {
        return q.size;
    }
    // Post: (R == size) && (size' == size) && (begin' == begin)
    // && (for all begin <= i < begin + size: elements[i] == elements[i]')

    // Pre: true
    public static boolean isEmpty(ArrayQueueADT q) {
        return q.size == 0;
    }
    // Post: (size' == size) && (begin' == begin) && (for all begin <= i < begin + size: elements[i] == elements[i]')
    // 1) (size == 0) -> (R == true)
    // 2) (size > 0) -> (R == false)

    // Pre: true
    public static void clear(ArrayQueueADT q) {
        q.size = 0;
    }
    // Post: (size' == 0) && (begin' == begin) && (for all begin <= i < begin + size: elements[i] == elements[i]')

    // Pre: true
    public static Object[] toArray(ArrayQueueADT q) {
        return copyElementsToArray(q, new Object[q.size]);
    }
    // Post: (R = Object[size]: Object[i] == elements[(i + const) % elements.length])
    // && (size' == size) && (begin' == begin) && (for all begin <= i < begin + size: elements[i] == elements[i]')

    // Pre: array.length >= elements.length
    private static Object[] copyElementsToArray(ArrayQueueADT q, Object[] array) {
        int firstPartSize = Math.min(q.elements.length, q.begin + q.size) - q.begin;
        System.arraycopy(q.elements, q.begin, array, 0, firstPartSize);
        System.arraycopy(q.elements, (q.begin + firstPartSize) % q.elements.length, array, firstPartSize, q.size - firstPartSize);
        return array;
    }
    // Post: (R = Object[size]: Object[i] == elements[(i + const) % elements.length])
    // && (size' == size) && (begin' == begin) && (for all begin <= i < begin + size: elements[i] == elements[i]'))
}
