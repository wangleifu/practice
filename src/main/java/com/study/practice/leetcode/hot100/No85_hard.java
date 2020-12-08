package com.study.practice.leetcode.hot100;

/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * rows == matrix.length
 * cols == matrix.length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/10 9:57
 */
public class No85_hard {

    public static void main(String[] args) {
        No85_hard no85 = new No85_hard();
        System.out.println(no85.maximalRectangle2(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'}, {'1','1','1','1','1'},{'1','0','0','1','0'}}));
        System.out.println(no85.maximalRectangle2(new char[][]{{}}));
        System.out.println(no85.maximalRectangle2(new char[][]{{'0'}}));
        System.out.println(no85.maximalRectangle2(new char[][]{{'1'}}));
        System.out.println(no85.maximalRectangle2(new char[][]{{'0'}, {'0'}}));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int k = i;
                    int minWidth = Integer.MAX_VALUE;
                    while (k < rows && matrix[k][j] == '1') {
                        int l = j;
                        while (l < cols && matrix[k][l] == '1') l++;

                        minWidth = Math.min(minWidth, (l-j));
//                        int curArea = (k-i+1) * minWidth;
//                        if (curArea > maxArea) {
//                            System.out.println("i: " + i + "\tj: " + j);
//                            System.out.println("k: " + k + "\tl: " + l);
//                            System.out.println("minWidth: " + minWidth);
//                            System.out.println("area: " + curArea);
//                        }
                        maxArea = Math.max(maxArea, (k-i+1) * minWidth);
                        k++;
                    }
                }
            }
        }

        return maxArea;
    }

    public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j-1] + 1;

                    int width = dp[i][j];
                    for (int k = i; k >= 0 ; k--) {
                        width = Math.min(width, dp[k][j]);
                        maxArea = Math.max(width * (i-k+1), maxArea);
                    }
                }
            }
        }
        return maxArea;
    }

    public int maximalRectangle3(char[][] matrix) {
        if (matrix.length == 0) return 0;
        return 0;
    }
}
