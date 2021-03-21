package Week9;
// Method 1： 创建一个新的空间，然后依次遍历，存放到新的空间里

public class ReverseString {
    public static void reverseString(char[] s) {
        // for loop的中间条件要注意，必须严格小于 长度 / 2, 否则奇数长度的时候会有问题    比如长度为7，7/2 =3， 中间数字下标就是3
        /**
        for (int i = 0; i < (s.length >> 1); i++) {
            char a = s[i];
            char b = s[s.length - i - 1];
            s[i] = a;
            s[s.length - i - 1] = b;
        }*/

        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

    }
    public static void main(String[] args) {
        char[] a = new char[]{'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};
        reverseString(a);

        for(char ch: a) {
            System.out.println(ch);
        }


    }
}
