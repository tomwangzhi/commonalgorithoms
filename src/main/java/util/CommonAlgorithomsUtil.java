package util;

/**
 * 通用算法工具类
 */
public class CommonAlgorithomsUtil {

    private CommonAlgorithomsUtil() {

    }

    public static void main(String[] args) {

        int[] searchData = new int[]{2, 4, 6, 9, 11};
        int i = binarySearch(7, searchData);
        System.out.println("find data index:"+i);
        int i1 = maxCommonDivisor(13, 3);
        System.out.println("max divisor data:"+i1);
        System.out.println(reverseWords("ddd eee sss"));
        System.out.println(isPalindrome(111));

    }

    /**
     * 二分法搜索，主要是移动两端的索引来进行查找，未找到就返回 - 1 ，找到就返回中间的索引编号
     * @param key  循环条件是 左边索引 小于 右边索引
     * @param searchData
     * @return
     */

    public static int binarySearch(int key, int[] searchData) {

        int left = 0;
        int right = searchData.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (key <searchData[mid] ) {
                right = mid - 1;
            } else if (key > searchData[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 求两个数的最大公约数
     * @param a 除数
     * @param b 被除数
     * @return 返回最大公约数
     */
    public static int maxCommonDivisor(int a, int b) {

        if (b == 0) {
            return a;
        }
        int div = a % b;

        return maxCommonDivisor(b, div);
    }

    /**
     * 翻转字符串
     * @param words
     * @return
     */
    public static String reverseWords(String words) {

        StringBuilder result = new StringBuilder();
        String[] split = words.trim().split("\\s+");
        int length = split.length - 1;
        System.out.println("长度为："+length);
        for(int i = length;i >= 0;i--) {
            String lastMove = split[i];
            result.append(lastMove);
        }
        return result.toString();
    }

    /**
     * 是不是回文数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        boolean b = false;
        int y = 0;
        int z = x;
        while (z > 0) {
            y = y * 10 + z % 10;
            z = z / 10;
        }
        if (y == x) {
            b = true;
        }
        return b;
    }

}
