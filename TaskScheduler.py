# // Time Complexity :O(T + U) where T is total tasks and U is the number of unique tasks.
# // Space Complexity :O(U) for storing task counts in the hashmap.
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# We find the task(s) that occur the most and figure out how many such max-frequency tasks exist.
# Then we calculate the number of idle slots required between these high-frequency tasks.
# If other tasks can fill those slots, we do, otherwise, we add idle time to the total.

from typing import List
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        map , maxfreq, maxcount = {} ,0, 0
        for c in tasks:
            map[c] = map.get(c,0)+1
            maxfreq = max(maxfreq, map[c])
        
        for c in map:
            if map[c] == maxfreq:
                maxcount+=1
        
        partition = maxfreq-1
        availableslots = partition*(n-(maxcount-1)) 
        pendingslots = len(tasks) - (maxfreq*maxcount)
        idle = max(0,availableslots-pendingslots)
        return idle + len(tasks)
        