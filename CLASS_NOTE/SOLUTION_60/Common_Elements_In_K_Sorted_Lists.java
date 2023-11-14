public class Solution {
    public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (input.size() <= 1) {
            return result;
        }
        result = helper(input.get(0), input.get(1));
        for (int i = 2; i < input.size(); i++) {
            result = helper(result, input.get(i));
        }
        return result;
    }

    private List<Integer> helper(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < l1.size() && index2 < l2.size()) {
            int val1 = l1.get(index1);
            int val2 = l2.get(index2);
            if (val1 == val2) {
                result.add(val1);
                index1++;
                index2++;
            } else if (val1 < val2) {
                index1++;
            } else {
                index2++;
            }
        }
        return result;
    }

}

// TC : O(nk)
// SC : O(n)
