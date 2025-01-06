# // Time Complexity :O(n) 2 pass
# // Space Complexity :O(n) for frequency map
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach


class Solution:
    def leastInterval(self, tasks: list[str], n: int) -> int:
        fmap = {}

        maxfrq =0                               # 1 pass to add latest prequencies
        for i in tasks:
            if i in fmap:
                fmap[i] +=1
                maxfrq = max(maxfrq,fmap[i])
            else:
                fmap[i] = 1

        maxcnt = 0
        for i in fmap:                          # 2nd pass to identify the how many tasks have same max frq
            if fmap[i] == maxfrq:
                maxcnt += 1

        partitions = maxfrq - 1                     # ex: A _ _  A _ _ A _ _ A
        available =  partitions * (n-(maxcnt-1))    # av: 6
        pending = len(tasks) - (maxfrq *maxcnt)     # pend: all - A's
        idle = max(0, available-pending)            # extras slots required

        return len(tasks) + idle