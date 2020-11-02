package main;

import java.util.Arrays;

public class OurArrayList implements OurList{

    private Integer[] values = new Integer[0];

    @Override
    public void add(Integer e) {
        Integer[] tmp = new Integer[size() + 1];
        System.arraycopy(values, 0, tmp, 0, size());
        tmp[tmp.length - 1] = e;
        values = tmp;
    }

    @Override
    public Integer get(int index) {
        return values[index];
    }

    @Override
    public void set(int index, Integer e) {
        values[index] = e;
    }

    @Override
    public void remove(int index) {
        Integer[] tmp = new Integer[size() - 1];
        System.arraycopy(values, 0, tmp, 0, index);
        if (index < size() - 1) {
            System.arraycopy(values, index + 1, tmp, index, size() - index - 1);
        }
        values = tmp;
    }

    @Override
    public void clear() {
        values = new Integer[0];
    }

    @Override
    public boolean isEmpty() {
        return values.length == 0;
    }

    @Override
    public int indexOf(Integer e) {
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        for (int i = size() - 1; i >= 0; i--) {
            if (get(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public String toString() {
        return "OurArrayList{ values=" + Arrays.toString(values) + '}';
    }
}
