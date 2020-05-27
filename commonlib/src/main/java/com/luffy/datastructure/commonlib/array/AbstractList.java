package com.luffy.datastructure.commonlib.array;

public abstract class AbstractList<E> implements List<E> {
    protected static final int DEFAULT_CAPACITY = 10;
    protected static final int ELEMENT_NOT_FOUND = -1;

    protected int size;

    protected AbstractList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }
}
