package pers.kingvi.foreigntrade.test.basetest;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCodeTest {
    public int calculate(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        int res = 0;
        char preChar = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if (!Character.isDigit(ch) && s.charAt(i) != ' ' || i == s.length() - 1) {
                switch (preChar) {
                    case '+':
                        deque.offerLast(num);
                        break;
                    case '-':
                        deque.offerLast(-num);
                        break;
                    case '*':
                        deque.offerLast(deque.pollLast() * num);
                        break;
                    case '/':
                        deque.offerLast(deque.pollLast() / num);
                        break;
                }
                preChar = ch;
                num = 0;
            }

        }
        while (!deque.isEmpty()) {
            res += deque.pop();
        }
        return res;
    }

    @Test
    public void calculateTest() {
        LeetCodeTest leetCodeTest = new LeetCodeTest();
        String s = " 3/2 ";
        int res = leetCodeTest.calculate(s);
        System.out.println(res);
    }
}
