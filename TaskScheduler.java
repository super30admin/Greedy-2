package greedy2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
	//Time Complexity : O(m log m * n), where m is the length of tasks and n is n
	//Space Complexity : O(m), for maxHeap and HashMap
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int leastInterval(char[] tasks, int n) {
        // null
        if(tasks == null || tasks.length == 0)
            return 0;
        if(n == 0)
            return tasks.length;
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c: tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(map.values());
        int result = 0;
        
        while(!maxHeap.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int time = 0;
            for(int i=0; i<=n; i++) {
                if(!maxHeap.isEmpty()) {
                    list.add(maxHeap.poll() - 1);
                    time++;
                }
            }
            
            for(int i: list) {
                if(i > 0)
                    maxHeap.add(i);
            }
            
            result += maxHeap.isEmpty() ? time : n + 1;
        }
        
        return result;
    }
}
