package com.study.practice.exam;

import java.util.Arrays;

/**
 * @author wangleifu (wangleifu@rd.netease.com)
 * @date 2020/11/23 16:17
 */
public class Codility {

    public static void main(String[] args) {
        System.out.println(solution(null));
        System.out.println(solution(new int[]{}));

        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{-1, -3, 2}));
    }

    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        Arrays.sort(A);

        // binary search
        int left = 0, right = A.length-1;
        int mid;
        if (A[0] > 0) {
            mid = left;
        } else if (A[A.length-1] <= 0) {
            return 1;
        } else {
            while (left < right) {
                mid = (right -left) >> 1;
                if (mid > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            mid = left;
        }

        if (A[mid] != 1) {return 1;}
        for (int i = mid+1; i < A.length; i++) {
            if (A[i] - A[i-1] > 1) {
                return A[i-1]+1;
            }
        }

        return A[A.length-1]+1;
    }
}
