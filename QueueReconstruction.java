//time o(n pow 2)
//space o(n)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0)
            return people;
        //sort the people array in descending order
        Arrays.sort(people, (a,b) -> {
           if(a[0] == b[0])
               return a[1] - b[1];
            else {
                return b[0] - a[0];
            }
        });
        
        
        //insert based on 2nd value in each array as an index
        List<int[]> res = new ArrayList<>();
        //o(n pow 2)
        for(int[] p:people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[0][]);
    }
}