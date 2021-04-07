package pers.kingvi.foreigntrade.test.basetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FutuTest {
//        去无序数组中第二小的
    public static int getSecondMin(int[] a) {
        if (a.length <= 1) {
            return -1;
        }
        int length = a.length;
        int target = a[0];
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (target > a[i]) {
                target = a[i];
                list.add(a[i]);
            }
        }
        index = list.size() - 1;
        return list.get(index);
    }
}
