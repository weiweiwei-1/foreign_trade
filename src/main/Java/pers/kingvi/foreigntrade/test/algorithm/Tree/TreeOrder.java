package pers.kingvi.foreigntrade.test.algorithm.Tree;

import sun.reflect.generics.tree.Tree;

import java.security.cert.TrustAnchor;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TreeOrder {
    private String NULL = "#";
    private String SEP = ",";
    private int[] array =  {
        1, 2, 3, 4, 5, 6, 7, 8, 9
    };
    private int length = array.length;
    private List<TreeNode> list = new LinkedList<>();
    public void createBinTree() {
        for (int i = 0; i < length; i++) {
            list.add(new TreeNode(array[i]));
        }
        for (int i = 0; i < length / 2 - 1; i++) {
            list.get(i).left = list.get(2 * i + 1);
            list.get(i).right = list.get(2 * i + 2);
        }
        if (length % 2 == 0) {
            list.get(length / 2 - 1).left = list.get(array[length - 1]);
        } else {
            list.get(length / 2 - 1).left = list.get(array[length - 2]);
            list.get(length / 2 - 1).right = list.get(array[length - 1]);
        }
    }
    public int countTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countTreeNode(root.left) + countTreeNode(root.right);
    }

    public void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        System.out.println("添加的值为："+root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    public void midOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        midOrder(root.left, result);
        result.add(root.val);
        System.out.println("输出根结点为：" + root.val);
        midOrder(root.right, result);
    }

    public void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    public List<String> preTreeToArray(TreeNode root, List<String> list) {
        if (root == null) {
            return null;
        }
        list.add(root.val + "");
        preTreeToArray(root.left, list);
        preTreeToArray(root.right, list);
        return list;
    }

    public List<String> inTreeToArray(TreeNode root, List<String> list) {
        if (root == null) {
            return null;
        }
        inTreeToArray(root.left, list);
        list.add(root.val + "");
        inTreeToArray(root.right, list);
        return list;
    }

    public List<String> postTreeToArray(TreeNode root, List<String> list) {
        if (root == null) {
            return null;
        }
        postTreeToArray(root.left, list);
        postTreeToArray(root.right, list);
        list.add(root.val + "");
        return list;
    }

//序列化和反序列化   1.前序遍历，将二叉树存入StringBuilder
    void serialize(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("#").append(SEP);
            return;
        }
        str.append(root.val + "").append(SEP);
        serialize(root.left, str);
        serialize(root.right, str);
    }

    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(root, str);
        return str.toString();
    }

    //序列化和反序列化   1.前序遍历，将StringBuilder转化为二叉树
    public TreeNode deSerialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        String[] strArray = data.split(",");
        Collections.addAll(list, strArray);
        return deSerialize(list);
    }


    public TreeNode deSerialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deSerialize(nodes);
        root.right = deSerialize(nodes);
        return root;
    }

    //查找重复子数
    Map<String, Integer> meno = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();
    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = root.val + "," + left + "," + right;
        int freq = meno.getOrDefault(subTree, 0);
        if (freq == 1) {
            res.add(root);
        }
        meno.put(subTree, freq + 1);
        return subTree;
    }

    //二叉搜索数
    //找到最大值
    public int findMax(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = findMax(root.left);
        int right = findMax(root.right);
        return root.val > max(left, right) ? root.val : max(left, right);
    }

    //找到最小值
    public int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int left = findMin(root.left);
        int right = findMin(root.right);
        return root.val < min(left, right) ? root.val : min(left, right);
    }


    //判断是否是合法的二叉搜索数
    boolean symbol = true;
    public boolean isBst(TreeNode root, int lastValue) {
        if (root == null) {
            return true;
        }
        isBst(root.left, lastValue);
        if (root.val <= lastValue) {
            symbol = false;
        } else {
            lastValue = root.val;
        }
        isBst(root.right, lastValue);
        return symbol;
    }

    //判断二叉搜索树是否有相关的对象
    public boolean isInBst(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        return isInBst(root.left, target) || isInBst(root.right, target);
    }

    //上面算法的简化版
    public boolean isInBstEasy(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val < target) {
            return isInBstEasy(root.right,target);
        } else {
            return isInBstEasy(root.left, target);
        }
    }

    //找到二叉树节点的和
    public int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + findSum(root.left) + findSum(root.right);
    }

    //计算完全二叉数和节点数
    public int findNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode l = root, r = root;
        int hl = 0, rl = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            rl++;
        }
        if (hl == rl) {
            return (int)Math.pow(2, hl) - 1;
        }
        return 1 + findNodeCount(root.left) + findNodeCount(root.right);
    }

    //求二叉树的深度
    public int findTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(1 + findTreeDepth(root.left), 1 + findTreeDepth(root.right));
    }

    private int maxSum = 0;
    //求一棵二叉搜索树最大键值和
    public int[] maxSubTree(TreeNode root) {
        if (root == null) {
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = maxSubTree(root.left);
        int[] right = maxSubTree( root.right);
        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(left[1], root.val);
            res[2] = Math.max(right[2], root.val);
            res[3] = root.val + left[3] + right[3];
            maxSum = Math.max(maxSum, res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }
    public int getmaxSum() {
        return maxSum;
    }


    //判断二叉树是否是完全二叉树
    public boolean isTotalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = findTreeDepth(root.left);
        int rightDepth = findTreeDepth(root.right);
        if (leftDepth - rightDepth >= 2 || rightDepth > leftDepth) {
            return false;
        }
        return isTotalTree(root.left) && isTotalTree(root.right);
    }
}
