# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if tasks == None or len(tasks) == 0:
            return 0
        hashmap = {}
        maxFreq, maxCount = 0, 0
        for task in tasks:
            hashmap[task] = hashmap.get(task, 0) + 1
            maxFreq = max(maxFreq, hashmap[task])
        
        for task in hashmap.keys():
            if hashmap[task] == maxFreq:
                maxCount += 1
        
                
        partitions = maxFreq - 1
        available = partitions * (n - (maxCount -1))
        pending = len(tasks) - (maxFreq * maxCount)
        idle = max(0, available - pending)
        return idle + len(tasks)