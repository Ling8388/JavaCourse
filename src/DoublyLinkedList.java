
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.UnaryOperator;

public class DoublyLinkedList <E> implements List3130<E> {
    private static class Node<E> {
        private E data;
        private Node<E> previous; // pointer to previous node
        private Node<E> next;     // pointer to next node

        public Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public Node(E data) {
            this(data, null, null);
        }
    }

    private Node<E> head;   // pointer to the first node of this list
    private Node<E> tail;   // pointer to the last node of this list
    private int size;       // the number of nodes currently in this list

    public DoublyLinkedList() {
        tail = head = null;
        size = 0;
    }
    public void addFirst (E element) {
        Node newNode = new Node(element);
        if(head == null){
            head = tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }
        size ++;
    }

    public void addLast (E element) {
        Node newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
            head.previous = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
        size++;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        Node<E> current = head;
        while (current != null) {
            joiner.add(current.data.toString());
            current = current.next;
        }
        return joiner.toString();
    }

    public String toReverseString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        Node<E> current = tail;
        while (current != null) {
            joiner.add(current.data.toString());
            current = current.previous;
        }
        return joiner.toString();
    }

    public E removeFirst () {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E result = head.data;
        head = head.next;
        if (head != null) {
            head.previous = null;
        }
        size--;

        if (isEmpty()) {
            tail = null;
        }
        return result;

    }

    public E removeLast () {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E result = tail.data;
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        }
        size--;

        if (isEmpty()) {
            head = null;
        }
        return result;
    }

    public void clear () {
        head = tail = null;
        size = 0;
    }
    public boolean contains (Object o) {
        Node<E> current = head;
        while (current != null) {
            if(current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public boolean add (E e) {
        addLast(e);
        return true;
    }

    public boolean remove (Object o) {
        Node<E> current = head, previous = null;

        while (current != null) {
            if (current.data.equals(o)) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    previous.next = current.next;
                    current.next.previous = previous;
                    size--;
                }

                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean equals (Object o) {
        if (o instanceof DoublyLinkedList) {
            DoublyLinkedList<?> other = (DoublyLinkedList<?>) o;
            if (this.size != other.size) {
                return false;
            }

            Node<E> current1 = this.head;
            Node<?> current2 = other.head;

            while (current1 != null && current2 != null) {
                if (!current1.data.equals(current2.data)) {
                    return false;
                }
                current1 = current1.next;
                current2 = current2.next;
            }
            return true;
        } else {
            return false;
        }
    }

    public int indexOf (Object o) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            current = current.next;
            index ++;
        }
        return -1;
    }

    public int lastIndexOf (Object o) {
        int index = -1;
        Node<E> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (current.data.equals(o)) {
                index = currentIndex;
            }
            current = current.next;
            currentIndex++;
        }
        return index;
    }

    public E get (int index) {
        Objects.checkIndex(index, size);
        Node<E> current = head;
        int i = 0;
        while (i < index) {
            current =current.next;
            i++;
        }
        return current.data;
    }

    public E set (int index, E element) {
        Objects.checkIndex(index, size);
        Node<E> current = head;
        int i = 0;
        while (i < index) {
            current =current.next;
            i++;
        }
        E result = current.data;
        current.data= element;
        return result;
    }

    public void add (int index, E element) {
        Objects.checkIndex(index, size+1);
        if (index == 0) {
            addFirst(element);
            return;
        }
        if(index == size) {
            addLast(element);
            return;
        }
        Node<E> current = head;
        int i = 0;
        while (i < index-1) {
            current =current.next;
            i++;
        }
        Node<E> newNode = new Node<>(element);
        newNode.next = current.next;
        current.next = newNode;
        newNode.previous = current;
        newNode.next.previous = newNode;
        size++;
    }

    public E remove (int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            return removeFirst();
        }
        if(index == size-1) {
            return removeLast();
        }
        Node<E> current = head;      // [a, b, c, d, e]  index=2
        int i = 0;
        while (i < index-1) {
            current = current.next;
            i++;
        }

        E result = current.next.data;
        current.next = current.next.next;
        current.next.previous = current;
        size--;

        return result;
    }

    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<E> {
        private Node<E> itCurrent;
        private Node<E> prev;
        public DoublyLinkedListIterator() {
            itCurrent = head;
            prev = null;
        }
        boolean hasCalled = false;

        @Override
        public boolean hasNext() {
            return itCurrent != null;
        }

        @Override
        public E next (){
            if (! hasNext()) {
                throw new NoSuchElementException();
            }
            E result = itCurrent.data;
            prev = itCurrent;
            itCurrent = itCurrent.next;
            hasCalled = true;
            return result;
        }

        @Override
        public void remove() {
            if (!hasCalled) {
                throw new IllegalStateException();
            }

            if (prev == head) {
                removeFirst();
            }

            if (prev == tail) {
                removeLast();
            }

            if (prev.previous != null && itCurrent != null) {
                prev.previous.next = itCurrent;
                prev.next.previous = prev.previous;
                size--;
            }
            hasCalled = false;
        }
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        for (int i = 0; i < size(); i++) {
            set(i, operator.apply(get(i)));
        }
    }

}
