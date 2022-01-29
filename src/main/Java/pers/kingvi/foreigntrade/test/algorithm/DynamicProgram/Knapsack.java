package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram;

import org.junit.Test;

public class Knapsack {
    public int knapsack(int W, int[] weight, int[] val) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - weight[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][W];
    }

    @Test
    public void test() {
        Knapsack knapsack = new Knapsack();
        int W = 4;
        int[] wt = {2, 1, 3}, val = {4, 2, 3};
        System.out.println(knapsack.knapsack(W, wt, val));
    }
}
