package queue;

public class ArrayQueue extends AbstractQueue {
    private int begin = 0;
    private Object[] elements = new Object[5];

    protected void assignPushed(Object element) {
        ensureCapacity(size + 1);
        elements[(begin + size) % elements.length] = element;
    }

    private void ensureCapacity(int capacity) {
        if (capacity <= elements.length) {
            return;
        }

        elements = copyElementsToArray(new Object[2 * capacity]);
        begin = 0;
    }

    protected Object getBegin() {
        return elements[begin];
    }

    protected void moveBegin() {
        begin = (begin + 1) % elements.length;
    }

    protected void clearImpl() {
        begin = 0;
    }

    private Object[] copyElementsToArray(Object[] array) {
        int firstPartSize = Math.min(elements.length, begin + size) - begin;
        System.arraycopy(elements, begin, array, 0, firstPartSize);
        System.arraycopy(elements, (begin + firstPartSize) % elements.length, array, firstPartSize, size - firstPartSize);
        return array;
    }
}
