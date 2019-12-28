/*

Did it run on leetcode : Yes


Time complexity: 0(NlogN+N2) (sort + add)
Space complexity: 0(N)

Algorithm:
Insertion Sort
- Sort the elements based on decreasing heights.
- Insert the elements in the queue by using `k` value as their index.


*/


import java.util.*; 
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        ArrayList<int[]> queue = new ArrayList<>();
        Arrays.sort(people,new Comparator<int[]>(){
            @Override              
          public int compare(final int[] person1,  
                             final int[] person2) { 
  
            if (person1[0] > person2[0]) {return -1;}
            else if(person1[0]==person2[0]){
                if(person1[1]<person2[1]){
                    return -1;
                }else{
                    return 1;
                }
            }
            else {return 1;} 
          } 
        });
        
 
        for(int[] person: people){
            queue.add(person[1],person);
        }
        
        int idx=0;
        int[][] result = new int[people.length][2];
        for(int[] person: queue){
            result[idx][0] = person[0];
            result[idx][1] = person[1];
            idx++;
        }
        
        return result;
        
    }
}
