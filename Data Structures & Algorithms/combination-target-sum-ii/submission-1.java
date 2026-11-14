class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates); 
        dfs(0, new ArrayList<>(), 0, candidates, target, res);
        return res; 
    }

    private void dfs(int index, List<Integer> path, int cur, int[] candidates, int target, List<List<Integer>> res) {
        if (cur == target) {
            res.add(new ArrayList<>(path)); 
            return; 
        } 
        for (int i = index; i < candidates.length; i ++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue; 
            }
            if (cur + candidates[i] > target) {
                break; 
            }
            path.add(candidates[i]);
            dfs(i + 1, path, cur + candidates[i], candidates, target, res);
            path.remove(path.size()-1); 
        }       
    }
}
