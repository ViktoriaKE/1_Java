package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * A generic container class that can hold a variable number of objects with a <b>head</b> property.
 * @param <T> the type of elements in this container
 */
public class Container<T> implements Iterable<T> {

    /**
     * The head of the list.
     */
    private Node<T> head;

    /**
     * The size of the container.
     */
    private int size;

    /**
     * Constructor that creates an empty container.
     */
    public Container() {
        head = null;
        size = 0;
    }

    /**
     * Inner static class representing a node in the linked list.
     * @param <T> the type of data stored in the node
     */
    private static class Node<T> {
        T value;
        Node<T> nextNode;

        /**
         * Constructor for the node with specified data.
         * @param value - the value to be stored in the node
         */
        Node(T value) {
            this.value = value;
            nextNode = null;
        }
    }

    /**
     * Method to add a new element to the end of the container.
     * @param value - the value to be added
     */
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
        size++;
    }

    /**
     * Method to retrieve an element from the list by its index.
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.nextNode;
        }
        return currentNode.value;
    }

    /**
     * Method to remove an element by its index.
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            head = head.nextNode;
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = currentNode.nextNode.nextNode;
        }
        size--;
    }

    /**
     * Method to get the number of elements in the container.
     * @return the size of the container
     */
    public int size() {
        return size;
    }

    /**
     * Method to return an iterator for sequential traversal of the elements contained in the container.
     * @return an iterator for the container
     */
    @Override
    public Iterator<T> iterator() {
        return new ContainerIterator();
    }

    /**
     * Inner class implementing the iterator for the container.
     */
    private class ContainerIterator implements Iterator<T> {

        private Node<T> current = head;

        /**
         * Checks if there is a next element in the container.
         * @return true if there is a next element, otherwise false
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Method to return the next element from the container.
         * @return the next element
         * @throws NoSuchElementException if no more elements exist
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.nextNode;
            return value;
        }
    }

    /**
     * Method to return a string representation of the container.
     * @return a string representing the elements in the container
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.value);
            currentNode = currentNode.nextNode;
            if (currentNode != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Method to compute the hash code for the container based on its contained elements.
     * @return the hash code of the container
     */
    @Override
    public int hashCode() {
        int result = 1;
        Node<T> currentNode = head;
        while (currentNode != null) {
            result = 31 * result + (currentNode.value != null ? currentNode.value.hashCode() : 0);
            currentNode = currentNode.nextNode;
        }
        return result;
    }
}
