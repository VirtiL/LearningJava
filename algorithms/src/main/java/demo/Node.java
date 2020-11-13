package demo;

import java.util.List;
import java.util.Objects;

/**
 * @Description: 树节点
 * @author: zhangcq
 * @Time: 2019-7-20 12:58
 * @Version 1.0
 */
public class Node {
    Node left;
    Node right;
    String value;
    List<Node> child;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getChild() {
        return child;
    }

    public void setChild(List<Node> child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }
}