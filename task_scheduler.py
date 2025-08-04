
# Time complexity: O(n log n)
# Space complexity: O(n)


from collections import Counter

def leastInterval(tasks, n):
    count = Counter(tasks)
    maxHeap = []
    for task, freq in count.items():
        heapq.heappush(maxHeap, (-freq, task))
    
    time = 0
    queue = []
    
    while maxHeap or queue:
        time += 1
        if maxHeap:
            freq, task = heapq.heappop(maxHeap)
            if freq < -1:
                queue.append((freq + 1, task, time + n))
        if queue and queue[0][2] == time:
            heapq.heappush(maxHeap, queue.pop(0)[:2])
    
    return time


# Time complexity: O(n)
# Space complexity: O(1)

import collections

def leastInterval(tasks, n):
    count = collections.Counter(tasks)
    maxFreq = max(count.values())
    maxFreqTask = list(count.values()).count(maxFreq)
    return max(len(tasks), (maxFreq - 1) * (n + 1) + maxFreqTask)



