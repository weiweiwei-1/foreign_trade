package pers.kingvi.foreigntrade.test.algorithm.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Dfs {
    List<List<Integer>> res = new LinkedList<>();
    //求出所有从起到到终点的路径
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    public void traverse(int[][] graph, int key, LinkedList<Integer> path) {
        int n = graph.length;
        path.add(key);
        if (key == n - 1) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for (int value: graph[key]) {
            traverse(graph, value, path);
        }
        path.removeLast();
    }

    Deque<Integer> stack = new ArrayDeque<>();
    List<List<Integer>> ans = new LinkedList<>();
    //使用第二种方法实现
    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    public void traverse2(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new LinkedList<>(stack));
        }

        for (int i: graph[x]) {
            stack.offerLast(i);
            traverse2(graph, i, n);
            stack.pollLast();
        }
    }

}
