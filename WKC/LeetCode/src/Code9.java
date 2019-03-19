public class Code9 {
    /*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？
    */

    //判断回文数（String）
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        String str = Integer.toString(x);
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length / 2; i++){
            if(chars[i] == chars[chars.length - i - 1]){

            }
            else {
                return false;
            }
        }

        return true;


    }
    //判断回文数（使用数字位比较）
    public boolean isPalindrome2(int x){
        if(x < 0 || x%10 == 0 && x != 0){
            return false;
        }
        int t = 0;
        while(x > t){
            t = t*10 + x%10;
            x /= 10;
        }
        return x==t || x==t/10;
    }

    public static void main(String[] args) {
        Code9 code9 = new Code9();

        int num = 11111;

        System.out.println(code9.isPalindrome(num));
        System.out.println(code9.isPalindrome2(num));
    }
}
