// Time Complexity: O(n * n) where n is the length of the array.
// Space Complexity: O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[][] {};
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) {          // Check heights.
                return a[1] - b[1];     // asc order.
            }
            return b[0] - a[0];         // desc order.
        });
        
        List<int[]> result = new ArrayList<>();
        for(int[] person: people) {
            result.add(person[1], person);    // Add at the index person[1]. Previous get pushed right.
        }
        
        return result.toArray(new int[people.length][]);    // ArrayList - > Array
    }
}