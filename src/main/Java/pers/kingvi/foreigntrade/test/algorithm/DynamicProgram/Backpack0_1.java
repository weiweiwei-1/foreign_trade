package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram;

import java.util.Arrays;

public class Backpack0_1 {

    public int getMaxValue(int[] weight, int[] value, int bagWeight) {
        int[][] dp = new int[weight.length][bagWeight + 1];
//        Arrays.fill(dp, 0);
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j < value[i]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[value.length - 1][bagWeight];
    }

    public int getMaxValue2(int[] weight, int[] value, int bagWeight) {
        int[] dp = new int[bagWeight + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < value.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagWeight];
    }

    public static void main(String args[]) {
        Backpack0_1 backpack = new Backpack0_1();
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        System.out.println(backpack.getMaxValue(weight, value, bagWeight));
        System.out.println(backpack.getMaxValue2(weight, value, bagWeight));
    }
}
