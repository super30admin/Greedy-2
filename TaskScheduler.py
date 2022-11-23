class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hashmap = {}
        
        # making the hashmap
        for task in tasks:
            if task not in hashmap:
                hashmap[task] = 1
            else:
                hashmap[task] += 1
                
        # Getting the maximum frequencies
        max_freq = 0
        for key in hashmap.keys():
            max_freq = max(max_freq, hashmap[key])
        
        # Getting the maximum count
        max_count = 0
        for key in hashmap.keys():
            if hashmap[key] == max_freq:
                max_count += 1
                
        
        partitions = max_freq - 1
        empty = partitions * (n - (max_count - 1))
        pending = len(tasks) - (max_count * max_freq)
        idle = max(0, empty - pending)
        
        return len(tasks) + idle
    
    # Purely math solution
    # TC: O(N)
    # SC: O(1)