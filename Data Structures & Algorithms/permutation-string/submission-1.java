class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Count = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) +1); 
        }
        Map<Character, Integer> s2Count = new HashMap<>();
        for (int i = 0; i < s1.length(); i ++) {
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) +1); 
        }
        if (s1Count.equals(s2Count)) {
            return true; 
        }
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r ++) {
            s2Count.put(s2.charAt(r), s2Count.getOrDefault(s2.charAt(r), 0) + 1);
            s2Count.put(s2.charAt(l), s2Count.getOrDefault(s2.charAt(l), 0) -1);
            if (s2Count.get(s2.charAt(l)) == 0) {
                s2Count.remove(s2.charAt(l));
            }
            l ++; 
            if (s1Count.equals(s2Count)) {
                return true; 
            }
        }
        return false; 
    }
}
