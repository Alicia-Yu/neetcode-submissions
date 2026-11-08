class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        int max = Arrays.stream(count).max().getAsInt(); 
        int maxCount = 0;
        for (int i : count) {
            if (i == max) {
                maxCount ++; 
            }
        }

        int time = (max - 1) * (n+1) + maxCount; //max-1 is number of full rows, 
                                                 //n+1 is size per full row 
                                                 //maxCount is last segment 
        return Math.max(tasks.length, time); 



    }
}
