#Time Complexity -- O(N)
#Space Complexity -- O(N)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks:
            return 
        
        maxCount = 0
        maxFrequency = 0
        
        temp = collections.Counter(tasks)
        
        for key, val in temp.items():
            maxFrequency = max(maxFrequency, val)
        
        
        for key, val in temp.items():
            if val ==  maxFrequency:
                maxCount += 1
                
        return max(len(tasks), (maxFrequency-1)*(n+1) + maxCount)
        
