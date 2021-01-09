package Week2;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {
    public static int nthUglyNumber(int n) {

        // 动态规划，三指针法，质因数是2, 3, 5。丑数集合应该是1*2， 1*3， 1*5， 2*2， 2*3， 2*5 排序
        int f2 = 0, f3 = 0, f5 =0;

        int[] nums = new int[n];
        nums[0] = 1;
        // 从第一个数开始，分别乘以2，3，5放到数组里 通过动态规划的方法按序放入
        for (int i = 1; i < n; i++) {
            int temp2 = nums[f2] * 2, temp3 = nums[f3] * 3, temp5 = nums[f5] * 5;

            // 会出现重复的数，比如2*3, 3*2 等，通过两个并列的if将生成6的指针都加1 --> 2*3， 3*2出现在同一个（Math.min)的语句下
            nums[i] = Math.min(Math.min(temp2, temp3), temp5);

            if (nums[i] == temp2)
                f2++;
            if (nums[i] == temp3)
                f3++;
            if (nums[i] == temp5)
                f5++;

        }
        return nums[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
