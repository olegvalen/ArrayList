import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements Cloneable, Iterable {

    private T[] ar;
    private int curIndex = 0;

    public T[] getAr() {
        return ar;
    }

    public void setAr(T[] ar) {
        this.ar = ar;
    }

    public int getCurIndex() {
        return curIndex;
    }

    public ArrayList(int size) {
        ar = (T[]) new Object[size];
    }


    public void add(T item) {
        if (curIndex == ar.length) {
            T[] tmp = (T[]) new Object[ar.length * 2];
            for (int i = 0; i < ar.length; i++) {
                tmp[i] = ar[i];
            }
            ar = tmp;
        }
        ar[curIndex++] = item;
    }

    public void addAll(T[] from) {
        for (int i = 0; i < from.length; i++) {
            add(from[i]);
        }
    }

    public void clear() {
        ar = (T[]) new Object[2];
        curIndex = 0;
    }

    public boolean contain(T item) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].equals(item))
                return true;
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index > ar.length - 1) throw new IndexOutOfBoundsException();
        return ar[index];
    }


    public int indexOf(T item) {
        int index = 0;
        while (index != ar.length - 1 && !ar[index].equals(item)) {
            index++;
        }
        if (!ar[index].equals(item)) throw new NoSuchElementException();
        return index;
    }


    public boolean isEmpty() {
        if (curIndex == 0) return true;
        return false;
    }

    public void remove(int index) {
        if (index < 0 || index > ar.length - 1) throw new IndexOutOfBoundsException();
        T[] tmp = (T[]) new Object[ar.length - 1];
        if (index > 0) {
            for (int i = 0; i <= index - 1; i++) {
                tmp[i] = ar[i];
            }
        }
        if (index + 1 <= ar.length - 1) {
            for (int i = index + 1; i <= ar.length - 1; i++) {
                tmp[i - 1] = ar[i];
            }
        }
        ar = tmp;
        curIndex--;
    }

    public void remove(T item) {
        int index = 0;
        while (index != ar.length - 1 && !ar[index].equals(item)) {
            index++;
        }
        if (!ar[index].equals(item)) throw new NoSuchElementException();
        remove(index);
    }

    public void removeAll(ArrayList<T> from) {
        for (int i = 0; i < from.ar.length; i++) {
            remove(from.ar[i]);
        }
    }

    public void retainAll(ArrayList<T> from) {
        int newCurIndex = 0;
        T[] tmp = (T[]) new Object[from.ar.length];
        int index = 0;
        for (int i = 0; i < from.ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (from.ar[i].equals(ar[j])) {
                    tmp[index++] = from.ar[i];
                    newCurIndex++;
                }
            }
        }
        ar = tmp;
        curIndex = newCurIndex;
    }

    public void set(int index, T item) {
        if (index < 0 || index > ar.length - 1) throw new IndexOutOfBoundsException();
        ar[index] = item;
    }

    public int size() {
        return ar.length;
    }

    public void subList(int a, int b) {
        if (a < 0 || a > ar.length || b < 0 || b > ar.length || a > b) throw new IndexOutOfBoundsException();
        int index = 0;
        T[] tmp = (T[]) new Object[b - a + 1];
        for (int i = a; i <= b; i++) {
            tmp[index++] = ar[i];
        }
        ar = tmp;
    }

    public void reverse() {
        T[] tmp = (T[]) new Object[ar.length];
        int index = 0;
        for (int i = ar.length - 1; i >= 0; i--) {
            tmp[index++] = ar[i];
        }
        ar = tmp;
    }

    @Override
    protected ArrayList<T> clone() throws CloneNotSupportedException {
        return (ArrayList<T>) super.clone();
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int curIndex2 = 0;

            @Override
            public boolean hasNext() {
                return curIndex2 < ar.length && ar[curIndex2] != null;
            }

            @Override
            public T next() {
                return ar[curIndex2++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            al.add(i);
        }
        for (Object i : al)
            System.out.println(i);
    }
}
