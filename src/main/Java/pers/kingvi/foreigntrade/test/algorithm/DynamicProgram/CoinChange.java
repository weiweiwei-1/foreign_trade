package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram;

public class CoinChange {
    private int getWays(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i- 1][j];
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String args[]) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.getWays(coins, amount));
    }
}
