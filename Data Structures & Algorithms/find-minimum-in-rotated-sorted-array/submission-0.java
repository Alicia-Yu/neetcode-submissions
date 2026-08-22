class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int middle = (l + r) / 2;
            if (nums[middle] > nums[r]) {
                l = middle + 1;
            } else {
                r = middle; 
            }
        }
        return nums[l]; 
    }
}
