package Week8;

public class NumberOf1Bits {
    int count  = 0;
    public int hammingWeight(int n) {
        // Method 1: O(1) 即有多少个1，运行时间就是多少
        /**
        while (n != 0) {
            count++;
            //每做一次这样的操作，就使得从右向左起的第一个1变成0，如(A)1(000...0)就会变成(A)0(000..0)
            //再继续对(A)进行同样的操作
            n &= n-1;
        }
        return count;
         */

        // Method 2: O(n) 其实相当于 n % 2 == 1? count++:count;  n /= 2;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
