// Time Complexity - O(n^2)
// Space Complexity - O(1)
// Approach
// Sort the list in descending order of height so that taller people come first.
// If the ht of persons are same, sort in ascending based on k value. After sorting,
// put pairs in its relevant index that wont disturn the queue because a smaller height hardly 
// affects the already sorted height.
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(people, (a,b) -> {
                   if(a[0] == b[0]) {
                       return a[1]-b[1];
                   } else {
                       return b[0]-a[0];
                   }
        });
        for(int[] person:people) {
            res.add(person[1],person);
        }
        return res.toArray(new int[0][]);
    }
}