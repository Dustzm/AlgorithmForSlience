package easy;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 用两个栈实现队列
 * @author Slience
 * @date 2022/5/20 14:33
 **/
public class CQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        if(s2.empty()){
            return -1;
        }
        int res = s2.pop();
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        return res;
    }
}
