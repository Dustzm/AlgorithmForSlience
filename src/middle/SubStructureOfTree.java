package middle;

import pojo.NodeS;
import pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的子结构
 * @author Slience
 * @date 2022/8/9 17:03
 **/
public class SubStructureOfTree {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private Boolean dfs(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }

}
