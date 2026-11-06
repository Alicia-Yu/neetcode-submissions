class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone); 
        }
        while (maxHeap.size() > 1) {
            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();
            if (largest > secondLargest) {
                int remainder = largest - secondLargest;
                maxHeap.offer(remainder);
            }
        }
        if (maxHeap.size() == 0) {
            return 0;
        }
        return maxHeap.poll(); 

    }
}
