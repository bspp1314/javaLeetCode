package leetCode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
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
            if (candidates[i] > target) {
                return;
            }
            if (i > begin && candidates[i] == candidates[i-1]){
                continue;
            }
            List<Integer> tem = new ArrayList<Integer>(subList);
            tem.add(candidates[i]);



            dfs(res,candidates,tem,i,target-candidates[i]);
        }
    }

    public static void main(String[] args) {

    }

}
