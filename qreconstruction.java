// Time Complexity: O(n^2) — sort O(n log n) plus n indexed insertions into an ArrayList (worst-case O(n) each).
// Space Complexity: O(n) — list to build the queue (excluding the returned array); plus O(1)/O(log n) auxiliary for sorting.

// Sort people by height descending, and for equal heights by k ascending.
// Scan the sorted list and insert each person at index k in a dynamic list (taller folks already placed keep counts correct).
// Convert the list to a 2D array and return.

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->{
            
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();

        for(int[] p : people){
            result.add(p[1], p);
        }

        return result.toArray(new int[0][0]);
    }
}
