class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        count = Counter(tasks)
        maxCount = max(count.values())
        maxFreq = len([i for i in count.values() if i==maxCount])
        numberOfPartitions = maxCount-1
        emptySpots = numberOfPartitions*(n-maxFreq+1)
        remainingSpots = len(tasks) - maxCount*maxFreq
        idleSpots = max(0, emptySpots-remainingSpots)
        return len(tasks) + idleSpots
    
Time: O(n)
Space: O(n)
