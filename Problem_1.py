"""
Time Complexity : O(len of tasks)- for calculating maxfrequency and max count
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Here, the major impact would be from the character which occrs the most. So, to calculate this, we would calculate
the frequency of all the tasks and the task with most frequency(might be more than 1, maxcount in code). 
After this, we have maxfreq(highest freq of a character) and maxcount(number of chars with max freq).
Firstly, we need to calculate the number of partitions (gaps) between the highest frequency chars after placing them.
It would be 1 less than the max freq. Now we need to fill these partitions, but before that, how many slots
are empty? After calculating that, we need to calculate how many tasks are actually pending, so that we 
can articulate the number of slots that we can leave blank. These blanks when added to total length of
tasks gives is the least time required. 
"""


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        d = {}
        maxfrq = 0
        for t in tasks:
            if t in d:
                d[t] += 1
            else:
                d[t] = 1
            maxfrq = max(maxfrq, d[t])
        maxcount = 0
        for i in d:
            if d[i] == maxfrq:
                maxcount += 1
        total = len(tasks)
        partitions = maxfrq-1
        empty = partitions*(n-maxcount+1)
        pending = total - (maxcount*maxfrq)
        idle = max(0, empty-pending)
        return total+idle
