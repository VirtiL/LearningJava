package demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树遍历
 * @author: zhangcq
 * @Time: 2019-7-20 11:48
 * @Version 1.0
 */
public class Demo8 {

    public static void main(String[] args) {
        Node node = new Node();
        node.setValue("A");
        Node left = new Node();
        left.setValue("B");
        Node zright = new Node();
        zright.setValue("D");
        left.setRight(zright);
        node.setLeft(left);
        Node right = new Node();
        right.setValue("C");
        node.setRight(right);

//        twoNode(node);


        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(left);
        nodes.add(right);
        nodes.add(zright);
        node.setChild(nodes);
//        nNode(node);

        ddnNode(node);




    }

    /**
     * 二叉树遍历
     * @param node
     */
    private static void twoNode(Node node) {
        if(node != null){
            //前序    根左右
//            System.out.println(node.value);
//            forNode(node.getLeft());
//            forNode(node.getRight());

            //中序    左根右
//            forNode(node.getLeft());
//            System.out.println(node.value);
//            forNode(node.getRight());


            //后序    左右根
//            forNode(node.getLeft());
//            forNode(node.getRight());
//            System.out.println(node.value);

            //层序遍历  根左右左右左右...
            twoNode(node.getLeft());
            twoNode(node.getRight());
            System.out.println(node.value);






        }

    }

    /**
     * n叉树遍历(递归)
     * @param node
     */
    private static void nNode(Node node) {

        if(null == node || node.getValue() == null){
            return;
        }

        //前序
//        System.out.println(node.getValue());
//        if(node.getChild() != null)
//        for (Node child : node.getChild()) {
//            nNode(child);
//        }

        //后序
        if(node.getChild() != null)
        for (Node child : node.getChild()) {
            nNode(child);
        }
        System.out.println(node.getValue());




    }


    /**
     * n叉树遍历(迭代)
     * @param node
     */
    private static void ddnNode(Node node) {
        //前序
//        List<String> res = new ArrayList<>();
//        if (node == null) return;
//        Stack<Node> stack = new Stack<>();
//        stack.push(node);
//        while (!stack.isEmpty()) {
//            Node cur = stack.pop();
//            //将该节点的子节点从右往左压入栈
//            if(cur.getChild() != null && cur.getChild().size() > 0){
//                List<Node> nodeList = cur.getChild();
//                for (int i = nodeList.size() - 1; i >= 0; i--) {
//                    stack.push(nodeList.get(i));
//                }
//            }
//            //头结点加入结果集
//            res.add(cur.getValue());
//        }
//        System.out.println(res);

        //后序
        List<String> res = new ArrayList<>();
        if (node == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Node index = null;
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            if(cur.getChild() == null || cur.getChild().size() == 0 || (index != null && cur.getChild().contains(index))){
                Node pop = stack.pop();
                res.add(pop.getValue());
                index = pop;
            }else{
                List<Node> nodeList = cur.getChild();
                //将该节点的子节点从右往左压入栈
                for (int i = nodeList.size() - 1; i >= 0; i--) {
                    stack.push(nodeList.get(i));
                }

            }
        }
        System.out.println(res);
    }


}