#Task Scheduler
# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hmap={}
        for i in tasks:
            hmap[i] = hmap.get(i, 0)+1
        max_freq = max(hmap.values())
        max_counter=0
        for i in hmap:
            if hmap[i]==max_freq:
                max_counter+=1
        permutation = max_freq - 1
        idle_length = n+1
        intervals = permutation * idle_length + max_counter
        return max(intervals, len(tasks))
        