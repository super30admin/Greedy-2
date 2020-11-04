class Solution {
    // TC:  O(N^2)  -->  nlogn for sorting, and for inserting at k position, k remaining elements forward => n * nlogn = n^2
    // SC:  O(N)
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
        
        // Descending order based heights, if matches then ascending k value
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0] );
        
        List<int[]> output = new ArrayList<>();
        
        for(int[] person : people){
            output.add(person[1], person);
        }
        
        int n = output.size();  // for integer array for returning
        return output.toArray(new int[n][2]);
    }
}