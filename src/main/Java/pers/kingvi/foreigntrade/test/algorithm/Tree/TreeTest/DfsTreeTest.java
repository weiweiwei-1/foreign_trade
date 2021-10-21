package pers.kingvi.foreigntrade.test.algorithm.Tree.TreeTest;

import org.junit.Test;
import pers.kingvi.foreigntrade.test.algorithm.Tree.Dfs;

import java.util.List;

public class DfsTreeTest {
    @Test
    public void testAllPathsSourceTarget() {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> res = new Dfs().allPathsSourceTarget(graph);
        System.out.println(res);
    }

    @Test

    public void testAllPathsSourceTarget2() {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> res = new Dfs().allPathsSourceTarget2(graph);
        System.out.println(res);
    }
}
