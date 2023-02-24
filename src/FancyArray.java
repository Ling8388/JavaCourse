import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class FancyArray<E> {
    private int sizes;
    private int otherSizes;
    private int anotherSizes;
    private E[] arr;

    public FancyArray() {
        arr = (E[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    public FancyArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative.");
        }
        arr = (E[])new Object[capacity];

    };
    public int size() {
        return sizes;
    };
    public void add(E element) {
        if (sizes == arr.length) {
            throw new IllegalArgumentException("The array is full.");
        }
        arr[sizes] = element;
        sizes++;
    };
    public E get(int index) {
        if (index < 0 || index >= sizes) {
            throw new IllegalArgumentException("The index cannot be negative or greater than or equal to the size.");
        }
        return arr[index];
    };
    public E set(int index, E newElement) {
        if (index < 0 || index >= sizes) {
            throw new IllegalArgumentException("The index cannot be negative or greater than or equal to the size.");
        }
        E temp = arr[index];
        arr[index] = newElement;
        return temp;
    };

    public boolean contains(E s){
        for(E i : arr) {
            if(i != null && i.equals(s)) {
                return true;
            }
        }
        return false;
    };

    @Override
    public String toString() {
        String st = "";
        for (int i=0; i<sizes; i++) {
            if(i>0) {
                st += ",";
            }
            st += arr[i];
        }
        return "[" + st + "]";
    };

    @Override
    public boolean equals(Object o) {
        if(o instanceof FancyArray) {
            FancyArray other = (FancyArray) o;
            if(this.sizes == other.sizes) {
                for (int i=0; i<sizes; i++) {
                    if (!this.arr[i].equals(other.arr[i])) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    };

    public int indexOf(E e) {
        for(int i=0; i<sizes; i++) {
            if(this.arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    };

    public int lastIndexOf(E e) {
        for(int i=sizes-1; i>=0; i--) {
            if(this.arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    };

    public void add(int index, E element) {
        if (sizes == arr.length) {
            throw new IllegalArgumentException("The array is full.");
        } else if (index < 0 || index > sizes) {
            throw new IndexOutOfBoundsException("Error: index.");
        }

        if(index < sizes) {
            for(int i=sizes; i>index; i--) {
                arr[i] = arr[i-1];
            }
        }
        arr[index] = element;
        sizes++;
    }

    public E remove(int index) {
        if(index < 0 || index >= sizes) {
            throw new IndexOutOfBoundsException("Error: index.");
        }
        E[] temp = (E[]) new Object[arr.length];
        E element = arr[index];
        for(int i=0; i<sizes-1; i++) {
            if(i < index) {
                temp[i] = arr[i];
            } else if(i >= index) {
                temp[i] = arr[i+1];
            }
        }
        sizes--;
        arr = temp;
        return element;
    }

    public void addFrom(FancyArray <? extends E> otherArray) {
        otherSizes = sizes;
        for(int i=0; i<otherArray.sizes; i++) {
            this.arr[sizes + i] = otherArray.arr[i];
            otherSizes++;
        }
        sizes  = otherSizes;
    }

    public void addTo(FancyArray <? super E> anotherArray) {
        anotherSizes = anotherArray.sizes;
        for(int i=0; i<this.sizes; i++) {
            anotherArray.arr[sizes + 1 + i] = this.arr[i];
            anotherSizes++;
        }
        anotherArray.sizes = anotherSizes;
    }

    public void forEach(Consumer<? super E> action) {
        for(int i=0; i<this.sizes; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void replaceAll(UnaryOperator<E> uo) {
        for(int i=0; i<this.sizes; i++) {
            arr[i] = uo.apply(arr[i]);
        }
    }

    public E max(Comparator<? super E> c) {
        E max = arr[0];
        for(int i=1; i<this.sizes; i++) {
            if(c.compare(max, arr[i])<0){
                max = arr[i];
            }
        }
        return max;
    }

    public void sort(Comparator<? super E> c) {
        E temp;
        for(int i=0; i<this.sizes; i++) {
            for(int j=i+1; j<this.sizes; j++) {
                if(c.compare(arr[i], arr[j])>0){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


}

