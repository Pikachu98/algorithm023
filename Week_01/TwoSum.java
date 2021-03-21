package Week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // Solution1: 双指针法，不行，因为这里我们需要的是下标 --> 时间复杂度，Arrays.sort(nums)的时间复杂度：O(nlog(n))
//    public static int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//
//        // 将nums进行排序
//        Arrays.sort(nums);
//
//        for (int i = 0, j = nums.length-1; i < j;) {
//            int sum = nums[i] + nums[j];
//
//            if (sum < target) {
//                i++;
//            } else if (sum > target) {
//                j--;
//            } else {
//                res[0] = nums[i];
//                res[1] = nums[j];
//            }
//
//        }
//
//        return res;
//    }

    // 使用hashMap, 数字做key，index做value --> 时间复杂度O(n)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] testArray = {2,7,11,15};
        int[] a = twoSum(testArray, 9);

        for(int num: a) {
            System.out.println(num);
        }
    }
}
