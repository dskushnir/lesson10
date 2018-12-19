package ua.hillel.lesson10;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MyList <E>implements List<E> {
    private Node<E> head;

    @Override

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
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
        return null;
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
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E o:c){
            add(o);
        }
        return true;
    }

    @Override
    public void clear() {
        head=null;

    }

    @Override
    public E get(int index) {
        if (index<0||index>=size()){
            throw new IndexOutOfBoundsException();
        }
        Node<E>node=head;
        int i=0;
        while (node!=null&&i!=index){
            node=node.next;
            i++;
        }
        return node.value;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o:c){
            remove(o);
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> node = head;
        Node<E>prev=null;
        while (node != null ) {
            if (Objects.equals(node.value,o)){
                if (prev==null) {
                    head = node.next;
                }else {
                    prev.next=node.next;
                }
            }
            prev=node;
            node = node.next;
        }
            return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o:c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }



    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean contains(Object obj) {

        for (Node<E>node=head;node!=null;node=node.next){
          if (Objects.equals(node.value,obj)){
              return true;
          }

        }

        return false;
    }

    @Override
    public Object[] toArray() {
        Object[]objects=new Object[size()];
        int count=0;
        for (Node<E>node=head;node!=null;node=node.next) {
            objects[count++] = node.value;
        }
        return objects;
    }

    @Override
    public int size() {
        int count=0;
        for (Node<E>node=head;node!=null;node=node.next){
            count++;

        }
        return count;
    }

    public Iterator<E> iterator() {

        return new Iterator<>() {

            Node<E> node = head;

            public boolean hasNext() {
                return node != null;
            }

            public E next() {
                E value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    public static class Node<T> {
        private T value;
        private Node<T> next;

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public boolean add(E e) {
        Node<E>tail=tail();
        if (tail==null){
            head = new Node<>(e);
        }else {
            tail.next=new Node<>(e);
        }
        return true;


    }

    public Node<E> tail() {
        Node<E> node = head;
        while (node != null && node.next != null) {
            node = node.next;

        }
        return node;

    }
    void iterate(Consumer<E>consumer){
        for (Node<E>node=head;node!=null;node=node.next)
        consumer.accept(node.value);
    }
    public void print(){
        for (Node<E>node=head;node!=null;node=node.next){
            System.out.println(node.value);
        }
    }



}
