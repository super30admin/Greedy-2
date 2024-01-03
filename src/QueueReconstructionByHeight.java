// Time Complexity:  O(n^2)
// Space Complexity: O(n)

class Solution {
    
    public int[][] reconstructQueue(int[][] people) {
        
        int n = people.length;
        List<int[]> list = new ArrayList<>();

        // Sort in order with decreasing height and increasing count
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0])
                return a[1]-b[1];
            return b[0]-a[0];
        });

        // add int[] into list at index of its count so that condition satisfies
        for(int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[n][2]);

    }

}
