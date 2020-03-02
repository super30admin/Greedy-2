TC: O(n)
SC: O(n)

Runtime: 8 ms, faster than 38.56% of Java online submissions for Queue Reconstruction by Height.


class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        List<int[]> output = new LinkedList<int[]>();
        for(int[] person: people){  // inserting based on k=> O(n^2)
            output.add(person[1],person);
        }
        return output.toArray(new int[0][]) ;// 
    }
}
