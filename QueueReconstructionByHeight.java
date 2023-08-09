class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) ->{
            if(a[0]==b[0]){
                return a[1] - b[1]; //sort second element ascending way
            }
            return b[0]-a[0]; //sort first element descending way
        });
        List<int []> li = new ArrayList<>();
        for(int[] person: people){
            li.add(person[1],person); //add each element looking at the second element
        }
        int[][] result = new int[people.length][2];
        for(int i=0;i<li.size();i++){
            result[i] = li.get(i);
        }
        return result;
    }
}