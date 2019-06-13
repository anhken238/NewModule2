package session6;

import java.util.Iterator;

public class MyArraylistido<E> extends MyAbstract<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private E[] elements;

    public MyArraylistido(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArraylistido(int size){
        elements = (E[]) new Object[size];
    }

    public MyArraylistido(E[] objects){
        this();
        for (int i = 0; i < objects.length; i++){
            add(objects[i]);
        }
    }

    @Override
    public void add(int index, E e) {
        ensureCapacity();

        for (int i = count - 1; i >= index; i--){
            elements[i + 1] = elements[i];
        }
        elements[index] = e;
        count++;
    }

    private void ensureCapacity() {
        if(count >= elements.length){
            E[] newElements = (E[]) (new Object[count * 2 + 1]);
            System.arraycopy(elements, 0, newElements, 0, count);
            elements = newElements;
        }
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < count; i++){
            if(e.equals(elements[i]))
                return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < count; i++){
            if(e.equals(elements[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = count - 1; i <= 0; i--){
            if(e.equals(elements[i]))
                return i;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E e = elements[index];

        for (int i = index; i < size() - 1; i++){
            elements[i] = elements[i + 1];
        }

        elements[count - 1] = null;
        count--;
        return e;
    }

    @Override
    public Object set(int index, E e) {
        checkIndex(index);
        E old = elements[index];
        elements[index] = e;
        return old;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<E>{
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < count;
        }

        @Override
        public E next() {
            return elements[currentIndex++];
        }

        @Override
        public void remove() {
            MyArraylistido.this.remove(currentIndex);
        }
    }
}