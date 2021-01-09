HashMap学习笔记

1. HashMap permits null values and the null key.  异步的(unsynchronized)
2. HashTable 不许空值和空键. 同步的(synchronized)
    两者主要在多线程时有区别。
    多线程时实现了同步的也就是实现了synchronized方法。
    可以在操作时防止被其它线程抢占而产生数据错误。

3. HashMap will not remain constant. Order of the map may change.


Methods:
Set<Map.Entry<K,V>>    entrySet() 
Returns a Set view of the mappings contained in this map.

Set<K>    keySet()  
Returns a Set view of the keys contained in this map.

void   putAll(Map<? extends K,? extends V> m)  
Copies all of the mappings from the specified map to this map.

remove(Object key)   
Removes the mapping for the specified key from this map if present.
  
getOrDefault(Object key, V defaultValue)
Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.

replace(K key, V oldValue, V newValue)
Replaces the entry for the specified key only if currently mapped to the specified value.

Collection<V>    values()
Returns a Collection view of the values contained in this map.



部分源码
/**
 * HashMap的节点类型。既是HashMap底层数组的组成元素，又是每个单向链表的组成元素
 */

        static class Node<K,V> implements Map.Entry<K,V> {
            //key的哈希值
            final int hash;
            final K key;
            V value;
            //指向下个节点的引用
            Node<K,V> next;
            //构造函数
            Node(int hash, K key, V value, Node<K,V> next) {
                this.hash = hash;
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }



HeapSort 笔记 https://www.geeksforgeeks.org/heap-sort/
Since a Binary Heap is a Complete Binary Tree, it can be easily represented as an array and the array-based representation is space-efficient. 
If the parent node is stored at index I, the left child can be calculated by 2 * I + 1 and right child by 2 * I + 2 (assuming the indexing starts at 0). 父i，左子2i +1, 右子2i+2

比如大顶heap
新插入一个数，index为i 向上移动数字
    
        
    private heapify(int i) {
        int newValue = heap[i];
        // 如果新插入的值比父节点大，i值与父节点换，heap[i] = heap[parent(i)]
        while (i > 0 && heap[i] > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        //最后再把newValue放到新的位置
        heap[i] = newValue;
    }


删掉一个节点 delete element at x, 并且返回删掉的值

    
    public delete(int x) {
        int maxValue = heap[x];
        // 把最后一个节点放到heap[x]这里，然后把heapSize-1
        heap[x] = heap[heapSize--];
        heapifyDown(x);
        return maxValue;
    }


将新的heap[x]放到合适的位置
找左右儿子比本身大的，和其换位置



    
    // n: size of array
    void heapify(int[] arr, int i, int n) {
        int largest = i;
        int left = 2* i + 1;
        int right = 2* i + 2;
    if(left < n && arr[left] > arr[largest]){
        largest = left;
    }
    if(right < n && arr[right] > arr[largest]){
        largest = right;
    }
    
    if(largest != i){
        int swap = arr[i];
        // index为largest的值放到i处
        arr[i] = arr[largest];
        arr[largest] = swap;
        
        heapify(arr,n,largest);
    }
}
