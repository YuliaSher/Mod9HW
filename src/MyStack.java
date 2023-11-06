public class MyStack<E> {
    //  LIFO (last-in-first-out)
//  У домашньому завданні помилка: для того, щоб зберігався принцип LIFO, треба щоб
//  методи push(Object value), peek() та рор() працювали з одними й тими ж елементами:
//  або першими, або останніми. В мене вони будуть працювати з останніми
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public void push(Object value) {
        if (isEmpty()) {
            head = new Node<>(null, null, (E) value);
        } else if (tail == null) {
            tail = new Node<E>(head, null, (E) value);
            head.setNext(tail);
        } else {
            Node<E> newTail = new Node<>(tail, null, (E) value);
            tail.setNext(newTail);
            tail = newTail;
        }
        size++;
    }

    public E remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        Node<E> currentNode = head;
        if (index>=size){
            throw new IndexOutOfBoundsException("You have entered incorrect index. Try numbers between 0 and " + (size - 1));
        } else {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            E data = currentNode.getData();
            currentNode.getPrev().setNext(currentNode.getNext());
            currentNode.getNext().setPrev(currentNode.getPrev());
            currentNode.setPrev(null);
            currentNode.setNext(null);
            currentNode.setData(null);
            --size;
            return data;
        }

    }

    public void clear() {
        while (!isEmpty()) {
            pop();
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
//    повертає останній елемент стекy
        return tail.getData();
    }

    public E pop() {
//    повертає останній елемент стеку та видаляє його з колекції
        E data = tail.getData();
        if (tail.getPrev() == null) {
            tail.setPrev(null);
            tail.setData(null);
        } else {
            Node<E> newTail = tail.getPrev();
            newTail.setNext(null);
            tail.setPrev(null);
            tail.setData(null);
            tail = newTail;
        }
        --size;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyStack<String> words = new MyStack<String>();
        words.push("Go");
        words.push("pound");
        words.push("sand");
        words.push("and");
        words.push("kick");
        System.out.println("words.peek() = " + words.peek());
        words.push("some");
        words.push("rocks");
        words.push("too");
        System.out.println("words = " + words);
        words.pop();
        System.out.println("words = " + words);
        words.pop();
        System.out.println("words = " + words);
        words.push("football");
        System.out.println("words = " + words);
        System.out.println("words.remove(5) = " + words.remove(5));
        words.push("ball");
        System.out.println("words = " + words);
        words.clear();
        System.out.println("words = " + words);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }
}