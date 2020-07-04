// Time Complexity : O(n^2) where n is the number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Comparator design on the logic
/* Your code here along with comments explaining your approach: Sort the list in descending order of height so that the taller people are coming first.
If the height of the persons are same, sort in ascending based on the k value so that k number of people are correctly ordered. After sorting,
put the pairs in its relevant index that won't distrubing the queue because a smaller height hardly affects the already sorted height. This is
ensuring that the people are correctly standing in the queue based on their k value.
*/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(people, (a,b) ->{
            if(a[0] == b[0]){                                                       // If the heights are equal
                return a[1] - b[1];                                                     // Put the k value first (smaller)
            } else {
                return b[0]-a[0];                                                       // Else put the higher height first
            }});
        for(int[] person : people){
            result.add(person[1], person);                                      // Put the pairs in their respective indices as they dont affect the height order
        }
        return result.toArray(new int[0][]);
    }
}