package middle;


import pojo.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 扁平化多级双向链表
 * @author Slience
 * @date 2022/6/12 13:48
 **/
public class FlattenAMultilevelDoublyLinkedList {

    static List<Node> res = new ArrayList<>();

    private static Node flatten(Node head){
        if(head == null){
            return head;
        }
        traverse(head);
        return getNode(res);
    }

    private static void traverse(Node head){
        res.add(head);
        if(head.child != null){
            traverse(head.child);
        }
        if(head.next != null){
            traverse(head.next);
        }
    }


    private static Node getNode(List<Node> nodes){
        Node head = new Node();
        head = nodes.get(0);
        Node p = head;
        for(int i = 1; i < nodes.size(); i++){
            p.next = nodes.get(i);
            p.child = null;
            p.next.prev = p;
            p = p.next;

        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        head.setChild(node2);
        head.setNext(node1);
        node1.setPrev(head);

        System.out.println(flatten(head).getVal());
    }


}
