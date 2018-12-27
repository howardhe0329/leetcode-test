package com.howard.leetcode.linkedlist;

/**
 * 双链表
 *
 * @author howard he
 * @create 2018-12-23 14:23
 */
public class MyDoublyLinkedList<T> {

    /**
     * 头节点
     */
    private DoublyListNode<T> head;
    /**
     * 尾结点
     */
    private DoublyListNode<T> tail;
    private int size;


    public MyDoublyLinkedList() {

    }

    public void addAtHead(T val) {
        final DoublyListNode<T> h = head;
        DoublyListNode<T> newNode = new DoublyListNode<>(val, null, h);
        head = newNode;
        if (h == null) {
            tail = newNode;
        } else {
            h.setPrev(newNode);
        }
        size++;
    }

    public void addAtTail(T val) {
        DoublyListNode<T> t = tail;
        DoublyListNode<T> newNode = new DoublyListNode<>(val, t, null);
        tail = newNode;
        if (t == null) {
            head = newNode;
        } else {
            t.setNext(newNode);
        }
        size++;
    }

    public T get(int index) {
        DoublyListNode<T> n = node(index);
        if (n == null) {
            return null;
        }
        return n.getData();
    }

    private DoublyListNode<T> node(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("参数无效, 超出范围");
        }
        DoublyListNode<T> n;
        if (index <= (size >> 1)) {
            n = head;
            for (int i = 0; i < index; i++) {
                if (n == null) {
                    break;
                }
                n = n.getNext();
            }
        } else {
            n = tail;
            for (int i = size - 1; i > index; i--) {
                if (n == null) {
                    break;
                }
                n = n.getPrev();
            }
        }
        return n;
    }



    public void addAtIndex(int index, T val) {
        if (index == 0) {
            addAtHead(val);
            return;
        } else if (index == size) {
            addAtTail(val);
            return;
        }
        DoublyListNode<T> node = node(index);
        if (node == null) {
            return;
        }
        DoublyListNode<T> newNode = new DoublyListNode<>(val, node.getPrev(), node);
        node.getPrev().setNext(newNode);
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index == 0 && size != 0) {
            head = head.getNext();
        } else if (index >= size) {
            return;
        } else {
            DoublyListNode<T> node = node(index);
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            node.setPrev(null);
            node.setNext(null);
            node.setData(null);
        }
        size--;
    }
}
