package session6;

public interface Mylistido<E> extends Iterable<E> {

    void add(E e);

    void add(int index, E e);

    void clear();

    boolean contains(E e);

    E get(int index);

    int indexOf(E e);

    boolean isEmpty();

    int lastIndexOf(E e);

    boolean remove(E e);

    E remove(int index);

    Object set(int index, E e);

    int size();
}