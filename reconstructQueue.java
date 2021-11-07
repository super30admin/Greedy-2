// Time complexity: O(n^2) 
// Space: O(n)
// Sort all people greedily according to decresing height as they wont be affected if another
// person comes in front or back of them, and then if multiple people have same  height
// sort according to importance.
// For each person in people array we are traversing whole list to place
// person in correct position.
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> li = new ArrayList<>();
        Arrays.sort(people, (a,b) -> {
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        for(int i = 0; i<people.length; i++) {
            int[] person = people[i];
            li.add(person[1], person);
        }
        return li.toArray(new int[0][]);
    }
}