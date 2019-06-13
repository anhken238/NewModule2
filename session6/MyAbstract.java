package session6;

public abstract class MyAbstract<E> implements Mylistido<E> {
    protected int count = 0;

    protected MyAbstract(){

    }

    protected MyAbstract(E[] objects){
        for (int i = 0; i < objects.length; i++){
            add(objects[i]);
        }
    }

    @Override
    public void add(E e) {
        add(count, e);
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean remove(E e) {
        int index = indexOf(e);
        if(index >= 0){
            remove(index);
            return true;
        }
        return false;
    }
}
