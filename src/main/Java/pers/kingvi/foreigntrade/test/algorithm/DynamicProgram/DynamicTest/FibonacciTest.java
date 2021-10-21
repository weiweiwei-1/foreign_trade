package pers.kingvi.foreigntrade.test.algorithm.DynamicProgram.DynamicTest;

import org.junit.Test;
import pers.kingvi.foreigntrade.test.algorithm.DynamicProgram.Fibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibonacciTest {
    @Test
    public void testFib() {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(new Fibonacci().fib(map,6));
        System.out.println(map.keySet());
    }
}
