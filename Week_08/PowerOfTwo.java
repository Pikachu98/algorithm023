package Week8;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        // 首先要排除掉1
        if (n > 0 && (n & (n-1)) == 0)
            return true;
        return false;
    }
}
