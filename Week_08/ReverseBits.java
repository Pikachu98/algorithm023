package Week8;

public class ReverseBits {
    public int reverseBits(int n) {
        //需要一个新的变量来存储结果
        int ans = 0;
        // 遍历每一位，把最后一位依次加入到ans的最后一位，然后将最后一位移除n
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) + (n & 1);
            // 把n最后一位删掉
            n = n >> 1;
        }
        return ans;
    }
}
