package com.ants.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ants_
 */
public class MeshMigration1260 {

    public static void main(String[] args) {
        MeshMigration1260 test=new MeshMigration1260();
      //  List<List<Integer>> lists = test.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
        List<List<Integer>> lists = test.shiftGrid(new int[][]{{100}}, 0);

        for (List<Integer> list : lists) {
            list.forEach(x-> System.out.println(x));
        }
    }


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> re=new ArrayList<>();
        if (grid.length<=0){
            return re;
        }
        int m=grid.length;
        int n=grid[0].length;
        if (k<=0){
            for (int a1=0;a1<m;a1++){
                List<Integer> charge=new ArrayList<>();
                for (int b1=0;b1<n;b1++){
                    charge.add(grid[a1][b1]);
                }
                re.add(charge);
            }
            return  re;
        }

        int[][] temp = new int[m + 1][n + 1];
        while (k>=1) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j + 1] = grid[i][j];
                    if (j == n - 1) {
                        temp[i + 1][0] = grid[i][n - 1];
                    }
                }
            }
            temp[0][0] = grid[m - 1][n - 1];
            // temp转grid
            for (int c=0;c<m;c++){
                for (int d=0;d<n;d++){
                    grid[c][d]=temp[c][d];
                    if (k!=1){
                        temp[c][d]=0;
                    }

                }
            }

            k=k-1;
        }

        // 转成list
        for (int a=0;a<m;a++){
            List<Integer> charge=new ArrayList<>();
            for (int b=0;b<n;b++){
                charge.add(temp[a][b]);
            }
            re.add(charge);
        }
        return  re;

    }

    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 0; i < m; i++) {
                List<Integer> row = new ArrayList<Integer>();
                for (int j = 0; j < n; j++) {
                    row.add(0);
                }
                ret.add(row);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int index1 = (i * n + j + k) % (m * n);
                    ret.get(index1 / n).set(index1 % n, grid[i][j]);
                }
            }
            return ret;
        }
    }


}
