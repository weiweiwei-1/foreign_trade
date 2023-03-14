package pers.kingvi.foreigntrade.test.algorithm.Array;

import java.util.Deque;
import java.util.LinkedList;

public class DueueTest { public static void main(String[] args) {
    Deque<Integer> deque = new LinkedList<>();
    deque.offerLast(1);
    deque.offerLast(null);
    deque.offerLast(2);
    while (!deque.isEmpty()) {
        System.out.println(deque.pollLast());
    }


}
}
