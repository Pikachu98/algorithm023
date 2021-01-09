package Week2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 将数字和频率对应存放在hashMap里
        for (int num: nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        // 用PriorityQueue来对map里的频率进行排序  大顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> maxPQ = new PriorityQueue<>((a,b) -> (b.getValue()-a.getValue()));
        //将hashMap里的键值对添加到priorityqueue里
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            maxPQ.add(entry);
        }

        //取出前k个
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxPQ.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new int[2];
        res = topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        for(int s: res) {
            System.out.print(s + " ");
        }
    }
}
