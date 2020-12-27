# Time:- O(n)
# Space:- O(1)
# Approach:- If we schedule the tasks with the max_freq the number of groups of idle spots remaining will
# be max_freq-1. No of empty spots will be the number of partitions multiplied by no. of tasks-the number of tasks having maxfreqency. Since the tasks with. the maxfrequency influence the idle slots the pending slots after we are done with scheduling them are no. of tasks- max*freq* maxcount. After all this the 
# no. of idle slots are maximum of empty-pending because the no. of pending tasks can be more than the 
# empty slots we have. In the end the no. of tasks + idle slots only affect the units of times the CPU will take.
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        tasks_map=collections.defaultdict(int)
        max_freq=0
        maxcount=0
        for t in tasks:
            tasks_map[t]+=1
            max_freq=max(max_freq,tasks_map[t])
        for i in tasks_map:
            if tasks_map[i]==max_freq:
                maxcount+=1
        partitions=max_freq-1
        empty=partitions*(n-maxcount+1)
        pending=len(tasks)-max_freq*maxcount
        idle=max(0,empty-pending)
        return len(tasks)+idle
            
        