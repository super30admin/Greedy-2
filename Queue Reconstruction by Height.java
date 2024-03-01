// Time Complexity : O(n^2)
// Space Complexity : O(n) bcoz we created an array list for our purpose and returned back a 2d array
// Method used : Greedy

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        if(people == null || people.length == 0) return people;

        Arrays.sort(people, (a, b) -> {

            // This means that both heights are same, in this case arrange the elements according to minimum people in front of it
            if(a[0] == b[0]) return a[1] - b[1];

            // If both the heights are different then choose the maximum height to be in the front
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList();

        // Traverse the array once again to put the pair at it's right position
        for(int[] pair : people)
        {
            // For example if we have a pair [4,2] this means that we can have only 2 people in front of me with height >= 4
            // As we should have only 2 people place this place at 2nd index, so that if follows the property
            result.add(pair[1], pair);
        }

        return result.toArray(new int[0][]);
    }
}