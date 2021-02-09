package Week6;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
//        int sum = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        // 不停求和one by one，存到dp数组里，直到当前数字的值大于之前的和，停止
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            // 找到dp数组里的最大值
            if (dp[i] > max)
                max = dp[i];

//            这么写不行，必须要数组存储前面相加出来的和
//            sum = Math.max(sum + nums[i], sum);
//            if (sum > max)
//                max = sum;
        }
        return max;

    }
    public static void main(String[] args) {
        int[] arr = {1,2};

        int s = maxSubArray(arr);
        System.out.println(s);

    }
}
