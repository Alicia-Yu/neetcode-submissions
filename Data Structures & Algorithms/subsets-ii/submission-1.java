class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums); 
        List<Integer> subset = new ArrayList<>(); 
        dfs(0, subset, nums, res);
        return res;
    }

    private void dfs(int index, List<Integer> sub, int[] nums, List<List<Integer>> res) {
        res.add(new ArrayList<>(sub)); 
        for (int j = index; j < nums.length; j ++) {
            if (j > index && nums[j] == nums[j-1]) {
                continue;
            }
            sub.add(nums[j]);
            dfs(j + 1, sub, nums, res);
            sub.remove(sub.size() - 1); 

        }
    }
}
