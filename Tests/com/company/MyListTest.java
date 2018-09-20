package com.company;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;



public class MyListTest {

    @Test
    public void size() {
        MyList<String> list = new MyList<>();
        System.out.println(list.size());

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list.size());
    }


    @Test
    public void isEmpty() {
        MyList<String> list = new MyList<>();
        System.out.println(list.isEmpty());

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list.isEmpty());
    }

    @Test
    public void contains() {
        MyList<String> list = new MyList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list.contains("A"));
        System.out.println(list.contains("D"));
    }

    @Test
    public void iterator() {
        List list = new MyList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        Iterator iterator = list.iterator();
        System.out.println("Next: " + iterator.next());
        iterator.remove();
        System.out.println("Remove \n" + list.toString());

        while (iterator.hasNext()) {
            iterator.remove();
            System.out.println(list.toString());
        }
    }

    @Test
    public void toArray() {
        List list = new MyList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        Object[] objects = list.toArray();

        for (Object o : objects) {
            System.out.print(o + " ");
        }
    }

    @Test
    public void toArray1() {
    }

    @Test
    public void add() {
        MyList<String> s = new MyList<>();

        s.add("A");
        s.add("B");
        s.add("C");


        String a = s.toString();
        System.out.println(a);
    }

    @Test
    public void remove() {

        List list = new MyList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println(list.toString());


        Iterator iterator = list.iterator();
        iterator.next();
        iterator.remove();


        System.out.println(list.toString());
        iterator.remove();


        System.out.println(iterator.next());

    }

    @Test
    public void containsAll() {
        List list1 = new MyList();
        list1.add("A");
        list1.add("B");
        list1.add("D");
        list1.add("B");
        list1.add("C");
        list1.add("A");


        List list2 = new MyList();
        list2.add("B");
        list2.add("C");

        System.out.println(list1.containsAll(list2));

    }

    @Test
    public void addAll() {
        List list1 = new MyList();
        list1.add("A");
        list1.add("B");
        list1.add("D");
        list1.add("B");
        list1.add("C");
        list1.add("A");


        List list2 = new MyList();
        list2.add("B");
        list2.add("C");

        list1.addAll(list2);

        System.out.println(list1.toString());
    }

    @Test
    public void addAll1() {
        List list1 = new MyList();
        list1.add("A");
        list1.add("B");



        List list2 = new MyList();
        list2.add("X");
        list2.add("X");

        list1.addAll(0, list2);

        list1.addAll(3, list2);


        System.out.println(list1.toString());
    }

    @Test
    public void removeAll() {
    }

    @Test
    public void retainAll() {
    }

    @Test
    public void clear() {
        List list1 = new MyList();
        list1.add("A");
        list1.add("B");
        list1.add("D");
        list1.add("B");
        list1.add("C");
        list1.add("A");

        list1.clear();

        System.out.println(list1.isEmpty());
    }

    @Test
    public void get() {
        List list1 = new MyList();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");

        System.out.println(list1.get(2));
    }

    @Test
    public void set() {
        List list1 = new MyList();
        list1.add("A");
        list1.add("B");
        list1.add("D");

        list1.set(2, "C");

        System.out.println(list1.toString());


    }

    @Test
    public void add1() {
    }

    @Test
    public void remove1() {
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void lastIndexOf() {
    }

    @Test
    public void listIterator() {
    }

    @Test
    public void listIterator1() {
    }

    @Test
    public void subList() {
    }
}