package main;

public class OurLinkedList implements OurList {

    private class Element {
        Integer value;
        Element next = null;

        public Element(Integer value) {
            this.value = value;
        }
    }

    private Element first = null;

    @Override
    public void add(Integer e) {
        Element newElement = new Element(e);
        if (first == null) {
            first = newElement;
        } else {
            Element tmp = first;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newElement;
        }
    }

    @Override
    public Integer get(int index) {
        if (first == null || index < 0) {
            return null;
        }
        Element tmp = first;
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
    }

    @Override
    public void set(int index, Integer e) {
        //todo
    }

    @Override
    public void remove(int index) {
        if (first == null || index < 0) {
            return;
        }
        if (index == 0) {
            first = first.next;
        } else {
            Element tmp = first;
            for (int i = 0; i < index - 1; i++) {
                try {
                    tmp = tmp.next;
                } catch (NullPointerException e) {
                    return;
                }
            }
            try {
                tmp.next = (tmp.next).next;
            } catch (NullPointerException e) {
                return;
            }
        }
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int indexOf(Integer e) {
        //todo
        return 0;
    }

    @Override
    public int lastIndexOf(Integer e) {
        //todo
        return 0;
    }

    @Override
    public int size() {
        if (first == null) {
            return 0;
        }
        Element tmp = first;
        int counter = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        String result = "OurLinkedList{";
        Element tmp = first;
        if (first != null) {
            result += tmp.value + ",";
            while(tmp.next != null) {
                tmp = tmp.next;
                result += tmp.value + ",";
            }
            result = result.substring(0, result.length() - 1);
        }
        result += '}';
        return result;
    }
}
