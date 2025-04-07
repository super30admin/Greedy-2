# Problem 1 : Task Scheduler
# Time Complexity : O(N) where N is the size of tasls list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from collections import defaultdict
from typing import List
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # define frequency map hash map where key is task and value is frequency in the list
        freqMap = defaultdict(int)
        # maxFreq is the maximum value of frequency
        maxFreq = 0

        # loop though tasks list
        for task in tasks:
            # increment the value of task key in freqMap
            freqMap[task] += 1
            # store the maximum value between maxFreq and value of task key in FreqMap
            maxFreq = max(maxFreq, freqMap[task])
        
        # value of number of keys which have highest frequency
        maxCount = 0
        # loop through all the values in the hashmap
        for freq in freqMap.values():
            # check if the frequency is same as maxFreq and if it is then increment the maxCount
            if freq == maxFreq:
                maxCount += 1
        # get the number of partition between highest frequency element
        partition = maxFreq - 1
        # get the number of available idle slots that need to  be filled with lower frequency element or with idle time
        # n is the number of slots between two same task and (maxCount - 1) gives number of highes frequency task which can place in between
        available = partition * (n - (maxCount - 1))
        # number of remaining task after scheduling the highest frequency task 
        pending = len(tasks) - (maxCount * maxFreq)
        # if available slots is more than pending then we need idle time 
        # to calculate that we take maximum between 0 and (available - pending)
        idle = max(0, available - pending)

        # return the sum of length of task list and idle value
        return len(tasks) + idle
