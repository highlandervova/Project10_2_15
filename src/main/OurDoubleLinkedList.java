package main;

public class OurDoubleLinkedList implements OurList{

    private Element first = null;
    private Element last = null;
    private int size = 0;

    private class Element {
        Integer value;
        Element next = null;
        Element prev = null;

        public Element(Integer value) {
            this.value = value;
        }
    }

    @Override
    public void add(Integer e) {
        Element newElement = new Element(e);
        if (first == null) {
            first = last = newElement;
            first.prev = null;
            last.next = null;
        } else {
            last.next = newElement;
            newElement.prev = last;
            last = newElement;
            last.next = null;
        }
        size++;
    }

    @Override
    public Integer get(int index) {
        {
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
    }

    @Override
    public void set(int index, Integer e) {
        if (first == null || index < 0) {
            return;
        }
        if (index < size / 2) {
            Element tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            tmp.value = e;
        } else {
            Element tmp = last;
            for (int j = size; j > index; j--) {
                tmp = tmp.prev;
            }
            tmp.value = e;
        }
    }

    public void remove(int index) {

        if (first == null || index < 0) {
            return;
        }
        if (index < size / 2) {
            for (int i = 0; i <= index; i++) {
                first = first.next;
            }
            first.prev = null;
        } else {
            for (int j = size; j > index; j--) {
                last = last.prev;
            }
            last.next = null;
        }
        size--;
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(Integer e) {
        int index = 0;
        if (e == null) {
            for (Element tmp = first; tmp != null; tmp = tmp.next) {
                if (tmp.value == null)
                    return index;
                index++;
            }
        } else {
            for (Element tmp = first; tmp != null; tmp = tmp.next) {
                if (e.equals(tmp.value))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        int i = size()-1;
        Element tmp = last;
        while (tmp != null && !tmp.value.equals(e))
        {
            tmp = tmp.prev;
            i--;
        }
        if (tmp == null)
        {
            return -1;
        } else {
            return i;
        }
    }

    @Override
    public int size() {
        return size;
    }
}