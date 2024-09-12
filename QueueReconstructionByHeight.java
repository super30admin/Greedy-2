//TC: O(n^2)
//SC: O(n)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList();
        Arrays.sort(people, (a,b) ->{
            if(a[0] == b[0]) return a[1]-b[1];
            return b[0]-a[0];
        });
        for(int i = 0; i < people.length; i++){
            int[] person = people[i];
            res.add(person[1], person);
        }
        return res.toArray(new int[0][]);
    }
}
