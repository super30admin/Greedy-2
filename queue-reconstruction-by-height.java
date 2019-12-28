/*

Did it run on leetcode : No
It failed this test case [[9,0],[7,0],[1,9],[3,0],[2,7],[5,3],[6,0],[3,4],[6,2],[5,2]]
expected:[[3,0],[6,0],[7,0],[5,2],[3,4],[5,3],[6,2],[2,7],[9,0],[1,9]]
Output:  [[3,0],[6,0],[7,0],[5,2],[3,4],[6,2],[5,3],[2,7],[9,0],[1,9]]

Time complexity: 0(NlogN+N+N)
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
