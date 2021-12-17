class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            else return b[0] - a[0];
        });
        
        List<int []> q = new ArrayList<>();
        
        for(int [] person: people){ 
            q.add(person[1], person);
        }
        
        return q.toArray(new int[0][]);
            
        
    }
}

//TC: O(n*2)
//SC: O(n)
