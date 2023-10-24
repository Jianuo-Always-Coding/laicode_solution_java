package String II;

public class Solution {
  public List<Integer> allAnagrams(String sh, String lo) {
    // Write your solution here
    // corner case
    List<Integer> result = new ArrayList<>();
    // corner case
    if (lo.length() < sh.length()) {
      return result;
    }
    Map<Character, Integer> map = new HashMap<>();
    int matched = 0;
    for (int i = 0; i < sh.length(); i++) {
      char cur = sh.charAt(i);
      if (map.containsKey(cur)) {
        map.put(cur, map.get(cur) + 1);
      } else {
        map.put(cur, 1);
      }
    }

    for (int i = 0; i < sh.length(); i++) {
      char cur = lo.charAt(i);
      if (map.containsKey(cur)) {
        map.put(cur, map.get(cur) - 1);
        if (map.get(cur) == 0) {
          matched++;
        }
      }
    }
    
    if (matched == map.size()) {
      result.add(0);
    }

    int start = 0;
    int end = sh.length();

    while (end < lo.length()) {
      // remove start
      char startEle = lo.charAt(start);
      if (map.containsKey(startEle)) {
        map.put(startEle, map.get(startEle) + 1);
        if (map.get(startEle) == 1) {
          matched--;
        }
      }
      start++;

      // add end
      char endEle = lo.charAt(end);
      if (map.containsKey(endEle)) {
        map.put(endEle, map.get(endEle) - 1);
        if (map.get(endEle) == 0) {
          matched++;
        }
      }
      end++;

      // jugde if add to result
      if (matched == map.size()) {
        result.add(start);
      }
    }

    return result;
  }
}

// TC : O(l) # l is the length of long string
// SC : O(s) # s is the length of short string