import java.util.Collections;
import java.util.function.UnaryOperator;
public interface List3130<E> extends Collection3130<E> {
    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    default void replaceAll(UnaryOperator<E> operator) {
        for (int i = 0; i < size(); i++) {
            set(i, operator.apply(get(i)));
        }
    }
}
