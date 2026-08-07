class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return ""; 
        }
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> sCount = new HashMap<>();
        int have = 0;
        int need = tCount.size(); 
        int[] shortestCoord = {-1, -1};
        int shortest = Integer.MAX_VALUE; 
        int l = 0;
        for (int r = 0; r < s.length(); r ++) {
            char letter = s.charAt(r); 
            sCount.put(letter, sCount.getOrDefault(letter, 0) + 1);
            if (tCount.containsKey(letter) && sCount.get(letter).equals(tCount.get(letter))) {
                have ++; 
            }
            while (have == need) {
                if ((r - l + 1) < shortest) {
                    shortest = r - l + 1;
                    shortestCoord[0] = l;
                    shortestCoord[1] = r;
                }
                char left = s.charAt(l); 
                sCount.put(left, sCount.get(left) -1);
                if (tCount.containsKey(left) && sCount.get(left) < tCount.get(left)) 
                {
                    have --; 
                }
                l ++; 
            }

        }
        if (shortestCoord[0] == -1) {
            return "";
        } else {
            return s.substring(shortestCoord[0], shortestCoord[1] + 1); 
        }

    }
}
