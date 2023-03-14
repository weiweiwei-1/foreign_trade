package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BackpackFull {

    private int getMaxValue(int[] weight, int [] value, int bagWeight) {
        int size = weight.length;
        int[][] dp = new int[size + 1][bagWeight + 1];
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j < bagWeight) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
            }
        }
        return dp[size - 1][bagWeight];
    }

    private int getMaxValue2(int[] value, int[] weight, int bagWeight) {
        int[] dp = new int[bagWeight + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagWeight];
    }

    public static void main(String args[]) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        BackpackFull backpackFull = new BackpackFull();
        System.out.println("两个变量循环结果：" + backpackFull.getMaxValue(weight, value, bagWeight));
        System.out.println("一个变量循环结果：" + backpackFull.getMaxValue2(value, weight, bagWeight));
    }
}