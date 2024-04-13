
    // TC=O(n*n)
    // SC=O(n)
    class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) ->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
             return b[0]-a[0];
        });
        List<int []> q = new ArrayList<>();
        for( int [] person: people){
            q.add(person[1], person);
        }
        int [][] r = new int [people.length][2];
        for(int i=0; i< people.length; i++){
            r[i] = q.get(i);
        }
        return r;
    }
}