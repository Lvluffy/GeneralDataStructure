package com.luffy.datastructure.commonlib.array;

public interface List<E> {
    /**
     * 存储大小
     *
     * @return
     */
    int size();

    /**
     * 清空
     */
    void clear();

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含某元素
     *
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 某元素在容器中的索引
     *
     * @param element
     * @return
     */
    int indexOf(E element);

    /**
     * 添加元素
     *
     * @param element
     */
    void add(E element);

    /**
     * 添加元素
     *
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 移除元素
     *
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 设置某索引元素
     *
     * @param index
     * @param element
     * @return
     */
    E set(int index, E element);

    /**
     * 获取某索引元素
     *
     * @param index
     * @return
     */
    E get(int index);

}
