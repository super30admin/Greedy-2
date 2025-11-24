# Time Complexity : O(N) where N is the length of the input list
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a greedy approach with a max heap to schedule tasks with cooling period.
# I first count the frequency of each task and push them into a max heap.
# Then, I use a queue to keep track of tasks that are in the cooling period.
# At each time unit, I pop the most frequent task from the heap and execute it.
# If the task still has remaining count, I add it to the queue with the time when it can be executed again.
# If the heap is empty but there are tasks in the queue, I fast forward the time to the next available task.
# Finally, I return the total time taken to execute all tasks.

from typing import List
from collections import deque,Counter
import heapq
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = Counter(tasks)
        heap = []
        for val,count in freq.items():
            heapq.heappush(heap,(-count,val))
        q = deque()
        time = 0
        while heap or q:
            while q and q[0][2] <= time:
                ts,cnt,_r = q.popleft()
                heapq.heappush(heap,(-cnt,ts))
            if heap:
                ncnt,task = heapq.heappop(heap)
                cnt = -ncnt - 1
                if cnt > 0:
                    q.append((task, cnt, time + n + 1))
                time+= 1
            else:
                time = q[0][2]
        return time




