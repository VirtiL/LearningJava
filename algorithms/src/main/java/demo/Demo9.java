package demo;

/**
 * @Description: 求二叉树最长节点路径
 * @author: zhangcq
 * @Time: 2019-7-20 12:57
 * @Version 1.0
 */
public class Demo9 {


    public static void main(String[] args) {
        Node node = new Node();
        int len = length(node);
        System.out.println(len);
    }

    private static int length(Node node) {
        if (node == null) return 0;
        int left = length(node.left);
        int right = length(node.right);
        return Math.max(left,right)+1;
    }

}