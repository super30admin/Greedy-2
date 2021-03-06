class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
           if(a[0] == b[0]){
               return a[1] - b[1];
           }
            return b[0] - a[0];
        });
        List<int[]> q = new ArrayList<>();
        for(int[] item : people){
            q.add(item[1],item);
        }
        return q.toArray(new int[0][]);
    }
}
// Time Complexity: O(n2)
// Space complexity: O(n)

