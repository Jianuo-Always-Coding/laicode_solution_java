# Strstr

字符串中子字符串的查找，如果字符串source中含有target的子字符串，返回开始的index，否则返回1

## Solution1
https://www.lintcode.com/problem/13/
使用双层for循环，遍历所有可能，暴力求解。

## Solution2
Robin-Karp, 使用类似求hashcode的方法来判断两个字符串是否相等。需要一边对power乘因子一边取模防止越界。
```java
public int final BASE = 1000000;
power = (power * 31) % BASE; b                                          
```