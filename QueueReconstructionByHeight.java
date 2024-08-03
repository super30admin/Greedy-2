class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) {
            return new int [][] {};
        }
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0]; // in descending order
        });
        List<int[]> q = new ArrayList<>();
        for(int[] person: people) {
            q.add(person[1], person);
        }
        return q.toArray(new int[][] {});
    }
}
