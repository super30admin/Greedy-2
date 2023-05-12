# Time Complexity : O(N log N), where N is the length of the tasks array
# Space Complexity : O(N), where N is the length of the tasks array.
import heapq
from collections import defaultdict
from typing import List

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = defaultdict(int)
        for task in tasks:
            freq[task] += 1
        
        max_heap = []
        for task, count in freq.items():
            heapq.heappush(max_heap, (-count, task))
        
        time = 0
        while max_heap:
            i = 0
            temp = []
            while i <= n:
                if max_heap:
                    count, task = heapq.heappop(max_heap)
                    if count < -1:
                        temp.append((count+1, task))
                time += 1
                if not max_heap and not temp:
                    break
                i += 1
            
            for item in temp:
                heapq.heappush(max_heap, item)
        
        return time