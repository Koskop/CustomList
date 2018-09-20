package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<E> implements List<E> {

    class Node<E> {
        public Node<E> prevElement, nextElement;
        public E data;

        Node(Node<E> prevElement, Node<E> nextElement, E data){
            this.prevElement = prevElement;
            this.nextElement = nextElement;
            this.data = data;
        }
    }

    class MyIterator implements Iterator {

        ListIterator listIterator = listIterator();

        @Override
        public boolean hasNext() {
            return listIterator.hasNext();
        }

        @Override
        public Object next() {
           return listIterator.next();
        }

        @Override
        public void remove() {
            listIterator.remove();
        }
    }

    class MyListIterator implements ListIterator {

        private Node<E> curent = first;
        private int curentindex = 0;

        @Override
        public boolean hasNext() {
            return curent == null ? false : true;
        }

        @Override
        public Object next() {
            Object data = curent.data;
            curent = curent.nextElement;
            curentindex++;
            return data;
        }

        @Override
        public boolean hasPrevious() {
            return curent.prevElement == null ? false : true;
        }

        @Override
        public Object previous() {

            if (hasPrevious()) {
                return curent.prevElement;
            }
            else return null;
        }

        @Override
        public int nextIndex() {
            if (curentindex == size - 1) {
                return -1;
            }
            else {
                return curentindex + 1;
            }
        }

        @Override
        public int previousIndex() {
            return curentindex - 1;
        }

        @Override
        public void remove() {

            if (size == 1) {
                first = last = null;
                size--;
                curent = curent.nextElement;
                return;
            }

            else if(curent.prevElement == null) {
                first = first.nextElement;
                first.prevElement = null;
                size--;
                curent = curent.nextElement;
                return;
            }

            else if(curent.nextElement == null) {
                last = last.prevElement;
                last.nextElement = null;
                size--;
                curent = null;
                return;
            }
            else {
                Node<E> o = curent.prevElement;
                o.nextElement = o.nextElement.nextElement;
                o.nextElement.prevElement = o.nextElement.prevElement.prevElement;
                size--;
                curent = curent.nextElement;
                return;
            }

        }

        @Override
        public void set(Object o) {
            if (curent == null) throw new NullPointerException("Element does not exist!");
            else {
                curent.data = (E)o;
            }
        }

        @Override
        public void add(Object o) {
            pop((E)o);
        }
    }

    private  Node<E> first, last;
    private int size = 0;


    private void pop(E e) {
        Node<E> newNode = new Node<>(last, null, e);
        last.nextElement = newNode;
        last = newNode;
        size++;
    }

    private void push(E e) {
        Node<E> newNode = new Node<>(null, first, e);
        first = newNode;

        if (isEmpty()) {
            last = first;
        }
        size++;
    }

    private Node find(Object o) {
        Node curent = first;

        while (curent.nextElement != null){
            if (curent.data.equals(o)) return curent;
            curent = curent.nextElement;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return find(o) == null ? false : true;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        int index = 0;
        Object[] arrayObjects = new Object[size];
        Iterator iterator = iterator();

        while (iterator.hasNext()) {
            arrayObjects[index] = iterator.next();
            index++;
        }
        return arrayObjects;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {

        if (isEmpty()) {
            push(e);
            return true;
        } else {
            pop(e);
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {

        ListIterator<E> eIter = listIterator();

        while (eIter.hasNext()) {
            if (o.equals(eIter.previous())) {
                eIter.remove();
                return true;
            }else {
                eIter.next();
            }
        }

        return false;

    }

    @Override
    public boolean containsAll(Collection<?> c) {

        if (c.isEmpty()) return false;

        Iterator cItr = c.iterator();
        ListIterator tIter = listIterator();
        Object curentCElement = cItr.next();

        Node firstOf = find(curentCElement);

        if (firstOf == null) return false;




        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        this.addAll(0, c);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {

        if (index < 0 || index >= size) return false;

        else if (index == size -1){
            Iterator cItr = c.iterator();

            while (cItr.hasNext()) {
                this.pop((E)cItr.next());
            }
            return true;
        }

        else if (index == 0){
            Iterator cItr = c.iterator();

            while (cItr.hasNext()) {
                this.push((E)cItr.next());
            }
            return true;
        }


        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        String s = "";

        Node curent = first;

        while (curent != null){
            s += curent.data + " ";
            curent = curent.nextElement;
        }

        return s;
    }
}
