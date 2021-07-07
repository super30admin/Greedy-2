// Time Complexity : O(n log n) for custom sorting
// Space Complexity : O(n) For storing the array in intermediate linkedList
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0)
            return new int[0][0];
        
        // Input --> [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        // Step 1 --> Sort the input based on Hight(First index in given input of each array). If two hights are same the order based on no of ppl in front.
        //      Custome comparator performs this --> IF height is SAME then ASC order with second index value
        //                                           IF height is DIFFERENT we have to order DESC based on height
        //    Result of step 1 -->[7,0], [7,1], [6,1],[5,0],[5,2],[4,4]
        // Create a linked list and INSERT these element at the index of '1'.
        // Output --> [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
        
        Comparator<int[]> customCompare = new Comparator<>(){
            @Override
            public int compare(int[] h, int[] k){
                if(h[0] == k[0])
                    return h[1]-k[1];
                else
                    return k[0]-h[0];
            }
        };
        
        Arrays.sort(people, customCompare);
        
        List<int[]> result = new LinkedList<>();
        
        for(int[] person: people){
            result.add(person[1],person);
        }
        return result.toArray(new int[0][2]);
    }
}
