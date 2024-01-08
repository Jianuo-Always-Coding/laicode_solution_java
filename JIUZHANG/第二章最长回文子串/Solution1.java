public class Solution1 {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */

     
    public String longestPalindrome(String s) {
        // Method 1 : 中心开花
        // corner case
        if (s == null || s.length() == 0) {
            return "";
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String oddStr = getLongest(s, i, i);
            if(oddStr.length() > result.length()) {
                result = oddStr;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            String evenStr = getLongest(s, i, i + 1);
            if(evenStr.length() > result.length()) {
                result = evenStr;
            }
        }
        return result;
    }

    private String getLongest(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}