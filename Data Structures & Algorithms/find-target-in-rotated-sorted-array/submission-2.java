class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int middle = (l + r) / 2;
            if ((nums[middle] > nums[r])) {
                l = middle + 1;
            } else {
                r = middle; 
            }
        }
        int pivot = l;
        if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, target, pivot, nums.length - 1); 
        } else {
            return binarySearch(nums, target, 0, pivot - 1); 
        }
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int middle = (left + right)/2;
            if (target == nums[middle]) {
                return middle; 
            } else if (target < nums[middle]) {
                right = middle - 1; 
            } else {
                left = middle + 1; 
            }
        }
        return - 1;
    }
}
