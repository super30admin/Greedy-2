// Time complexity - O(n^2)
// Space complexity - O(n)
// Tested in leetcode

class QueueReconstructionbyHeight {
    // Sort the given array based on decreasing height and then on the increasing on number of people in front.
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] == b[0]? a[1] - b[1]: b[0]-a[0];
            }});
        
        List<int[]> result = new ArrayList<>();
        
        //add each people in the index equal to number of people required in the front.
        for(int[] element: people){
            result.add(element[1],element);
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}