public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int m = l + ((r - l) / 2);
            if (nums[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (l > 0 && nums[l - 1] == target) {
            return l - 1; 
        } 
        return -1;
    }
}