
#Time Complexity : O(n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hm = {}
        maxfreq = 0
        maxcount = 0
        for i in tasks:
            if i in hm.keys():
                hm[i] += 1
            else:
                hm[i] = 1
            maxfreq = max(maxfreq, hm[i])
        for i in hm.keys():
            if hm[i] == maxfreq:
                maxcount += 1
        part = 0
        empty = pending = idle = 0
        part = maxfreq-1
        empty = part*(n-(maxcount-1))
        pending = len(tasks) - (maxfreq*maxcount)
        idle = max(0, empty - pending)
        return len(tasks)+idle
        