public class MyLinkedList<E> {
    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    public void add(Object value) {
        if (isEmpty()) {
            head = new Node<>(null, null, (E) value);
        } else if (tail == null) {
            tail = new Node<>(head, null, (E) value);
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
            throw new RuntimeException("The list is empty");
        }
        Node<E> currentNode = head;
        if (index >= size) {
            throw new IndexOutOfBoundsException("You have entered incorrect index. Try numbers between 0 and " + (size - 1));
        } else {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.getNext().setPrev(currentNode.getPrev());
            currentNode.getPrev().setNext(currentNode.getNext());

            E value = currentNode.getData();
            currentNode.setData(null);
            currentNode.setNext(null);
            currentNode.setPrev(null);
            --size;
            return value;
        }
    }

    public void clear() {
        Node<E> currentNode = head;
        while (currentNode != null) {
            Node<E> next = currentNode.getNext();
            currentNode.setNext(null);
            currentNode.setPrev(null);
            currentNode.setData(null);
            currentNode = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Node<E> currentNode = head;
        if (index >= size) {
            throw new IndexOutOfBoundsException("You have entered incorrect index. Try numbers between 0 and " + (size - 1));
        } else {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            return currentNode.getData();
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        MyLinkedList<String> phrase = new MyLinkedList<String>();
        phrase.add("Nuttier");
        phrase.add("than");
        phrase.add("a");
        phrase.add("squirrel");
        phrase.add("poo");
        System.out.println("phrase = " + phrase);
        System.out.println("phrase.size = " + phrase.size);
        System.out.println("phrase.get(3) = " + phrase.get(3));
        System.out.println("phrase.remove(3) = " + phrase.remove(3));
        System.out.println("phrase = " + phrase);
        System.out.println("phrase.size = " + phrase.size);
        phrase.clear();
        System.out.println("phrase.size = " + phrase.size);
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