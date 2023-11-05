package HashTable_and_String_I;

public class Solution {
    public List<Integer> common(int[] A, int[] B) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return result;
        }
        int first = 0;
        int second = 0;

        while (first < A.length && second < B.length) {
            if (A[first] == B[second]) {
                result.add(A[first]);
                first++;
                second++;
            } else if (A[first] < B[second]) {
                first++;
            } else {
                second++;
            }
        }
        return result;
    }
}
// TC : O(m + n)
// SC : O(1)
