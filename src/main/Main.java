package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> c;
        List<String> l;
        Set<Double> s;
        Queue<Short> q;
        Map<Byte, String> m;

        OurList ourList = new OurLinkedList();
        System.out.println(ourList.size());
        ourList.add(5);
        ourList.add(10);
        System.out.println(ourList.size());
        System.out.println(ourList.get(1));
        System.out.println(ourList.indexOf(5));
        System.out.println(ourList.indexOf(7));
        System.out.println(ourList);
        ourList.remove(0);
        System.out.println(ourList);
        ourList.clear();
        System.out.println(ourList.size());
    }
}
