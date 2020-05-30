package com.howard.leetcode.eighteen.stacks;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;

/**
 * 自定义优先级队列
 *
 * @author howard he
 * @create 2019-04-01 15:28
 */
public class MyPriorityQueue<E> implements Serializable {

    transient Object[] queue;
    private Comparator<? super E> comparator;
    private int size;

    public MyPriorityQueue(int capacity) {
        this(capacity, null);
    }

    public MyPriorityQueue(int capacity, Comparator<? super E> comparator) {
        this.queue = new Object[capacity];
        this.comparator = comparator;
    }

    public MyPriorityQueue(Collection<? extends E> c, int capacity) {
        this.comparator = null;
        Object[] a = c.toArray();
        queue = new Object[capacity];
        for (int i = 0; i < a.length; i++) {
            queue[i] = a[i];
        }
        size = a.length;
        heapify();
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        int i = size;
        // full
        if (i >= queue.length) {
            return false;
        }
        siftUp(i, e);
        size = i + 1;
        return true;
    }

    private void siftUp(int k, E e) {
        if (comparator != null) {
            siftUpUsingComparator(k, e);
        } else {
            siftUpComparable(k, e);
        }
    }

    private void siftUpUsingComparator(int k, E e) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object o = queue[parent];
            if (comparator.compare(e, (E) o) >= 0) {
                break;
            }
            queue[k] = o;
            k = parent;
        }
        queue[k] = e;
    }

    private void siftUpComparable(int k, E e) {
        Comparable<? super E> key = (Comparable<? super E>) e;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object o = queue[parent];
            if (key.compareTo((E) o) >= 0) {
                break;
            }
            queue[k] = o;
            k = parent;
        }
        queue[k] = key;
    }

    public E poll() {
        if (size == 0) {
            return null;
        }
        int s = --size;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0) {
            siftDown(0, x);
        }
        return result;
    }

    private void siftDown(int k, E e) {
        if (comparator != null) {
            siftDownUsingComparator(k, e);
        } else {
            siftDownComparable(k, e);
        }
    }

    private void siftDownUsingComparator(int k, E e) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size && comparator.compare((E) c, (E) queue[right]) > 0) {
                c = queue[child = right];
            }
            if (comparator.compare(e, (E) c) <= 0) {
                break;
            }
            queue[k] = c;
            k = child;
        }
        queue[k] = e;
    }

    private void siftDownComparable(int k, E e) {
        Comparable<? super E> key = (Comparable<? super E>) e;
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size && ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0) {
                c = queue[child = right];
            }
            if (key.compareTo((E) c) <= 0) {
                break;
            }
            queue[k] = c;
            k = child;
        }
        queue[k] = e;
    }

    private void heapify() {
        final Object[] es = queue;
        int i = (size >>> 1) - 1;
        if (comparator != null) {
            for (; i >= 0; i--) {
                siftDownUsingComparator(i, (E) es[i]);
            }
        } else {
            for (; i >= 0; i--) {
                siftDownComparable(i, (E) es[i]);
            }
        }
    }

    public E peek() {
        return size == 0 ? null : (E) queue[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
