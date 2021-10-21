package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram.DynamicTest;

import org.junit.Test;
import pers.kingvi.foreigntrade.test.algorithm.DynamicProgram.MinFallingPathSum;

public class FallingPathTest {
    @Test
    public void testMinFallingPathSum() {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
        System.out.println(minFallingPathSum.minFallingPathSum(matrix, 2, 2));
    }
}
