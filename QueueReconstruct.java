/*
this is a greedy problem.We sort the given people's array by:
i) decreasing order of height.
ii) if height is equal, then compare the number of people infront of them

After sorting with above conudtions, insert one by one in list at p[1] index/

return the list/

TC: O(n^2)


*/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        //first sort according to the height in descending order, if ht is equal then sort accoring to k
        Arrays.sort(people, (a,b) ->{
            if(a[0] == b[0]){
                       return a[1]-b[1];
                   }
                    return b[0]-a[0];
        });
         
        List<int[]> list = new ArrayList<>();
        for(int[]p : people){
            int index = p[1];
            list.add(index,p);
        }
                   
        return list.toArray(new int[0][]);
    }
}