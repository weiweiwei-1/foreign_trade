package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix, int i, int j) {
        if (i == 0) {
            return matrix[i][j];
        } else {
            if (j == 0) {
                return matrix[i][j] + Math.min(minFallingPathSum(matrix, i - 1, j), minFallingPathSum(matrix, i - 1, j + 1));
            }
            if (j == matrix[0].length - 1) {
                return matrix[i][j] + Math.min(minFallingPathSum(matrix, i - 1, j - 1), minFallingPathSum(matrix, i - 1, j));
            }
            else {
                int subProblem = Integer.MAX_VALUE;
                for(int index = j - 1; index <= j + 1; index++) {
                    subProblem = Math.min(subProblem, minFallingPathSum(matrix, i - 1, index));
                }
                return matrix[i][j] + subProblem;
            }
        }
    }
}
