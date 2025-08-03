class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]>output = new ArrayList<>();
        //sort based on decreasing order of heights
        Arrays.sort(people , (a , b) -> {
            if(a[0] != b[0]){
                return b[0] - a[0]; //taller height first
            }
            else{
                return a[1] - b[1]; //smaller count of people(k) first
            }
        });

        //iterate over sorted array and insert people at index = k
        for(int[] person : people){
            output.add(person[1] , person) ;// output.add(index , elemeny)
        }
        
        //convert list to array
        return output.toArray(new int[people.length][2]); //2d array m*n

    }
}