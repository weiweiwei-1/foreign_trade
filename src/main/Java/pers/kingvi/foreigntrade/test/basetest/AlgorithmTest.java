package pers.kingvi.foreigntrade.test.basetest;

import org.junit.Test;

import java.util.Arrays;

public class AlgorithmTest {
    int[] a = {1,15,2,8,8,7,2,5,7,23};
    Algorithm algorithm =  new Algorithm();
    int[][] b = new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
    @Test
    public void testbubbleSort() {
        algorithm.bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void testSelectSort() {
        algorithm.selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testInsertSort() {
        algorithm.insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void shellSort() {
        algorithm.shellSort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void mergeSort() {
        int[] b;
        b = algorithm.mergeSort(a, 0,a.length - 1);
        System.out.println(Arrays.toString(b));
    }

    @Test
    public void quickSort() {
        int[] b = algorithm.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(b));
        System.out.println(algorithm.binarySearch(a,8));
    }

    @Test
    public void findRepeatNumber() {
        /*System.out.println(algorithm.findRepeatNumber(a));
        System.out.println(algorithm.findRepeatNumber1(a));
        System.out.println(algorithm.findRepeatNumber2(a));*/
        System.out.println(algorithm.findRepeatNumber3(a));
    }

    @Test
    public void findSortArray() {
        System.out.println(algorithm.findNumberArray(b, 3));
        System.out.println(algorithm.findNumberArray1(b, 0));
        System.out.println(algorithm.findNumberArray2(b, 5));
    }

    //替换空格
    @Test
    public void replaceSpace() {
        String s = "   dafda  afda adsfa afsd ";
        System.out.println(algorithm.replaceSpace(s));
        System.out.println(algorithm.replaceSpace1(s));
        System.out.println(algorithm.replaceSpace2(s));
    }

    //去掉空格
    @Test
    public void deleteSpace() {
        String s = "fads safda sdfs afds";
        System.out.println(algorithm.deleteSpace(s));
        System.out.println(algorithm.deleteSpace1(s));
    }

    //重建二叉树
    @Test
    public void TestRebuildTree() {
        int[] a = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] b = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        TreeNode treeNode = Algorithm.buildTree(a, b);
        System.out.println(treeNode);
    }

 /*   //最短回文子串
    public int minArray(int[] a, int target) {
        if (a.length == 0) {
            return -1;
        }
        int sum = 0;
        int length = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += a[j];
                while (sum >= target) {
                    length = j - i + 1;
                    result = result < length ? result:length;
                }
                break;
            }

        }
    }*/

 @Test
    public void testgetSecondMin() {
     int[] a = {9,1,2,5,7,3};
     FutuTest test = new FutuTest();
     System.out.println(FutuTest.getSecondMin(a));
 }
}
