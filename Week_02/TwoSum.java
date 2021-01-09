package Week2;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // 此方法只限于nums中没有重复的元素并且答案唯一
    // 所以可以使用hashMap来将数字与下标一一对应
    public static int[] twoSum(int[] nums, int target) {
        // 用来保存遍历过的元素
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // 快速检索有无complement
            if (hashMap.containsKey(complement)) {
                return new int[]{i, hashMap.get(complement)};
            } else {
                hashMap.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // case 1: 无重复数字
        for (int n: twoSum(new int[]{2,7,11,15}, 9)) {
            System.out.print(n + " ");
            System.out.println();
        }

        //case 2: 有重复数字 只能返回最先符合条件的
        for (int n: twoSum(new int[]{3,3,3}, 6)) {
            System.out.print(n + " " );
            System.out.println();
        }
    }
}
