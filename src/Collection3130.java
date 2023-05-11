import java.util.Iterator;
import java.util.function.Predicate;
public interface Collection3130<E> extends Iterable<E> {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    boolean add(E e);

    boolean remove(Object o);

    void clear();

    default boolean removeIf(Predicate<? super E> filter) {
        Iterator<E> iterator = iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            if (filter.test(iterator.next())) {
                iterator.remove();
                removed = true;
            }
        }

        return removed;
    }
}

