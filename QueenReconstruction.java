//Time Complexity : O(nlogn)
//Space Compleixty :O(1)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people,new Comparator<int[]>(){

            public int compare(int[] people1,int[] people2){
                
                int p1 = people1[0];
                int p2 = people2[0];
                if(p1 == p2){
                    return people1[1]-people2[1];
                }
                
                return people2[0] -people1[0];
            }
            
        });

        
        List<int[]> output = new ArrayList<>();
                int n = people.length;
        for(int[] p : people){
            output.add(p[1],p);
        }
        return output.toArray(new int[n][2]);
    }
}
