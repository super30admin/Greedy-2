
// time - O(N^2)
// space - O(N)




class Solution {
    public int[][] reconstructQueue(int[][] people) {

        if(people == null) return new int[0][0];
        List<int []> result = new ArrayList<>();
        Arrays.sort(people,(a,b) -> {

            if(a[0] == b[0]) { // if heights are equal
                return a[1] - b[1]; // sort ascending based on no of people ahead
            }
            return b[0] - a[0]; // sort in descending order of height
        });

        for(int [] person:  people)  {
            result.add(person[1],person); // this will add based on the index value at 1st position
        }

        return result.toArray(new int[0][0]);

    }
}