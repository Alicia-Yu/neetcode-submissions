class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> s = new ArrayList<>();
        s.add(new ArrayList<>()); 
        for (int num : nums) {
            int size = s.size();
            for (int i = 0; i < size; i ++) {
                List<Integer> subset = new ArrayList<>(s.get(i)); 
                subset.add(num); 
                s.add(subset); 
            }
        }
        return s; 
    }   
}
