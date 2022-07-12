package com.ants.leetcode.simple;

/**
 * @author ants_
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 * <p>
 * 另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 * <p>
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 * <p>
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OddCellNumber1252 {
    public static void main(String[] args) {
        OddCellNumber1252 test = new OddCellNumber1252();
        int i = test.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}});
        System.out.println(i);
    }

    public int oddCells(int m, int n, int[][] indices) {
        int re = 0;
        if (indices.length <= 0 || indices == null) {
            return re;
        }
        int[][] temp = new int[m][n];
        // 要修改多少次
        for (int i = 0; i < indices.length; i++) {
            // 每次具体修改 (可以去掉，题上说了只有二维数组）
            for (int j = 0; j < indices[0].length; j++) {
                // 行+1
                if (j == 0) {
                    for (int a = 0; a < n; a++) {
                        temp[indices[i][j]][a] = temp[indices[i][j]][a] + 1;
                    }
                }
                // 列+1
                if (j == 1) {
                    for (int b = 0; b < m; b++) {
                        temp[b][indices[i][j]] = temp[b][indices[i][j]] + 1;
                    }
                }
            }
        }
        // 判断奇数个数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isOdd(temp[i][j])) {
                    re++;
                }
            }
        }


        return re;

    }

    public boolean isOdd(int number) {
        return (number & 1) == 1;
    }
}
