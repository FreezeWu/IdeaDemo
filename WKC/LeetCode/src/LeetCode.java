import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class LeetCode {
    static class Solution {
        //二叉树类
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }


        //链表类
        public class ListNode{
            int val;
            ListNode next;
            ListNode(int x){ val = x; }
        }

        //判断一个链表是否为回文链表
        public boolean isPalindrome(ListNode head) {
            // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
            if (head == null || head.next == null) {
                return true;
            }
            ListNode fast = head;
            ListNode slow = head;
            // 根据快慢指针，找到链表的中点
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            slow = reverse(slow.next);
            while(slow != null) {
                if (head.val != slow.val) {
                    return false;
                }
                head = head.next;
                slow = slow.next;
            }
            return true;
        }


        private ListNode reverse(ListNode head){
            // 递归到最后一个节点，返回新的新的头结点
            if (head.next == null) {
                return head;
            }
            ListNode newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }


        //查找字符串J中的字符在S中出现的次数
        public int numJewelsInStones(String J, String S) {
            int jewelnums = 0;

//            char[] charArrayJ = new char[J.length()];
//            charArrayJ = J.toCharArray();
//
//            char[] charArrayS = new char[S.length()];
//            charArrayS = S.toCharArray();
//
//
//            for (int i = 0; i < S.length(); i++)
//                for (int j = 0; j < J.length(); j++) {
//                    if (charArrayS[i] == charArrayJ[j]) {
//                        jewelnums++;
//                    }
//                }

            for (int i = 0; i < S.length(); i++)
                if(J.indexOf(S.charAt(i)) != -1 ){
                    jewelnums++;
                }

            return jewelnums;


        }

        public String toLowerCase(String str) {
            return str.toLowerCase();
        }

        //返回给定数组所有元素的平方组成的升序数组
        public int[] sortedSquares(int[] A) {
            int[] B = new int[A.length];

            for(int i = 0; i < A.length; i++){
                B[i] = A[i] * A[i];
            }

            Arrays.sort(B);

            return B;

        }

        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode(int x) { val = x; }
         * }
         */



        //合并二叉树
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1 == null)
                return t2;
            if(t2 == null)
                return t1;

            t1.val += t2.val;

            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);

            return t1;

        }
        //斐波那契数
        public int fib(int N) {
            if(N == 0)
                return 0;
            else if(N == 1)
                return 1;

            return fib(N - 2) + fib(N - 1);
        }

        //判断给定二叉树是否为单值二叉树
        public boolean isUnivalTree(TreeNode root) {
            if(root == null)
                return true;

            //当root的左子树或者右子树不是单值二叉树时，这棵树就一定不是了，直接返回false
            if(isUnivalTree(root.left) == false || isUnivalTree(root.right) == false){
                return false;
            }
            //当root的左右子树都是单值二叉树时，才进行以下判断
            //当它的左或右子树存在且和它的值不等时，它就不是单值二叉树
            if(root.left != null && root.val != root.left.val){
                return false;
            }
            if(root.right != null && root.val != root.right.val){
                return false;
            }
            //排除以上所有因素后，才能证明目前以root为根的树是单值二叉树
            return true;


        }

        ArrayList<Integer> list = new ArrayList<>();

        //先序遍历二叉树并存到ArrayList中
        public void preOrder(TreeNode root){
            if(root == null){
                return;
            }

            list.add(root.val);
            preOrder(root.left);
            preOrder(root.right);

        }

        //通过迭代器遍历arraylist
        private void traverseArraylist(){
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }

        //返回n Pair数组中min(pair)的最大和
        public int arrayPairSum(int[] nums) {
            int sum = 0;

            Arrays.sort(nums);

            for(int i = 0; i < nums.length - 1; i += 2)
                sum += nums[i];

            return sum;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int nums = s.numJewelsInStones("aAbB", "aaaAAccbbbBBBB");

        String str = s.toLowerCase("QWERtyuoiSHDKBKAdshakf");
        //System.out.println(str);
        //System.out.println(nums);

        int fibnum = s.fib(6);
        //System.out.println(fibnum);

        int[] intArray = {12,32,2,56,99,321,55,33};
        int sum = s.arrayPairSum(intArray);

        System.out.println(sum);

    }
}
