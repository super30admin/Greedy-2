# Time Complexity : O(n)
# Space Complexity : O(n)

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks: return 0
        l = len(tasks)  
        if n == 0: return l
        
        hashmap = {}     
        for task in tasks:
            if task in hashmap:
                hashmap[task] += 1
            else:
                hashmap[task] = 1
        
        # Calculate max_Freq.      
        max_freq = max(hashmap.values())
        
        # How many vars have max_Freq.
        max_count = 0
        for freq in hashmap.values():
            if freq == max_freq: max_count += 1
        
        partitions = max_freq - 1
        empty = (n - (max_count-1)) * partitions
        available = l - (max_freq * max_count)
        idle = max(0, empty - available)
        result = l + idle
        
        return result