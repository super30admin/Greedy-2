//Problem 140: Queue Reconstruction by Height
// Time Complexity :O(nlogn+ n^2)=>O(n^2)
// Space Complexity :O(n)

// Your code here along with comments explaining your approach
//Bruteforce : Make different pairs and then check accordingly
/*Optimized : Greedy 
  Algo: Sort the array based on the heights (decreasing order) and if the heights are same sort it based on the ascending order of the number of people of greater heights visible to them
         [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
        -> then traverse for each element and place the element based on their element[1] value in the list ex: [7,0] will be placed in 0th position and [7,1] in 1st position and [6,1] also in 1st pos which will shift the other element by 1
        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 
        Time: O(n^2) as adding the values at fixed location requires n and traversing the given array takes n
*/

import java.util.*;
class Solution140 {
    public int[][] reconstructQueue(int[][] people) {
        //TC:O(nlogn+N^2), N^2 because iterating over people array and then inserting it in a specific index, will shift the array. However linkedlist would be better than the array list over here.
        if(people==null || people.length==0) return new int[0][];
        
        //Sort the array 
        //schedule tallest first->desending order of heights and ascending for number of people in front of me
        Arrays.sort(people,(a,b)->{
            
            if(a[0]==b[0]){
                return a[1] - b[1];//schedule in ascending order and on the basis of number of people standing in front of me
            }
            
            return b[0] - a[0];//descending order i.e on the basis of height
        });
        
        List<int[]> list = new LinkedList<>();
        
        for(int[] p:people){//O(n)
            list.add(p[1],p);//O(n)
        }
        
        return list.toArray(new int[0][]);
    }
}