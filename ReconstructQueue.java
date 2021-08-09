// Time Complexity : O(n ^ 2)
// Space Complexity : O(n)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null)
            return new int[0][0];
        List<int[]> li = new ArrayList<>();
        Arrays.sort(people, (a, b) -> {
                    if(b[0] == a[0])
                        return a[1] - b[1];
                    else
                        return b[0] - a[0];
        });
        for(int[] person : people){
            li.add(person[1], person);
        }
        return li.toArray(new int[0][]);
    }
}