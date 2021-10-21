package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram;

import java.util.Map;

public class Fibonacci {
    public int fib(Map<Integer, Integer> map, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, fib(map, n - 1) + fib(map, n - 2));
        return map.get(n);

    }
}
