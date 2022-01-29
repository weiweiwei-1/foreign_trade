package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram;

import org.junit.Test;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int num = sum / 2;
        boolean[][] dp = new boolean[N + 1][num + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= num; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[N][num];
    }

    @Test
    public void testCanPartition() {

    }
}
