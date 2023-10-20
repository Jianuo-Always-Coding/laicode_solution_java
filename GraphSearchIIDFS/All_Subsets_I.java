public class Solution {
    public List<String> subSets(String set) {
      List<String> result = new ArrayList<>();
      if (set == null) {
        return result;
      }
      StringBuilder sb = new StringBuilder();
      findSubSet(result, sb, set, 0);
      return result;
    }
  
    private void findSubSet(List<String> result, StringBuilder sb, String set, int index) {
      // base case
      if (index == set.length()) {
        result.add(sb.toString());
        return ;
      }
  
      sb.append(set.charAt(index));
      findSubSet(result, sb, set, index + 1);
      sb.deleteCharAt(sb.length() - 1);
      findSubSet(result, sb, set, index + 1);
    }
  }
  
  // Draw recursion tree
  // TC : O(2 ^ n)
  // SC : O(n) - stringBuilder