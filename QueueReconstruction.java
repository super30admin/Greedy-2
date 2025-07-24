// TC: O(n log n)
// SC: O(1)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        for (int[] person : people) {
            result.add(person[1], person);
        }

        return result.toArray(new int[0][]);
    }
}