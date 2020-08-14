--------------------------least Interval------------------------------------------
# Time Complexity : O(2N) as N is length of people 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we will check the maxfreq character and how many character with max freq as maxcount. Then we will caluculate the
# Number of partitions as maxFreq-1, number of empty slots as total distance minus the number of maxchars -1 as we
# will always provide one char and multiply it with number of partitions. Once we find the number of empty, we will calu
# number of pending elements, we will subtract from total length with maxfreq and count. Once we get empty slots,
# we will caluculate the idle positions, as empty - pending. idle cannot be negative as it exists or does not exists. so if it is negative 
# we will make it as 0. Then return len(tasks)+idle positions. 

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks:
            return 0
        
        d = Counter(tasks)
        maxFreq = max(d.values())
        
        count = 0
        for k, v in d.items():
            if v == maxFreq:
                count +=1
            
        partitions = maxFreq -1
        empty = (n-(count-1))*partitions
        pending = len(tasks) - maxFreq*count
        idle = max(0, empty-pending)
        return idle+len(tasks)