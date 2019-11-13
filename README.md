# GeneralDataStructure
通用数据结构

## gradle使用：

一、Project下的build.gradle文件下添加

allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
}

二、Module下的build.gradle文件下添加

dependencies {
          compile 'com.github.Lvluffy:GeneralDataStructure:1.0.0'
}

或者

dependencies {
          implementation 'com.github.Lvluffy:GeneralDataStructure:1.0.0'
}

## 概述
一、常用数据结（简单数据结构）

1-1，数组、字符串（Array & String）

1-2，链表（Linked-list）

1-3，栈（Stack）

1-4，队列（Queue）

1-5，双端队列（Deque）

1-6，树（Tree）

二、高级数据结构

2-1，优先队列（Priority Queue）

2-2，图（Graph）

2-3，前缀树（Trie）

2-4，线段树（Segment Tree）

2-5，树状数组（Fenwick Tree、Binary Indexed Tree）

三、排序

3-1，基本的排序算法

3-1-1，冒泡排序（Bubble Sort）

3-1-2，插入排序（Insertion Sort）

3-2，常考的排序算法

3-2-1，归并排序（Merge Sort）

3-2-2，快速排序（Quick Sort）

3-2-3，拓扑排序（Topological Sort）

3-3，其他排序算法

3-3-1，堆排序（Heap Sort）

3-3-2，桶排序（Bucket Sort）

四、递归与回溯

4-1，递归（Recursion）

4-1，回溯（Backtracking）

五、深度与广度优先搜索

5-1，深度优先搜索（Depth-First Search / DFS）

5-2，广度优先搜索（Breadth-First Search / BFS）

六、动态规划

6-1，动态规划（Dynamic Plan）

七、二分搜索与贪婪算法

7-1，二分搜索（Binary Search）

7-2，贪婪算法（Greedy）

## 图解算法

### 排序算法复杂度

![排序算法复杂度](https://user-images.githubusercontent.com/34730376/68726477-8a651800-05fc-11ea-9de8-e1abe725ecd9.png)

### 冒泡排序

![冒泡排序](https://user-images.githubusercontent.com/34730376/68725906-d7e08580-05fa-11ea-922d-6823c13ad8be.gif)

### 插入排序：

![插入排序](https://user-images.githubusercontent.com/34730376/68726049-3c9be000-05fb-11ea-82b3-b73021918342.gif)

### 快速排序：

![快速排序](https://user-images.githubusercontent.com/34730376/68726112-6d7c1500-05fb-11ea-92a1-21900452f5ba.gif)

### 归并排序：

![归并排序](https://user-images.githubusercontent.com/34730376/68726146-8c7aa700-05fb-11ea-8bc1-2fd95597b8ac.gif)

### 堆排序：

![堆排序](https://user-images.githubusercontent.com/34730376/68726222-c481ea00-05fb-11ea-9fa3-a54a01d8e4ce.gif)
