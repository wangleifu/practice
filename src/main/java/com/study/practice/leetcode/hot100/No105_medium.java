package com.study.practice.leetcode.hot100;

import com.study.practice.leetcode.util.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/16 9:44
 */
public class No105_medium {
    public static void main(String[] args) {
        No105_medium no105_medium = new No105_medium();
        System.out.println(No102_medium.levelOrder(no105_medium.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7})));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStartIndex, int preEndIndex, int[] inorder, int inStartIndex, int inEndIndex) {
        if (preEndIndex < preStartIndex) {
            return null;
        }

        if (preEndIndex == preStartIndex) {
            return new TreeNode(preorder[preStartIndex]);
        }

        int leftNum = 0;
        while (inorder[inStartIndex+leftNum] != preorder[preStartIndex]) {
            leftNum++;
        }

        TreeNode curRoot = new TreeNode(preorder[preStartIndex]);
        curRoot.left = build(preorder, preStartIndex+1, preStartIndex+leftNum, inorder, inStartIndex, inStartIndex+leftNum-1);
        curRoot.right = build(preorder, preStartIndex+leftNum+1, preEndIndex , inorder, inStartIndex + leftNum+1, inEndIndex);

        return curRoot;
    }
}
