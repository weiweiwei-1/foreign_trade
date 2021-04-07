package pers.kingvi.foreigntrade.test.basetest;





import java.util.*;

public class Algorithm {
    //冒泡排序
    //选择排序
    //插入排序
    //希尔排序
    //归并排序
    //快速排序


    //冒泡排序
    public void bubbleSort(int[] a) {
        int l = a.length;
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    //选择排序
    public void selectSort(int[] a) {
        int l = a.length;
        int temp;
        for (int i = 0; i < l - 1; i++) {
            int mindex = i;
            for (int j = i + 1; j < l; j++) {
                if (a[j] < a[mindex]) {
                    mindex = j;
                }
            }
            temp = a[i];
            a[i] = a[mindex];
            a[mindex] = temp;
        }
    }

    //插入排序
    public void insertSort(int[] a) {
        int l = a.length;
        int temp;
        for (int i = 1; i < l; i++) {
            int preIndex = i - 1;
            while (preIndex > 0 && a[preIndex] > a[preIndex + 1]) {
                temp = a[preIndex];
                a[preIndex] = a[preIndex + 1];
                a[preIndex + 1] = temp;
                preIndex--;
            }
        }
    }

    //希尔排序，平均时间复杂度为n的1/3，空间复杂度为1
    public void shellSort(int[] a) {
        int l = a.length;
        while (true) {
            l = l / 2;
            for (int i = 0; i < l; i++) {
                for (int j = i + l; j < a.length; j += l) {
                    int k = j - l;
                    while (k > 0 && a[k] > a[k + l]) {
                        int temp = a[k];
                        a[k] = a[k + l];
                        a[k + l] = temp;
                        k -= l;
                    }
                }
            }
            if (l == 1) {
                break;
            }
        }
    }

    //归并排序，平均时间复杂度为nlogn, 平均空间复杂度为n
    public static int[] mergeSort(int[] a, int l, int h) {
        if (l == h) {
            return new int[]{a[l]};
        }
        int mid = (l + h - 1) / 2;
        int[] leftArr = mergeSort(a, l, mid);
        int[] rightArr = mergeSort(a,mid + 1, h);
        int[] arr = new int[leftArr.length + rightArr.length];
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
        return arr;
    }

    //快速排序，平均时间复杂度为nlogn, 平均空间复杂度为nlogn
    public static int[] quickSort(int[] a, int start, int end) {
        int pivot = a[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && a[i] < pivot) {
                i++;
            }
            while (i < j && a[j] > pivot) {
                j--;
            }
            if (a[i] == a[j] && i < j) {
                i++;
            } else {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        if (i - 1 > start) {
            quickSort(a, start, i - 1);
        }
        if (j + 1 < end) {
            quickSort(a, j + 1, end);
        }
        return a;
    }

    //查找算法,二分查找
    public int binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length;
        while (left <= right) {
            int mid = (left + right)/2;
            if (a[mid] == target) {
                return mid;
            } else if (target < a[mid]) {
                right = mid - 1;
            } else if (target > a[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    //数组中重复的数字
    public static List<Integer> findRepeatNumber(int[] a){
        int l = a.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                if (a[j] == a[i]) {
                    list.add(a[i]);
                    break;
                }
            }
        }
        return list;
    }

    //数组中重复的数字,另一种方法
    public static int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums)
            if (!set.add(num)) {
                repeat = num;
            }
        return repeat;
    }

    //数组中重复的数字,哈希表
    public static int findRepeatNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsValue(nums[i])) {
                System.out.println("随机重复数");
                return nums[i];
            }
            map.put(i, nums[i]);
        }
        return -1;
    }

    //发现重复数字
    public int findRepeatNumber3(int[] nums) {
        for(int i = 0;i < nums.length ; i++){
            nums[i] = nums[i]+1;
        }
        int out = 0;
        for (int i = 0; i < nums.length ; i++) {
            //nums[i]可能为负(为负是因为这个下标对应的元素出现过了)，所以应该用绝对值表示
            int index = Math.abs(nums[i]);
            if (nums[index-1]<0){
                out = index-1;
                break;
            }
            nums[index-1] *= (-1) ;
        }
        return out;
    }

   /* public int findRepeatNumber4(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                temp = nums[i];
                nums[i] = i;
                nums[temp] = nums[i];
            }


        }
    }*/

    //顺序二维数组的查找
    public boolean findNumberArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = 0, n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (target == matrix[m][n]) {
                return true;
            } else if (target < matrix[m][n]) {
                n--;
            } else if (target > matrix[m][n]) {
                m++;
            }
        }
     return false;
    }

    public boolean findNumberArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length - 1, n = 0;
        while (m >= 0 && n < matrix[0].length) {
            if (target == matrix[m][n]) {
                return true;
            } else if (target < matrix[m][n]) {
                m--;
            } else if (target > matrix[m][n]) {
                n++;
            }
        }
        return false;
    }

    //顺序二维数组的查找暴力法
    public boolean findNumberArray2(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }


    //替换空格
    public String replaceSpace(String s) {
        int m = s.length();
        char[] array = new char[m*3];
        int size = 0;
        for (int i = 0; i < m; i++) {
            if (' ' == s.charAt(i)) {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = s.charAt(i);
            }
        }
        return new String(array,0, size);
    }

    //替换空格
    public String replaceSpace1(String s) {
        int l = s.length();
        char[] chars =  new char[l*3];
        int size = 0;
        if (s.charAt(0) == ' ') {
            chars[size++] = '%';
            chars[size++] = '2';
            chars[size++] = '0';
        }
        for (int i = 1; i < l; i++) {
            if (' ' == s.charAt(i) && s.charAt(i - 1) != ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                if (' ' == s.charAt(i) && s.charAt(i - 1) == ' ') {
                    continue;
                }
                chars[size++] = s.charAt(i);
            }
        }
        return new String(chars, 0, size);
    }

    //替换空格
    public String replaceSpace2(String s) {
        return s.replace(" ", "20%");
    }

    //去掉空格
    public String deleteSpace(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }

    public String deleteSpace1(String s) {
        int length = s.length();
        char[] array = new char[length];
        int size = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            array[size++] = s.charAt(i);
        }
        return new String(array, 0, size);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }


  /*  public static */

}