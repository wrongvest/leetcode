package com.wrongme.daily.w20220308;

import java.util.ArrayList;
import java.util.List;

public class Saturday {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root==null){
            return ans;
        }

        if (root.children!=null){
            for (Node child : root.children) {
                postorder(child);
            }
        }
        ans.add(root.val);
        return ans;
    }

}

