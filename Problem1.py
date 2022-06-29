#Time Complexity : O(N)
#Space Complexity : O(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        arr = [0] * 26
        
        for i in tasks:
            arr[ord(i) - ord('A')] += 1
        
        arr.sort()
        maxx = arr.pop()
        
        idle = (maxx - 1) * n
        
        while arr and idle > 0:
            idle -= min(maxx - 1, arr.pop()) 
            
        idle = max(0,idle)
        
        return idle + len(tasks)