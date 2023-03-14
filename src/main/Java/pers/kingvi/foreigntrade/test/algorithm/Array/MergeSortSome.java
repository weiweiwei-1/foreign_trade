package pers.kingvi.foreigntrade.test.algorithm.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortSome {
    public void mergeSort(int[] nums, int start, int end) {
        if (end == start) {
            System.out.println(start);
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1;
        int index = 0;
        while (i <= mid && j <= end) {
            temp[index++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= end) {
            temp[index++] = nums[j++];
        }
        for (int k = start; k <= end; k++) {
            nums[k] = temp[k - start];
        }
    }

    public int[] mergeSort2(int[] nums, int left, int right) {
        if (left == right) {
            return new int[]{ nums[left] };
        }
        int mid = left + (right - left) / 2;
        int[] leftNum = mergeSort2(nums, left, mid);
        int[] rightNum = mergeSort2(nums, mid + 1, right);
        int[] resNum = new int[right - left + 1];
        int leftIndex = 0, rightIndex = 0, resIndex = 0;
        while (leftIndex < leftNum.length && rightIndex < rightNum.length) {
            resNum[resIndex++] = leftNum[leftIndex] <= rightNum[rightIndex] ? leftNum[leftIndex++] : rightNum[rightIndex++];
        }
        while (leftIndex < leftNum.length) {
            resNum[resIndex++] = leftNum[leftIndex++];
        }
        while (rightIndex < rightNum.length) {
            resNum[resIndex++] = rightNum[rightIndex++];
        }
        return resNum;
    }

    public  static void main(String[] args) {
        int[] nums = {2,3,3,4,8,6,2,3,8,9,0,2,5};
        MergeSortSome mergeSortSome = new MergeSortSome();
//        mergeSortSome.mergeSort(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
        int[] res = mergeSortSome.mergeSort2(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(res));
        List<Integer> list = new ArrayList<>();
//        tasks = ["A","A","A","B","B","B"],
        System.out.println('D' - 'A');
        String a = "adf";
        String b = "adf";
        System.out.println(a == (b + ""));
    }
}
