class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] allMax = new int[n-k + 1]; 
        Deque<Integer> q = new LinkedList<>(); //stores indices
        int l = 0;
        int r = 0;
        while (r < n) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast(); 
            }
            q.addLast(r); 
            if (l > q.getFirst()) {
                q.removeFirst();
            }
            if ((r + 1) >= k) {
                allMax[l] = nums[q.getFirst()];
                l ++; 
            }
            r++; 
        }
        return allMax; 

    }
}
