package Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 如果数组里根本没有三个元素，直接结束
        if (nums.length < 3)
            return res;

        Arrays.sort(nums);

        for (int first = 0; first < nums.length-2; first++) {
            // 第一个元素大于0，直接结束
            if (nums[first] > 0)
                break;
            // 排除掉重复结果，如果当前元素与前一个元素相同，直接跳过, first > 0的原因是为了不out of bound
            if (first > 0 && nums[first] == nums[first-1])
                continue;

            int second = first + 1, third = nums.length - 1;

            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];

                if (sum < 0) {
                    // 在左小于右的情况下，把second右移(++second来实现)，移动的同时要考虑，下一个元素不能和当前元素相等
                    // 原理：如果nums[second] 和 nums[++second]相等，那么循环继续，知道两者不等了，循环自己就跳出了
                    while (second < third && nums[second] == nums[++second]);
                } else if (sum > 0) {
                    while (second < third && nums[third] == nums[--third]);
                } else {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    // 还要继续找，在当前first number下，其他的可能
                    while(second < third && nums[second] == nums[++second] && nums[third] == nums[--third]);
                }
            }
        }

        return res;
    }
}

class TestThreeSum {
    public static void main(String[] args) {
        ThreeSum tts = new ThreeSum();
        int[] nums = {-1,0,1};

        List<List<Integer>> res = tts.threeSum(nums);

        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
        }
    }
}