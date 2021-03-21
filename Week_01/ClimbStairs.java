package Week1;

public class ClimbStairs {

    public static int climbStairs(int n) {
        int f2 = 2, f3 = 3;
        if (n <= 3)
            return n;
        for (int i = 3; i < n; i++) {
            int stairs = f2 + f3;
            f2 = f3;
            f3 = stairs;
            System.out.println("n is " + n +" f2 is " + f2 + " f3 is " + f3);
        }
        return f3;
    }

//    public static int climbStairs(int n) {
//         int f1 = 1;
//         int f2 = 2;
//         int f3 = 3;
//
//         if(n <= 3)
// 	        return n;
//         for(int i = 3; i < (n + 1); i++) {
//           // 注意，这里是f1 + f2;
// 	        f3 = f1 + f2;   //3
//
// 	        f1 = f2;        //2
// 	        f2 = f3;        //3
//            System.out.println("f1 is " + f1 + " f2 is " + f2 + " f3 is " + f3);
//         }
//         return f3;
//     }

    public static void main(String[] args) {
        climbStairs(5);
    }
}
