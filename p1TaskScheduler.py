"""
time: O(logN)
space: O(N)
"""
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        counter = Counter(tasks)
        time = 0
        
        #python doesnt have max heap so make neg nums in min heap
        #create max heap
        maxH = [-c for c in counter.values()]
        heapq.heapify(maxH)
        
        #create a queue
        q = deque()
        
        #while there is a q or a heap
        while maxH or q:
            time += 1

            #if there is a maxheap,
            if maxH:
                #keep track of 'cnt'= decrement the popped maxheap
                cnt = 1 + heapq.heappop(maxH)
                #if cnt is non zero
                if cnt:
                    #append to q, along with time +n
                    q.append([cnt, time + n])
                    
            #if q is not empty and q[0][1] == currnt time, pop from queue, the [0]
            if q and q[0][1] == time:
                heapq.heappush(maxH, q.popleft()[0])
        return time
        
        