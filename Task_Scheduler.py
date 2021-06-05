
#from collections import Counter

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks :
            return 0
        
        hashmap = {}
        max_freq = 0
        maxcount = 0
        for i in range(len(tasks)):
            if tasks[i] in hashmap:
                hashmap[tasks[i]] +=1
                if hashmap[tasks[i]] > max_freq:
                    max_freq = hashmap[tasks[i]]
            else:
                hashmap[tasks[i]] = 1

        for value in hashmap.values():
            if value == max_freq:                
                maxcount +=1
            
        
        partitions = max_freq -1        
        empty = (n- (maxcount - 1)) * partitions
        available = len(tasks) - maxcount * max_freq
        idle = max(0, empty - available)
        print(idle)
        return len(tasks) + idle
