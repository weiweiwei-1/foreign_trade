package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public int loVaP(String s) {
        int maxLength = 0;
        if ("".equals(s)) {
            return 0;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(-1);
        for (int i =  0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dq.push(i);
            } else {
                dq.pop();
                if (dq.isEmpty()) {
                    dq.push(i);
                } else {
                    maxLength = Math.max(i - dq.peek(), maxLength);
                }
            }
        }
        return maxLength;
    }

    @Test
    public void testSelf() {
        LongestValidParentheses res = new LongestValidParentheses();
        String s = ")))(())))";
        res.loVaP(s);
    }
}
