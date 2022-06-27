package pojo;

public class NodeS {
    public int val;
    public NodeS left;
    public NodeS right;

    public NodeS() {}

    public NodeS(int _val) {
        val = _val;
    }

    public NodeS(int _val,NodeS _left,NodeS _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
