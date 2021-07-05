class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        if(people==null || people.length==0){
            return new int[0][0];
        }
        
        Comparator<int[]> comparator=new Comparator<>(){
            
            public int compare(int[] a,int [] b){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }else{
                    return b[0]-a[0];
                }
            }
        };
        
        
        Arrays.sort(people,comparator);
        
        List<int[]> result=new LinkedList<>();
        
        for(int[] i:people){
            result.add(i[1],i);
        }
        
        return result.toArray(new int[0][2]);
    }
}