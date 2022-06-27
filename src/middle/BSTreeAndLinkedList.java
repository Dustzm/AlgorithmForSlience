package middle;

import pojo.Node;
import pojo.NodeS;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树与双向链表
 * @author Slience
 * @date 2022/6/27 14:01
 **/
public class BSTreeAndLinkedList {
    List<NodeS> list = new ArrayList<>();
    public NodeS treeToDoublyList(NodeS root) {
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            root.left = root;
            root.right = root;
            return root;
        }
        middleOrder(root);
        for(int i=1;i<list.size()-1;i++){
            int right = i + 1;
            int left = i - 1;
            list.get(i).right = list.get(right);
            list.get(i).left = list.get(left);
        }
        list.get(0).left = list.get(list.size()-1);
        list.get(0).right = list.get(1);
        list.get(list.size()-1).left = list.get(list.size()-2);
        list.get(list.size()-1).right = list.get(0);
        return list.get(0);
    }

    private void middleOrder(NodeS node) {
        if (node == null) return;
        if (node.left != null) middleOrder(node.left);//如果左节点不为空,则继续向左探查
        list.add(node);//输出节点值
        if (node.right != null) middleOrder(node.right);//如果右节点不为空,则继续向右探查
    }

    public static void main(String[] args) {
        NodeS node1 = new NodeS(4);
//        NodeS node2 = new NodeS(2);
//        NodeS node3 = new NodeS(5);
//        NodeS node4 = new NodeS(1);
//        NodeS node5 = new NodeS(3);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
        BSTreeAndLinkedList temp = new BSTreeAndLinkedList();
        System.out.println(temp.treeToDoublyList(node1).val);
    }

}
