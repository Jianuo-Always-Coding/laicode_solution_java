

## String中最长回文（palindrome）子串查找
如何在一个 String 中找出最长的回文（palindrome）子串？
https://www.lintcode.com/problem/200/

### Solution 1
> 1. 分奇偶中心开花
> - n个奇数长度的回文串中心点
> - n-1个偶数长度的回文串中心点

### Solution 2
> 2. 动态规划：
> - 对于奇数(length = 1)和偶数长度(length = 2)分别做初始化
> - 记录start的index，和最长字符串的长度
> - 因为i依赖于i + 1，从后往前填表，j = i + 2;
