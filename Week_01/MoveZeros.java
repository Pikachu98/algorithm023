package Week1;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int j = 0;
        // Solution 1:
        //数字0有单独的index j，将0的index与当前index i比较，如果当前的index大于0的index，则把当前的数字设置为0.然后j++。
        //若j先++再和i比较，则会在数组是【0，1】时出错。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];

                if (i > j)
                    nums[i] = 0;

                j++;
            }
        }

        /**
        // Solution 2: 遇到非0的就把当前元素和j下标的元素交换位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 交换0下标的位置的数字和非0元素，再把代表0元素的下标加1
                int temp = nums[i];
                //先让当前元素为0，再让下标j处的数字等于temp，否则会在只有一个元素的时候报错
                nums[i] = 0;
                nums[j] = temp;

                j++;
            }
        }
         */

        /**
        // solution3： 滚雪球法
        int snowBallSize = 0;
        // Solution: 非双指针法,但是多一个参数叫做雪球大小 滚雪球法
        for (int i = 0; i < nums.length; i++) {
            // 元素为0，那么雪球的size自增
            if (nums[i] == 0)
                snowBallSize++;
            else {
                int temp = nums[i];

                //必须先把nums[i]变成0，要不然会在只有一个元素时出状况
                nums[i] = 0;
                nums[i-snowBallSize] = temp;

            }
        }*/

        // 打印输出
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    // 测试
    public static void main(String[] args) {
        int[] test = new int[]{0,1};

        moveZeroes(test);
    }
}
