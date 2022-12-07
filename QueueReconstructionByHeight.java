// Time complexity: O(N*N)
// Space complexity: O(N)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length ==0) return people;

        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();

        for (int [] person: people) {
            result.add(person[1], person);
        }

        return result.toArray(new int[0][0]);
    }
}