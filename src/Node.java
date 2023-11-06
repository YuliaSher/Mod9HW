public class Node<E> {
    private Node<E> prev;
    private Node<E> next;
    private E data;

    public Node(Node<E> prev, Node<E> next,E data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
