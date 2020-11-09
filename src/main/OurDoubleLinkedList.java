package main;

public class OurDoubleLinkedList implements OurList{

    private class Element {
        Integer value;
        Element next = null;
        Element prev = null;

        public Element(Integer value) {
            this.value = value;
        }
    }

    private Element first = null;
    private Element last = null;
    private int size = 0;

    @Override
    public void add(Integer e) {
        Element newElement = new Element(e);
        if (first == null) {
            first = newElement;
            last = first;
        } else {
            last.next = newElement;
            newElement.prev = last;
            last = newElement;
        }
        size++;
    }

    @Override
    public Integer get(int index) {
        if (first == null || index < 0) {
            return null;
        }
        Element tmp = null;
        if (index < size() / 2) {
            tmp = first;
            for (int i = 0; i < index; i++) {
                try {
                    tmp = tmp.next;
                } catch (NullPointerException e) {
                    return null;
                }
            }
            try {
                return tmp.value;
            } catch (NullPointerException e) {
                return null;
            }
        } else {
            tmp = last;
            for (int i = size() - 1; i > index; i--) {
                try {
                    tmp = tmp.prev;
                } catch (NullPointerException e) {
                    return null;
                }
            }
            try {
                return tmp.value;
            } catch (NullPointerException e) {
                return null;
            }
        }
    }

    @Override
    public void set(int index, Integer e) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int indexOf(Integer e) {
        return 0;
    }

    @Override
    public int lastIndexOf(Integer e) {
        return 0;
    }

    @Override
    public int size() {
//        if (first == null) {
//            return 0;
//        }
//        Element tmp = first;
//        int counter = 1;
//        while (tmp.next != null) {
//            tmp = tmp.next;
//            counter++;
//        }
//        return counter;
        return size;
    }
}
