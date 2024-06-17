package Greedy-2;
// TC: O(n^2)
// SC: O(n)
public class Problem2 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        List<int[]> result = new ArrayList<>();
        for(int[] el: people){
            result.add(el[1], el);
        }

        return result.toArray((new int[0][]));
    }
}
