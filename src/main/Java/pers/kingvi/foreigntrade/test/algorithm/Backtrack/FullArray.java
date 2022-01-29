package pers.kingvi.foreigntrade.test.algorithm.Backtrack;


import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FullArray {
    List<List<Integer>> res = new LinkedList<>();
    List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return res;
    }

    void backTrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track);
            track.removeLast();
        }
    }

    @Test
    public void test() {
        FullArray fullArray = new FullArray();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res1 = fullArray.permute(nums);
        Iterator it = res1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
