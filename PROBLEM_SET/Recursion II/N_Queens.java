package Recursion II;

public class Solution {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> layer = new ArrayList<>();
    helper(result, layer, n, 0);
    return result;
  }

  private void helper(List<List<Integer>> result, List<Integer> layer, int n, int index) {
    // base case
    if (index == n) {
      result.add(new ArrayList(layer));
      return ;
    }
    for (int i = 0; i < n ;i++) {
      if (valid(layer, i)) {
        layer.add(i);
        helper(result, layer, n, index+1);
        layer.remove(layer.size() - 1);
      }
    }
  }

  private boolean valid(List<Integer> layer, int col) {
    for (int i = 0; i < layer.size(); i++) {
      if (col == layer.get(i)) {
        return false;
      }
      if (Math.abs(i - layer.size()) == Math.abs(layer.get(i) - col)) {
        return false;
      }
    }
    return true;
  }
}


 // TC : O(n!)
 // SC : O(n)