package pers.kingvi.foreigntrade.test.basetest;

import org.junit.Test;

import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        combinaSum(candidates, 0, target, list, 0);
        return res;
    }

    public void combinaSum(int[] candidates, int index, int target, List<Integer> ans, int sum) {
        if (sum == target ) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            ans.add(candidates[i]);
            if (sum > target) {
                sum -= candidates[i];
                ans.remove(ans.size() - 1);
                continue;
            }
            combinaSum(candidates, index + 1, target, ans, sum);
            sum -= candidates[i];
            ans.remove(ans.size() - 1);
        }
    }
    public static void main(String args[]) {
        int[] list = {10,1,2,7,6,1,5};
        Solution a = new Solution();
        a.combinationSum2(list, 8);
        int[] c = new int[128];
        c['A'] = 12;
        System.out.println(c[65]);
        System.out.println(c[0]);
        Map<Character, Set<Integer>> abc = new HashMap<>();
        char temp = '2';
        System.out.println(abc.getOrDefault(temp, new HashSet<>()));
//        int res = abc.getOrDefault(temp, new HashSet<>()).add(12);
//        abc.put('1', abc.getOrDefault(temp, new HashSet<Integer>()).add(2));
    }


//    map.put('1', map.getOrDefault(temp, new HashSet<Integer>()).add(2));
    /*@Test
    public void test() {
        Solution a = new Solution();
        int[] list = {10,1,2,7,6,1,5};
        a.combinationSum2(list, 8);
    }*/
}