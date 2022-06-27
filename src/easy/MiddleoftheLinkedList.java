package easy;

import pojo.ListNode;

/**
 * 链表中间节点
 * @author Slience
 * @date 2022/5/18 17:47
 **/
public class MiddleoftheLinkedList {

    private static ListNode middleNode(ListNode head) {
        ListNode node = head;
        int length = 1;
        while(node.getNext() != null){
            length ++;
            node = node.getNext();
        }
        int target = length / 2 + 1;
        node = head;
        int i = 1;
        while(node.getNext() != null && i<=target){
            node = node.getNext();
            i++;
        }
        return node;
    }

}
