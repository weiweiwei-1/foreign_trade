package pers.kingvi.foreigntrade.test.algorithm.Greedy;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return -1;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]) {
                    return 1;
                } else if (a[1] < b[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;
        deque.add(intervals[0][0]);
        for (int[] row: intervals) {
            while (row[0] < deque.peekLast()) {
                deque.removeLast();
                count++;
            }
            deque.add(row[0]);
        }
        return intervals.length - count;
    }

    @Test
    public void testRemoveCoveredIntervals() {
        int[][] array = {{1,4}, {2,3}};
        System.out.println(removeCoveredIntervals(array));
    }
}
