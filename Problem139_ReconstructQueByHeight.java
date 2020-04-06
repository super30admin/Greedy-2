//Time Complexity: O(n log(n) + n) -> sorting + arranging

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //base case
        if(people == null || people.length == 0){
            return new int[0][0];
        }
        //initially sort the people array according to index 0, if same
        //using index 1 of people
        Arrays.sort(people, (a,b) -> a[0] == b[0]? a[1] - b[1] : b[0] - a[0]);
        //create queue of integer type
        List<int []> result = new ArrayList<>();
        //add ppl according to k values(array index)
        //in people array
        for(int [] ppl : people){
            result.add(ppl[1], ppl);
        }
        //convert list to array
        return result.toArray(new int [0][]);
    }
}