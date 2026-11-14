class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, curr, new boolean[nums.length], res);
        return res; 
    }

    private void dfs(int[] nums, List<Integer> curr, boolean[] pick, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr)); 
            return; 
        }
        for (int i = 0; i < nums.length; i ++) {
            if (!pick[i]) {
                curr.add(nums[i]);
                pick[i] = true; 
                dfs(nums, curr, pick, res);
                curr.remove(curr.size() - 1);
                pick[i] = false;
            }
        }
    }
}
