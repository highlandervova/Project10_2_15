package main;

public interface OurList {
    void add(Integer e);
    Integer get(int index);
    void set(int index, Integer e);
    void remove(int index);
    void clear();
    boolean isEmpty();
    int indexOf(Integer e);
    int lastIndexOf(Integer e);
    int size();
}
