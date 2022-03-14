package pers.kingvi.foreigntrade.test.algorithm.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int second = i + 1, third = length - 1;
            while (second < third) {
                if (nums[second] == nums[third]) {
                    break;
                }
                if (nums[second] + nums[third] < target) {
                    second++;
                } else if (nums[second] + nums[third] > target){
                    third--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    res.add(temp);
                }
            }
            continue;
        }
        return res;
    }

    @Test
    public void testArray() {
        Solution a = new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(a.threeSum(nums));
    }
}