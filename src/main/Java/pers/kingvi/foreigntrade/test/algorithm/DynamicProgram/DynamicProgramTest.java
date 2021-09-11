package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram;

import org.junit.Test;

public class DynamicProgramTest {
    @Test
    public void coin() {
        int [] coins = {4, 3};
        int amount = 5;
        System.out.print(DynamicProgram.coinChange(coins, amount));
//        System.out.print(DynamicProgram.coinChange1(coins, amount));
    }

    @Test
    public void shortestRoad() {
//        {2,1,3},{6,5,4},{7,8,9}
//        {-19,57},{-40,-5}
        int[][] matrix = new int[][] {{2,1,3},{6,5,4},{7,8,9}};

        /*int res = Integer.MAX_VALUE;
        for (int j = 0; j < matrix.length; j++) {
            res = Math.min(res, DynamicProgram.minFallingPathSum(matrix, matrix.length - 1, j));
        }
        System.out.print(res);*/
//        System.out.print(DynamicProgram.minFallingPathSum2(matrix));
        System.out.print(DynamicProgram.minFallingPathSum3(matrix));
    }

    @Test
    public void minPath() {
        int[][] matrix = {{1,2,3},{4,5,6}};
//        System.out.print(DynamicProgram.minPathSum(matrix));
        System.out.print(DynamicProgram.minPathSum2(matrix));

    }
}
