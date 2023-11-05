1. 如何在一个String中找出最长的回文（palindrome）子串？
> - 分奇偶中心开花。
> - 动态规划：
> 1. isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j); 并将maxLength = 1;
> 2. 设置isPalindrome[i][i+1], 如果存在maxLength = 2；
> 3. i = n - 1; j = i + 2, 从后往前填表