package pers.kingvi.foreigntrade.test.algorithm.Array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class ArrayTest {
    @Test
    public void testAdvantageCount() {
        AdvantageCount solution = new AdvantageCount();
        int[] nums1 = {2,0,4,1,2};
        int[] nums2 = {1,3,0,0,2};
        int[] res = solution.advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void testSlideWindow() {
        String s="abc";
        String t = "ade";
        String result = new SlideWindow().minWindow(s, t);
        System.out.println(result);
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
    }
}
