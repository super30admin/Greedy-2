//TC: O(n^2)
//SC: O(1)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Step 1: Sort the people array
        Arrays.sort(people, (a, b) -> {
            // Sort by height in descending order; if heights are equal, sort by k in ascending order
            if (a[0] != b[0]) {
                return b[0] - a[0];  // Compare heights
            } else {
                return a[1] - b[1];  // Compare k-values if heights are the same
            }
        });
        
        // Step 2: Insert each person into the queue at the index corresponding to their k-value
        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);  // Insert person at index `person[1]`
        }
        
        // Convert the result list back to a 2D array and return
        return result.toArray(new int[people.length][2]);
    }
}
