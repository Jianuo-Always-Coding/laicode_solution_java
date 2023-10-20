public class Solution {
    public List<List<Integer>> combinations(int target, int[] coins) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> layer = new ArrayList<>();
  
      helper(target, 0, coins, result, layer);
      return result;
    }
  
    private void helper(int moneyLeft, int index, int[] coins, List<List<Integer>> result, List<Integer> layer) {
      // base case
      if (index == coins.length - 1) {
        if (moneyLeft % coins[index] == 0) {
          layer.add(moneyLeft / coins[index]);
          result.add(new ArrayList<Integer>(layer));
          layer.remove(layer.size() - 1);
        }
        return ;
      }
  
      int max = moneyLeft / coins[index];
      for (int i = 0; i <= max; i++) {
        layer.add(i);
        helper(moneyLeft - i * coins[index], index + 1, coins, result, layer);
        layer.remove(layer.size() - 1);
      }
    }
}
  
  // TC : O(target ^ n)
  // SC : O(n)