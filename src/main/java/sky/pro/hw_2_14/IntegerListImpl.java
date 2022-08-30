package sky.pro.hw_2_14;

import java.lang.reflect.Array;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {

    private static final int INITIAL_SIZE = 15;

    private Integer[] data;
    private int capacity;


    public IntegerListImpl() {
        data = new Integer[INITIAL_SIZE];
        capacity = 0;
    }

    public IntegerListImpl(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размер должен быть положительным");
        }
        data = new Integer[n];
        capacity = 0;
    }

    @Override
    public Integer add(Integer item) {
        if (capacity >= data.length) {
            throw new IllegalArgumentException("Список полон");
        }
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        }
        return data[capacity++] = item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (capacity >= data.length) {
            throw new IllegalArgumentException("Список полон");
        }
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не должен быть отрицательный");
        }
        if ((index > capacity)) {
            throw new IllegalArgumentException("Индекс" + index + " , Размер: " + capacity);
        }
        System.arraycopy(data, index, data, index + 1, capacity - index);
        data[index] = item;
        capacity++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не должен быть отрицательным");
        }
        if ((index >= capacity)) {
            throw new IllegalArgumentException("Индекс: " + index + ", Размер: " + capacity);
        }
        return data[index] = item;
    }

    @Override
    public Integer remove(Integer item) {
        int indexForRemoving = indexOf(item);
        if (indexForRemoving == -1) {
            throw new IllegalArgumentException("Элемент не найден");
        }

        return remove(indexForRemoving);
    }

    @Override
    public Integer remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не должен быть отрицательный");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Индекс: " + index + ", Размер: " + capacity);
        }
        Integer removed = data[index];

            System.arraycopy(data, index + 1, data, index, capacity - 1 - index);

        data[--capacity] = null;
        return removed;
    }

    @Override
    public boolean contains(Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");

            sort();

            int min = 0;
            int max = capacity - 1;
            while (min <= max) {
                int mid = (min + max) / 2;
                if (item.equals(data[mid])) {
                    return true
                }
                if (item < data[mid]) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
        }
    }

    @Override
    public int indexOf(Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        }
        int index = -1;
        for (int i = 0; i < capacity; i++) {
            if (data[i].equals(item)) {
                index = i;
                break;
            }

        }
        return index;
    }

    @Override
    public int lastIndexOf(Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        }
        int index = -1;
        for (int i = capacity - 1; i >= 0; i--) {
            if (data[i].equals(item)) {
                index = i;
                break;
            }

        }
        return index;
    }

    @Override
    public Integer get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть неотрицательный");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Индекс: " + index + ", Размер: " + capacity);
        }
        return data[index];
    }

    @Override
    public boolean equalsIntegerList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!data[i].equals(otherList.get(i))) {
                return false;
            }

        }
        return true;
}


    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            data[i] = null;
            }
            capacity =0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[capacity];
        System.arraycopy(data, 0, result, 0, capacity);
        return result;
    }
    private void sort() {
        for (int i = 0; i < capacity; i++) {
            int temp = data[i];
            int j = 1;
            while (j > 0 && data[j - 1] >= temp) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = temp;
        }
    }
    private void grow (){
        data = Array.copyOf(data, size + size / 2);
    }
}
