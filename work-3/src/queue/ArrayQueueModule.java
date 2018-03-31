package queue;

public class ArrayQueueModule {
    // Inv: (for all begin <= i < begin + size: elements[i] != null) && (size <= elements.length)
    private static int begin = 0;
    private static int size = 0;
    private static Object[] elements = new Object[5];

    // Pre: element != null
    public static void enqueue(Object element) {
        ensureCapacity(size + 1);
        elements[(begin + size++) % elements.length] = element;
    }
    // Post: (size' == size + 1) && (elements[(begin + size') % elements.length']' == element)
    // && (for all begin <= i < begin + size: elements[i] == elements[i]')
    // 1) (size + 1 <= elements.length) -> (begin' == begin) && (elements.length' == elements.length)
    // 2) (size + 1 < elements.length) -> (begin' == 0) && (elements.length' == elements.length * 2)

    // Pre: capacity >= 0
    private static void ensureCapacity(int capacity) {
        if (capacity <= elements.length) {
            return;
        }

        elements = copyElementsToArray(new Object[2 * capacity]);
        begin = 0;
    }
    // Post:
    // 1) (capacity <= elements.length) -> (elements.length' == elements.length)
    // 2) (capacity > elements.length) -> (elements.length' == elements.length * 2)

    // Pre: size > 0
    private static Object element() {
        return elements[begin];
    }
    // Post: (R == elements[begin]') && (size' == size) && (begin' == begin)
    // && (for all begin <= i < begin + size: elements[i] == elements[i]')

    // Pre: size > 0
    public static Object dequeue() {
        Object result = element();

        begin = (begin + 1) % elements.length;
        --size;

        return result;
    }
    // Post: (R == elements[begin]') && (begin == (begin' + 1) % elements.length') && (size' = size - 1)
    // && (for all begin' <= i < begin' + size': elements[i] == elements[i]')

    // Pre: true
    public static int size() {
        return size;
    }
    // Post: (R == size) && (size' == size) && (begin' == begin)
    // && (for all begin <= i < begin + size: elements[i] == elements[i]')

    // Pre: true
    public static boolean isEmpty() {
        return size == 0;
    }
    // Post: (size' == size) && (begin' == begin) && (for all begin <= i < begin + size: elements[i] == elements[i]')
    // 1) (size == 0) -> (R == true)
    // 2) (size > 0) -> (R == false)

    // Pre: true
    public static void clear() {
        size = 0;
    }
    // Post: (size' == 0) && (begin' == begin) && (for all begin <= i < begin + size: elements[i] == elements[i]')

    // Pre: true
    public static Object[] toArray() {
        return copyElementsToArray(new Object[size]);
    }
    // Post: (R = Object[size]: Object[i] == elements[(i + const) % elements.length])
    // && (size' == size) && (begin' == begin) && (for all begin <= i < begin + size: elements[i] == elements[i]')

    // Pre: array.length >= elements.length
    private static Object[] copyElementsToArray(Object[] array) {
        int firstPartSize = Math.min(elements.length, begin + size) - begin;
        System.arraycopy(elements, begin, array, 0, firstPartSize);
        System.arraycopy(elements, (begin + firstPartSize) % elements.length, array, firstPartSize, size - firstPartSize);
        return array;
    }
    // Post: (R = Object[size]: Object[i] == elements[(i + const) % elements.length])
    // && (size' == size) && (begin' == begin) && (for all begin <= i < begin + size: elements[i] == elements[i]'))
}
