package easy;

import pojo.ListNode;

/**
 * 回文链表
 * @author Slience
 * @date 2022/5/18 15:29
 **/
public class PalindromeLinkedList {

    private static ListNode init(){
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        node1.setVal(1);
        node2.setVal(2);
        node3.setVal(3);
        node4.setVal(2);
        node5.setVal(1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        return node1;
    }

    private static boolean isPalindrome(ListNode head) {
        int length = 1;
        ListNode node = head;
        while(node.getNext() != null){
            node = node.getNext();
            length++;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        node = head;
        int i = 1;
        while(i <= length/2){
            sb1.append(node.getVal());
            node = node.getNext();
            i++;
        }
        if((length % 2 != 0)){
           i++;
           node = node.getNext();
        }
        while(i <= length){
            sb2.append(node.getVal());
            if(node.getNext() != null){
                node = node.getNext();
            }
            i++;
        }
        System.out.println(sb1+ "\n" + sb2.reverse());
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        ListNode node = init();
        System.out.println(isPalindrome(node));
    }
}
