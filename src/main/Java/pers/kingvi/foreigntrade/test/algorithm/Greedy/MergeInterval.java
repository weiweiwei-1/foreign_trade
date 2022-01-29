package pers.kingvi.foreigntrade.test.algorithm.Greedy;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
        int pre_start = intervals[0][0], start = 0, pre_end = intervals[0][1], end = 0;
        List<int[]> array = new ArrayList<int[]>();
        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];
            start =  intv[0];
            end = intv[1];
            if (end >= pre_end && start <= pre_end) {
                pre_end = end;
                if (pre_end == intervals[intervals.length - 1][1]) {
                    array.add(new int[]{pre_start, pre_end});
                }
            }
            if (start > pre_end) {
                int[] intv_temp = new int[2];
                intv_temp[0] = pre_start;
                intv_temp[1] = pre_end;
                array.add(intv_temp);
                pre_start = start;
                pre_end = end;
                if (pre_end == intervals[intervals.length - 1][1]) {
                    array.add(new int[]{pre_start, pre_end});
                }
            }
        }
        /*int[][] res = new int[array.size()][2];
        for (int i = 0; i < array.size(); i++) {
            res[i][0] = array.get(i)[0];
            res[i][1] = array.get(i)[1];
        }*/
        return array.toArray(new int[0][]);
    }


    @Test
    public void testMerge() {
        int[][] array = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(array);
        System.out.println(res);
    }
}
