package queue;

public class LinkedQueue extends AbstractQueue {
    private Node head;
    private Node tail;

    protected void assignPushed(Object element) {
        Node pushed = new Node(element, null);
        if (isEmpty()) {
            head = tail = pushed;
        }
        else {
            tail.setNext(pushed);
            tail = pushed;
        }
    }

    protected Object getBegin() {
        return head.getValue();
    }

    protected void moveBegin() {
        head = head.getNext();
    }

    protected void clearImpl() {
        head = tail = null;
    }
}
