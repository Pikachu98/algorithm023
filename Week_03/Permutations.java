package Week3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        boolean[] used = new boolean[nums.length];
        int len = nums.length;

        Deque<Integer> path = new ArrayDeque<>(len);

        if (len == 0)
            return res;

        int depth = 0;
        dfs(nums, path, used, depth, len, res);

        return res;
    }
    public void dfs(int[] nums, Deque<Integer> path, boolean[] used, int depth, int len, List<List<Integer>> res){
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, path, used, depth+1, len, res);

                used[i] = false;
                path.removeLast();
            }
        }

    }
}
