package com.howard.leetcode.binary.tree.heap;

import java.util.Comparator;

/**
 * 自已实现堆结构
 *
 * @author howard he
 * @create 2019-01-10 11:19
 */
public class Heap<E> {

    /**
     * 堆中元素数据
     */
    private Object[] data;
    /**
     * 堆的最大容量
     */
    private int n;
    /**
     * 元素个数
     */
    private int size;

    private Comparator<? super E> comparator;

    public Heap(int capacity) {
        this(capacity, null);
    }

    /**
     * 构建一个堆
     *
     * @param
     */
    public Heap(int capacity, Comparator<? super E> comparator) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must not be less than 0");
        }
        data = new Object[capacity];
        this.comparator = comparator;
        n = capacity;
    }

    /**
     * 向堆中插入一个元素
     *
     * @param e
     */
    public void insert(E e) {
        // 堆已满
        if (size >= n) {
            return;
        }
        int pos = size;
        size = pos + 1;
        if (pos == 0) {
            data[0] = e;
        } else {
            siftUp(pos, e);
        }
    }

    private void siftUp(int k, E e) {
        if (comparator != null) {
            siftUpComparator(k, e);
        } else {
            siftUpComparable(k, e);
        }
    }

    private void siftUpComparable(int k, E e) {
        Comparable<? super E> key = (Comparable<? super E>) e;
        while (k > 0) {
            // 父节点索引
            int parent = (k - 1) >>> 1;
            Object o = data[parent];
            if (key.compareTo((E)o) >= 0) {
                break;
            }
            data[k] = o;
            k = parent;
        }
        data[k] = key;
    }

    private void siftUpComparator(int k, E e) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object o = data[parent];
            if (comparator.compare(e, (E)o) >= 0) {
                break;
            }
            data[k] = o;
            k = parent;
        }
        data[k] = e;
    }

    /**
     * 从堆顶删除一个元素
     *
     * @return
     */
    public E removeTop() {
        if (size == 0) {
            return null;
        }
        E result = (E) data[0];
        int s = --size;
        E e = (E) data[s];
        // gc
        data[s] = null;
        siftDown(0, e);
        return result;
    }

    private void siftDown(int k, E e) {
        if (comparator != null) {
            siftDownComparator(k, e);
        } else {
            siftDownComparable(k, e);
        }
    }

    private void siftDownComparator(int k, E e) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            int right = child + 1;
            Object c = data[child];
            if (right < size && comparator.compare((E) c, (E) data[right]) > 0) {
                c = data[child = right];
            }
            if (comparator.compare(e, (E) c) <= 0) {
                break;
            }
            data[k] = c;
            k = child;
        }
        data[k] = e;
    }

    private void siftDownComparable(int k, E e) {
        Comparable<? super E> key = (Comparable<? super E>) e;
        // loop while a non-leaf
        int half = size >>> 1;
        while (k < half) {
            // assume left child is least
            int child = (k << 1) + 1;
            Object c = data[child];
            int right = child + 1;
            if (right < size && ((Comparable<? super E>) c).compareTo((E) data[right]) > 0) {
                c = data[child = right];
            }
            if (key.compareTo((E) c) <= 0) {
                break;
            }
            data[k] = c;
            k = child;
        }
        data[k] = key;
    }

    /**
     * 获取堆顶的元素
     *
     * @return
     */
    public E top() {
        return (E) data[0];
    }

    /**
     * 堆化
     */
    private void heapify() {
        for (int i = (size >>> 1) - 1; i >= 0; i--) {
            siftDown(i, (E) data[i]);
        }
    }

    public E[] items() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }
        return (E[]) result;
    }

    public int size() {
        return size;
    }

}
