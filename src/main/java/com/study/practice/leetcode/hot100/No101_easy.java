package com.study.practice.leetcode.hot100;

import com.study.practice.leetcode.util.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/13 9:49
 */
public class No101_easy {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode node2 = new TreeNode();
        node2.val=2;
        TreeNode node3 = new TreeNode();
        node3.val=2;
        TreeNode node4 = new TreeNode();
        node4.val=3;
        TreeNode node5 = new TreeNode();
        node5.val=3;

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node3.right = node5;

        No101_easy no101_easy = new No101_easy();
        System.out.println(no101_easy.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean isSymmetric2(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            resList.add(cur.val);
            cur = cur.right;
        }

        // list中元素个数是偶数返回false
        int len = resList.size();
        if ((len & 1) == 0) {
            return false;
        }

        // 判断list中元素是否对称
        for (int i = 0; i < (len >> 1); i++) {
            if (!resList.get(i).equals(resList.get(len - 1 - i))) {
                return false;
            }
        }

        return true;
    }

    public boolean check(TreeNode left ,TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    public boolean check2(TreeNode left ,TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
