public class Solution2 {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        // corner case
        if (s == null || s.length() == 0) {
            return "";
        }

        // Method 2 使用动态规划二维数组记录
        int start = 0;
        int longest = 1;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                start = i;
                longest = 2;
            }
        }

        for (int i = s.length() - 1; i >=0; i--) {
            for (int j = s.length() - 1; j >i; j--) {
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i+1][j-1]) {
                    isPalindrome[i][j] = true;
                    if (j - i + 1 > longest) {
                        longest = j - i + 1;
                        start = i;
                    }
                } 
            }
        }

        return s.substring(start,start + longest);
    }
}