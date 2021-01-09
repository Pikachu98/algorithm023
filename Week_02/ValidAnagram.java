package Week2;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // 因为都是字母，声明一个长度为26的int 数组。
        // 这种写法只能用于字母。
        int[] arr = new int[26];
        // 把s 和 t 变成 char array
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        if (sArr.length != tArr.length)
            return false;

        for (int i = 0; i < sArr.length; i++) {
            arr[sArr[i] - 'a']++;
            arr[tArr[i] - 'a']--;
        }

        for (int num: arr) {
            if (num != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // case 1: different lengths
        System.out.println(isAnagram("s", "tt"));

        // case 2: same length, different words
        System.out.println(isAnagram("cars", "sars"));

        // case 3: anagram
        System.out.println(isAnagram("anagram", "nagaram"));

    }
}
