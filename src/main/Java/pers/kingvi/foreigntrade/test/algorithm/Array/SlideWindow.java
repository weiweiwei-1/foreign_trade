package pers.kingvi.foreigntrade.test.algorithm.Array;

import java.util.HashMap;
import java.util.Map;

public class SlideWindow {
    Map<Object, Integer> getArrayMap(String target) {
        Map<Object, Integer> res = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            int fre = res.getOrDefault(target.charAt(i), 0) + 1;
            res.put(target.charAt(i), fre);
        }
        return res;
    }
    public String minWindow(String s, String t) {
        Map<Object, Integer> subString = getArrayMap(t);
        Map<Object, Integer> record = new HashMap<>();
        String result = "";
        int left, right, valid, len = Integer.MAX_VALUE;
        left = right = valid = 0;
        while (right < s.length()) {
            char aim = s.charAt(right);
            right++;
            if (subString.containsKey(aim)) {
                int fre = record.getOrDefault(aim, 0) + 1;
                record.put(aim, fre);
                if (record.get(aim) == subString.get(aim)) {
                    valid++;
                }

            }
            while (valid == subString.size()) {
                char leftAim = s.charAt(left);
                int temLen = right - left;
                if (temLen < len) {
                    result = s.substring(left, right);
                    len = temLen;
                }
                if (record.containsKey(leftAim)) {
                    record.put(leftAim, record.get(leftAim) - 1);
                    if (record.get(leftAim) < subString.get(leftAim)) {
                        valid --;
                    }
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? " " : result;
    }
}
