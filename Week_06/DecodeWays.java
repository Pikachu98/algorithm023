package Week6;

// https://leetcode-cn.com/problems/decode-ways/submissions/
// 把一串是数字的字符串转换成字母，输出同一个字符串有多少种解法
public class DecodeWays {
    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            // 只有前面一位是1或者2,如果前面一位是2，那后面一位必须小于7
            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) < '7') {
                //再加一条判断：如果是10， 20
                // 一旦有0出现在中间，前面一定要有一个数字"照顾它"，所以要倒退两步，而不是倒退1步
                if(s.charAt(i) == '0')
                    dp[i + 1] = dp[i - 1];
                else
                    dp[i+1] = dp[i-1] + dp[i];

            } else if (s.charAt(i) == '0') {
                //前面是0，3，4，5，6，7，8, 9，后面是0
                return 0;
            } else {
                // 28, 29, 31，32....
                // 出现了大数字，要把s.charAt(i)这个字母和前面的字母分开，因此倒退一步 如：228  --> 2,2,8 / 22,8前面有几种情况，后面就有集中几种情况
                dp[i+1] = dp[i];
            }
        }

        return dp[n];


    }
    public static void main(String[] args) {
        int c = numDecodings("10011");
        System.out.println(c);

    }
}
