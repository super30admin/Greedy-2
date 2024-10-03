# Time complexity - O(n)
# Space complexity - O(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hmap = dict()
        max_freq = 0
        max_cnt = 0
        t = len(tasks)
        # create frequncy map and get max_freq
        for each in tasks:    
            hmap[each] = hmap.get(each,0) + 1
            max_freq = max(max_freq,hmap[each])
        # iterate to find the count of max freqs
        for k,v in hmap.items():
            if v == max_freq:
                max_cnt += 1
        paritions = max_freq - 1
        available = paritions * (n - (max_cnt - 1))
        pending = t - (max_freq * max_cnt) # scheduled tasks
        idle = max(0, available - pending)
        return t + idle
