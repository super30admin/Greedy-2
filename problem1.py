#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

from ast import List
from collections import Counter, deque
import heapq


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = Counter(tasks)
        max_heap = [-c for c in count.values()]
        heapq.heapify(max_heap)

        time = 0
        q = deque()

        while max_heap or q:
            time += 1

            if max_heap:
                c = 1 + heapq.heappop(max_heap)
                if c:
                    q.append([c, time+n])
            
            if q and q[0][1] == time:
                heapq.heappush(max_heap, q.popleft()[0])
        
        return time
        