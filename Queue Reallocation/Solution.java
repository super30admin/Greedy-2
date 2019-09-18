class Solution {
    
   
    public int[][] reconstructQueue(int[][] people) {
        // sort people by decreasing height followed by increasing k;
      Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> result = new ArrayList<>();
        // add the elements at kth index of result list
        for(int i=0;i<people.length;i++) {
            result.add(people[i][1], people[i]);
        }
        
        return result.toArray(new int[result.size()][]);
    }
}