package queue;

public abstract class AbstractQueue implements Queue {
    int size;

    public void enqueue(Object element) {
        assert element != null;
        assignPushed(element);
        ++size;
    }

    protected abstract void assignPushed(Object element);

    public Object element() {
        assert size > 0;
        return getBegin();
    }

    protected abstract Object getBegin();

    public Object dequeue() {
        Object result = element();
        moveBegin();
        --size;
        return result;
    }

    protected abstract void moveBegin();

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        clearImpl();
        size = 0;
    }

    protected abstract void clearImpl();

    public Object[] toArray() {
        Object[] result = new Object[size];
        int copied = 0;
        while (size > 0) {
            result[copied++] = dequeue();
        }
        for (Object i : result) {
            enqueue(i);
        }
        return result;
    }
}
