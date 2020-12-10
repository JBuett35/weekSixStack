/** Created by James Buettner on Thursday, December 10, 2020 for CSC 422. */

public class Stack<E> {
    private E array[];
    private int size;
    // default constructor
    public Stack() {
        // initializing an array of 20 elements
        array = (E[]) new Object[20];
        // initializing size to 0
        size = 0;
    }
    // constructor taking an initial capacity
    public Stack(int capacity) {
        // if capacity is invalid, using default size
        if (capacity < 0) {
            array = (E[]) new Object[20];
        } else {
            // otherwise initializing the array with specified capacity
            array = (E[]) new Object[capacity];
        }
        size = 0;
    }
    // removes and returns the current top element
    public E pop() throws EmptyStackException {
        // throwing exception if empty
        if (size == 0) {
            throw new EmptyStackException();
        }
        // getting data at index size-1
        E data = array[size - 1];
        // decrementing size
        size--;
        // returning removed data
        return data;
    }
    // returns the top element without removing
    public E peek() throws EmptyStackException {
        // throwing exception if empty
        if (size == 0) {
            throw new EmptyStackException();
        }
        // returning top element
        return array[size - 1];
    }
    // adds an element to the top
    public void push(E item) throws FullStackException {
        // throwing exception if full
        if (size == array.length) {
            throw new FullStackException();
        }
        // adding element to index size
        array[size] = item;
        // incrementing size
        size++;
    }
    // returns true if stack is empty, else false
    public boolean empty() {
        return size == 0;
    }
}
// classes for representing Exceptions when stack is full and empty
class FullStackException extends Exception {
    public FullStackException() {
        super("Stack is full!");
    }
}
class EmptyStackException extends Exception {
    public EmptyStackException() {
        super("Stack is empty!");
    }
}