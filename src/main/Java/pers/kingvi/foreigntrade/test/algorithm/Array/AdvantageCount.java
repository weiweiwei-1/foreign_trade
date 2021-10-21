package pers.kingvi.foreigntrade.test.algorithm.Array;

import java.util.*;

class AdvantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        LinkedList<Map<Integer, Integer>> record2 = new LinkedList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arrayCopy = Arrays.copyOf(nums2, len2);
        int[] res = new int[len2];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] > nums2[j]) {
                Map<Integer, Integer> temp = new HashMap<>();
                temp.put(nums2[j++],nums1[i++]);
                record2.add(temp);
            }
            else {
                stack1.addLast(nums1[i++]);

            }
        }
        while (j < len2) {
            stack2.addLast(nums2[j++]);
        }
        while(!stack1.isEmpty()) {
            Map<Integer, Integer> temp = new HashMap<>();
            temp.put(stack2.removeLast(), stack1.removeLast());
            record2.add(temp);
        }
        for (int k = 0; k < arrayCopy.length; k++) {
            res[k] = record.get(arrayCopy[k]);
        }
        return res;
    }
}