package lesson2.linkedArray;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int size;


    public void insertFirst(T item) {
        Node newNode = new Node(item, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        T temp = first.getValue();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return temp;
    }



    public void insertLast(T item) {
        Node newNode = new Node(last, item, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        T temp = last.getValue();
        if (last.getPrev() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        return temp;
    }

    public T getItemOnIndex(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index: " + index);
        }

        T temp = first.getValue();
        if (index == 0){
            return first.getValue();
        } else {
            first = first.getNext();
            Node current = first;

            return current.getValue();
        }
    }


    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        return first.getValue();
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        return last.getValue();
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index: " + index);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size) {
            insertLast(item);
            return;
        }

        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        Node newNode = new Node(current, item, current.getNext());
        current.setNext(newNode);
        newNode.getNext().setPrev(newNode);
        size++;
    }

    public boolean remove(T item) {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        if (first.getValue().equals(item)) {
            removeFirst();
            return true;
        }

        Node current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }

        if (current == last) {
            removeLast();
            return true;
        }

        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        size--;
        return true;
    }

    public boolean contains(T item) {
        return index(item) > -1;
    }

    public int indexOf(T item) {
        return index(item);
    }

    private int index(T item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = first;
        while (current != null) {
            sb.append(current.getValue()).append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter(this);
    }

    private class Iter implements Iterator<T>{
        private int count = 0;
        private int count2 = 0;
        private MyLinkedList myLinkedList;

        public Iter(MyLinkedList myLinkedList) {
            this.myLinkedList = myLinkedList;
        }

        @Override
        public boolean hasNext() {

            if (myLinkedList.isEmpty()) {
                throw new NoSuchElementException();
            } else {
                if (count < myLinkedList.size){
                    return true;
                }

                return false;
            }
        }

        @Override
        public T next() throws NoSuchElementException{

            if (count < myLinkedList.size) {
                int temp = count;
                count++;
                return (T) myLinkedList.getItemOnIndex(temp);
            }
            return null;
        }
    }

    private class Node {
        Node prev;
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Node prev, T value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }


}
