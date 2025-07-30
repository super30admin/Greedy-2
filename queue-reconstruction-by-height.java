//Greedyly keeps scheduling the bigger height people
//time = O(n^2 + nlong)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int []> result = new ArrayList<>();
        Arrays.sort(people, (a,b) -> { //nlogn
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        for(int [] person: people){ //n^2
            result.add(person[1],person);
        }
        return result.toArray(new int[0][]);
    }
}