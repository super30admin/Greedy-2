// Time Complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            // if height is same, then ascending order of height
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            //descreasing order
            return b[0] - a[0];
        });

	 System.out.println(Arrays.deepToString(people));
        List<int[]> result = new ArrayList<>();
        for(int[] p : people) {
            result.add(p[1], p);
        }

        return result.toArray(new int[0][0]);

        
    }
}

