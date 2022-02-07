package com.wrongme.daily.other;

import com.wrongme.basic.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalTraversalSolution {
    //int[]  col row val
    Map<TreeNode, int[]> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map.put(root, new int[]{0, 0, root.val});
        dfs(root);
        List<int[]> list = new ArrayList<>(map.values());
        list.sort((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int n = list.size();
        for (int i = 0; i < n; ) {
            int j = i;
            List<Integer> temp = new ArrayList<>();
            while (j<n&&list.get(j)[0]==list.get(i)[0]){
                temp.add(list.get(j++)[2]);
            }
            ans.add(temp);
            i=j;
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int[] info = map.get(root);
        int col = info[0];
        int row = info[1];
        if (root.left != null) {
            map.put(root.left, new int[]{col - 1, row + 1, root.left.val});
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, new int[]{col + 1, row + 1, root.right.val});
            dfs(root.right);
        }
    }
}
