package queue;

class Node {
    private Object value;
    private Node next;

    Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }

    Object getValue() {
        return value;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}