package pers.kingvi.foreigntrade.test.algorithm.Tree.TreeTest;

import org.junit.Before;
import org.junit.Test;
import pers.kingvi.foreigntrade.test.algorithm.Tree.TreeNode;
import pers.kingvi.foreigntrade.test.algorithm.Tree.TreeOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeTest {
    private int[] array = {
            1, 2, 3, 4, 5, 6, 7, 8
    };
    private String data = "1,2,#,4,#,#,3,#,#,";
    private int length = array.length;
    private List<TreeNode> treeNodeList = new LinkedList<>();
    private List<Integer> InList = new ArrayList<>();
    private List<String> strList = new ArrayList<>();
    private LinkedList<Integer> intLinkList = new LinkedList<>();
    private TreeOrder treeOrder = new TreeOrder();
    LinkedList<String> strLinkList = new LinkedList<String>() {{
        add("1");
        add("2");
        add("#");
        add("4");
        add("#");
        add("#");
        add("3");
        add("#");
        add("#");
    }};

    //    List<String> strLinkList = Arrays.asList("1","2","#","4","#","#","3","#","#");
    @Before
    public void init() {
        for (int i = 0; i < length; i++) {
            treeNodeList.add(new TreeNode(array[i]));

        }
        for (int i = 0; i < length / 2 - 1; i++) {
            treeNodeList.get(i).left = treeNodeList.get(2 * i + 1);
            treeNodeList.get(i).right = treeNodeList.get(2 * i + 2);
        }
        int lastIndex = array.length / 2 - 1;
        treeNodeList.get(lastIndex).left = treeNodeList.get(lastIndex * 2 + 1);
        if (length % 2 != 0) {
            treeNodeList.get(lastIndex).right = treeNodeList.get(lastIndex * 2 + 2);
        }

    }


    @Test
    public void testTreeOrder() {
        treeOrder.preOrder(treeNodeList.get(0), InList);
        Integer[] length = new Integer[InList.size()];
        Integer[] res = InList.toArray(length);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void testMidOrder() {
        treeOrder.midOrder(treeNodeList.get(0), InList);
        Integer[] length = new Integer[InList.size()];
        Integer[] res = InList.toArray(length);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void testPostOrder() {
        treeOrder.postOrder(treeNodeList.get(0), InList);
        Integer[] length = new Integer[InList.size()];
        Integer[] res = InList.toArray(length);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void testPreTreeToArray() {
        List<String> res = treeOrder.preTreeToArray(treeNodeList.get(0), strList);
        System.out.println(res);
    }

    @Test
    public void testInTreeToArray() {
        List<String> res = treeOrder.inTreeToArray(treeNodeList.get(0), strList);
        System.out.println(res);
    }

    @Test
    public void testPostTreeToArray() {
        List<String> res = treeOrder.postTreeToArray(treeNodeList.get(0), strList);
        System.out.println(res);
    }

//    前序遍历将二叉树转成字符串
    @Test
    public void testSerialize() {
        String res = treeOrder.serialize(treeNodeList.get(0));
        System.out.println(res);
    }

    @Test
    public void testDeSerialize() {
        TreeNode tree = treeOrder.deSerialize(data);
        System.out.println(tree);
        System.out.println(treeOrder.preTreeToArray(tree, strList));
    }
}
