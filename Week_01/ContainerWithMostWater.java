package Week1;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length-1; i < j;) {
            // 以最矮的边为高
            int h = (height[i] > height[j])? height[j--] : height[i++];
            int area = (j - i + 1) * h;
            max = (area > max)? area: max;

        }
        return max;
    }
}
