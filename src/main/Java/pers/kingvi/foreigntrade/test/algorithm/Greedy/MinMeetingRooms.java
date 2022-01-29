package pers.kingvi.foreigntrade.test.algorithm.Greedy;

import org.junit.Test;

import java.util.Arrays;

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] meetings) {
        if (meetings.length == 0) {
            return -1;
        }
        int L = meetings.length;
        int[] begin = new int[L];
        int[] end = new int[L];
        for (int i = 0; i < L; i++) {
            begin[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        int i = 0, j = 0, count = 0, res = 0;
        while (i < L && j < L) {
            if (end[j] > begin[i]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    @Test
    public void testMinMeetingRooms() {
        int[][] meetings = {{0,30}, {5,10}, {15,20}};
        System.out.println(minMeetingRooms(meetings));
    }
}
