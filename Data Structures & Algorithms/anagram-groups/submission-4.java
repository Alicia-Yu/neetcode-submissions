class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>(); 
        for (int i = 0; i < strs.length; i ++) {
            String word = strs[i].toLowerCase(); 
            char[] letters = word.toCharArray();
            Arrays.sort(letters); 
            String sorted = new String(letters); 
            groups.putIfAbsent(sorted, new ArrayList<>());
            groups.get(sorted).add(strs[i]);
        }
        return new ArrayList<>(groups.values()); 
    }
}
