package Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //从小到大排序，跳过重复项
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(res, new ArrayList<>(), nums, visited, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited, int n) {

        if(n == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == true) continue;
            if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) continue;
            //选择当前值
            visited[i] = true;
            list.add(nums[i]);
            //递归
            backtrack(res, list, nums, visited, n + 1);
            //撤销选择
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
