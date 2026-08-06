class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder compare = new StringBuilder(); 
        for (char letter : s.toCharArray()) {
            if (Character.isLetterOrDigit(letter)) {
                compare.append(Character.toLowerCase(letter));
            }
        }
        return compare.toString().equals(compare.reverse().toString());
    }
}
