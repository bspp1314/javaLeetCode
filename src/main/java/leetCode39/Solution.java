package leetCode39;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;

        // 排序是为了提前终止搜索
        Arrays.sort(candidates);

        List<Integer> tem = new ArrayList<Integer>();
        dfs(res, candidates,tem,0,target);
        return res;


    }

    public static void dfs( List<List<Integer>> res,int[] candidates,List<Integer> subList,int begin,int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(subList));
            return;
        }

        for (int i = begin;i < candidates.length;i++){
            List<Integer> tem = new ArrayList<Integer>(subList);
            tem.add(candidates[i]);

            dfs(res,candidates,tem,i,target-candidates[i]);
        }
    }


}
