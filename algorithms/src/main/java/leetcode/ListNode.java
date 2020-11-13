package leetcode;

/**
 * @Description:
 * @Author: VirtiL
 * @Date: 2020-11-13 10:33
 */
public class ListNode {
    int val;//当前节点的值
    ListNode next;//下一个节点的指针

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}