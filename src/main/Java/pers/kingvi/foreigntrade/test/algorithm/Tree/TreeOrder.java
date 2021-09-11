package pers.kingvi.foreigntrade.test.algorithm.Tree;

import java.util.*;

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


}
