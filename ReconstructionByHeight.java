class Solution {

    // Time Complexity : 0(nlogn) + 0(n^2) where  is the no. of elements in the array. nlogn is for sorting and n^2 is for rearranging the descending array in result list as per their indices
// Space Complexity : 0(1) we don't conside space for hashmap because in any case it will hold only 26 alphabets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0){
            return new int[][]{};
        }
        Arrays.sort(people, (a, b) ->{
            if(a[0] == b[0]){   //if heights are same, then ascending in no. of people
                return a[1] - b[1];
            }
            return b[0] - a[0]; //else, descending order or heights
        });
        List<int []> result = new ArrayList<>();    //to store the result
        for(int[] person : people){ //going over descending array based on height
            result.add(person[1], person);  //adding each person based on their index
        }
        return result.toArray(new int [0][]);   //conveting into array and returning
    }
}
