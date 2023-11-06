public class MyQueue<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public void add(Object value) {
        if (isEmpty()) {
            head = new Node<E>(null, null, (E) value);
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

    public void clear() {
        while (!isEmpty()) {
            //    очищає колекцію
            poll();
        }
    }

    public int size() {
        return size;
    }

    public E peek() {
        //    повертає перший елемент з черги
        return head.getData();
    }

    public E poll() {
        //    повертає перший елемент з черги і видаляє його з колекції
        E data = head.getData();
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty");
        } else if (size == 1) {
            head.setData(null);
        } else {
            Node<E> newHead = head.getNext();
            newHead.setPrev(null);
            head.setNext(null);
            head.setData(null);
            head = newHead;
        }
        --size;
        return data;
    }

    public static void main(String[] args) {
        MyQueue<Integer> numbers = new MyQueue<Integer>();
        System.out.println("numbers.size = " + numbers.size);
        numbers.add(111);
        numbers.add(222);
        numbers.add(333);
        numbers.add(444);
        System.out.println("numbers.peek() = " + numbers.peek());
        numbers.add(555);
        numbers.add(666);
        System.out.println("numbers = " + numbers);
        System.out.println("numbers.size() = " + numbers.size());
        System.out.println("numbers.poll() = " + numbers.poll());
        System.out.println("numbers.poll() = " + numbers.poll());
        System.out.println("numbers.size() = " + numbers.size());
        System.out.println("numbers = " + numbers);
        numbers.clear();
        System.out.println("numbers.size() = " + numbers.size());

    }

    public boolean isEmpty() {
        return size == 0;
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