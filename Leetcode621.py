    # Time = O(n)
    # Space = O(n) 
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = Counter(tasks)
        maxHeap = [-cnt for cnt in count.values()]
        heapq.heapify(maxHeap)

        time = 0
        cooldown = {}

        while maxHeap or cooldown:
            time += 1
            
            if maxHeap:
                cnt = 1 + heapq.heappop(maxHeap)
                if cnt:
                    cooldown[time + n] = cnt
            
            if time in cooldown:
                heapq.heappush(maxHeap, cooldown.pop(time))
        
        return time