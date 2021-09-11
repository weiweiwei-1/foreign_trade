package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram;

import static jdk.nashorn.internal.objects.NativeMath.min;

public class DynamicProgram {
//    凑零钱问题,动态规划递归
    static int coinChange(int[] coins,int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin: coins) {
            int subproblem = coinChange(coins, amount - coin);
            if (subproblem == -1) continue;
            res = Math.min(res, subproblem + 1);
        }
        if (res != Integer.MAX_VALUE) {
            return res;
        }
        return -1;
    }

    //凑零钱动态规划，非递归，时间复杂度低
    static int coinChange1(int[] coins, int amount ) {
        int [] meno = new int[amount + 1];
        meno[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int aim: coins) {
                if (i >= aim && meno[i - aim] < min) {
                    min = meno[i - aim] + 1;
                }
            }
            meno[i] = min;
        }
        return meno[amount] == Integer.MAX_VALUE ? -1 : meno[amount];
    }


    //数组最短路径，动态规划递归
    static int minFallingPathSum(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i > matrix.length || j > matrix[0].length) {
            return 99999;
        }
        if (i == 0) {
            return matrix[i][j];
        }
        int row = matrix.length, column = matrix[0].length;
        if (j == 0) {
            return matrix[i][j] + Math.min(minFallingPathSum(matrix, i - 1, j), minFallingPathSum(matrix, i - 1, j + 1));
        }
        else if (j == column - 1) {
            return matrix[i][j] + Math.min(minFallingPathSum(matrix, i - 1, j - 1), minFallingPathSum(matrix, i - 1, j));
        } else {
                return matrix[i][j] + min_three(minFallingPathSum(matrix, i - 1, j - 1), minFallingPathSum(matrix, i - 1, j), minFallingPathSum(matrix, i - 1, j + 1));
            }
        }
    static int min_three(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    static int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, minFallingPathSum(matrix, n - 1, j));
        }
        return res;
    }

//    消除重叠
static int minFallingPathSum3(int[][] matrix) {
        int n = matrix.length;
//        int count = n * n;
        int[][] meno = new int[n][n];
        for (int i = 0; i < n; i++) {
            meno[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    meno[i][j] = Math.min(meno[i - 1][j] + matrix[i][j], meno[i - 1][j + 1] + matrix[i][j]);
                } else if (j == n - 1) {
                    meno[i][j] = Math.min(meno[i - 1][j - 1] + matrix[i][j], meno[i - 1][j] + matrix[i][j]);
                } else {
                    meno[i][j] = min_three(meno[i - 1][j - 1] + matrix[i][j], meno[i - 1][j] + matrix[i][j], meno[i - 1][j + 1] + matrix[i][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, meno[n - 1][i]);
        }
        return res;

}

//最小路径和，类似上面那个,用动态规划非最优时间解决
    static int minPathSum_dp(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        } else {
            if (i == 0) {
                return minPathSum_dp(grid, 0, j - 1) + grid[i][j];
            }
            if (j == 0) {
                return minPathSum_dp(grid, i - 1, j) + grid[i][j];
            } else {
                return Math.min(minPathSum_dp(grid, i, j - 1), minPathSum_dp(grid, i - 1, j)) + grid[i][j];
            }
        }
   }

   static int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        return minPathSum_dp(grid, n - 1, m - 1);
   }

   //用动态规划最优时间解决
    static int minPathSum2(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        int[][] memo = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = grid[i][j];
                } else if (i == 0) {
                    memo[i][j] = memo[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    memo[i][j] = memo[i - 1][j] + grid[i][j];
                } else {
                    memo[i][j] = Math.min(memo[i][j - 1], memo[i - 1][j]) + grid[i][j];
                }
            }
        }
        return memo[row - 1][column - 1];
    }

}
