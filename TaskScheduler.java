import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

// Time Complexity :O(n)
// Space Complexity :O(nlogn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class TaskScheduler {

    class Solution {
        public int leastInterval(char[] tasks, int n) {

            //create hashmap and store count of characters in tasks
            HashMap<Character, Integer> map = new HashMap<>();
            for(char c:tasks){
                map.put(c, map.getOrDefault(c,0)+1);
            }

            //create maxheap and add values from map
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
            maxHeap.addAll(map.values());

            //process cycles
            int cycles=0;
            while(!maxHeap.isEmpty()){
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < n+1; i++) {
                    if(!maxHeap.isEmpty()){
                        list.add(maxHeap.remove());
                    }
                }
                for(int l:list){
                    if(--l > 0){
                        maxHeap.add(l);
                    }
                }
                cycles+=maxHeap.isEmpty() ? list.size() : n+1;
            }
            return cycles;//return result
        }
    }


}
